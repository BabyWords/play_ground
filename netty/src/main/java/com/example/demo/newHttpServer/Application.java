package com.example.demo.newHttpServer;

public class Application {

  public static void main(String[] args) throws Exception{
    HttpServer server = new HttpServer(8081);// 8081为启动端口
    server.start();
  }
}