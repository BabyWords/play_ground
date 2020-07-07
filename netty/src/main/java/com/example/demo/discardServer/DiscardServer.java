package com.example.demo.discardServer;

import io.netty.bootstrap.ServerBootstrap;

import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Discards any incoming data.
 */
public class DiscardServer {

  private int port;

  public DiscardServer(int port) {
    this.port = port;
  }

  public void run() throws Exception {
    /**
     * netty 可以通过改写eventloop 的大小来切换reactor所对应的三种模式:
     * 1.单线程模式-> 一个线程工作
     * 2.多线程模式-> worker 是多线程
     * 3.主从多线程模式 -> boss 和worker 都是多线程
     * 需要注意的是,这里的多线程并不是指handler,因为handler 永远是多个
     * 这里的多线程指的是接受请求,建立连接,分配请求的线程,即reactor线程
     * 2020/7/1 Jason_Wu
     */
    EventLoopGroup bossGroup = new NioEventLoopGroup(); // 可以理解为监听线程
    EventLoopGroup workerGroup = new NioEventLoopGroup();  //可以理解为工作线程,这里是多线程的
    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap(); // (2)
      serverBootstrap.group(bossGroup, workerGroup) //这个是注册dispatcher 的意思?
          .channel(NioServerSocketChannel.class) // (3)
          .childHandler(new ChannelInitializer<SocketChannel>() { // (4)
            @Override
            public void initChannel(SocketChannel ch) throws Exception {
              ch.pipeline().addLast(new DiscardServerHandler());
            }
          })
          .option(ChannelOption.SO_BACKLOG, 128)          // (5)
          .childOption(ChannelOption.SO_KEEPALIVE, true); // (6)

      // Bind and start to accept incoming connections.
      ChannelFuture f = serverBootstrap.bind(port).sync(); // (7)

      // Wait until the server socket is closed.
      // In this example, this does not happen, but you can do that to gracefully
      // shut down your server.
      f.channel().closeFuture().sync();
    } finally {
      workerGroup.shutdownGracefully();
      bossGroup.shutdownGracefully();
    }
  }

  public static void main(String[] args) throws Exception {
    int port = 8080;
    if (args.length > 0) {
      port = Integer.parseInt(args[0]);
    }

    new DiscardServer(port).run();
  }
}
