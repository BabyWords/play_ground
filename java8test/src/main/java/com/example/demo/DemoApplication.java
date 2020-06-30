package com.example.demo;

import com.example.demo.feature.TestRunnable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);

		ExecutorService service=Executors.newCachedThreadPool();
		Thread s=new Thread(()->{
			System.out.println("sss");

		});
		s.start();


	}

}
