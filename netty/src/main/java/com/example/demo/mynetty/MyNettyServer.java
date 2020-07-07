package com.example.demo.mynetty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.string.StringDecoder;

public class MyNettyServer {

  public static void main(String args[]) {
    startServer();

  }
  public static void startServer(){
    ServerBootstrap serverBootstrap = new ServerBootstrap();
    NioEventLoopGroup executors = new NioEventLoopGroup();
    NioEventLoopGroup worker = new NioEventLoopGroup();

    serverBootstrap.group(executors,worker)
        .channel(NioServerSocketChannel.class)
//        .handler(new ChannelInitializer<SocketChannel>() {
//          @Override
//          protected void initChannel(SocketChannel ch) throws Exception {
//            System.out.println("get link success");
//
//          }
//        })a
        .childHandler(new ChannelInitializer<SocketChannel>() {
          @Override
          protected void initChannel(SocketChannel ch) throws Exception {
            ch.pipeline().addLast(new StringDecoder());
            ch.pipeline().addLast(new SimpleChannelInboundHandler<String>() {
              @Override
              protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
                System.out.println("hahaha");
              }
            });
          }
        });
    serverBootstrap.bind(8080);
  }
}
