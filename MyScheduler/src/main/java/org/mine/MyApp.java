package org.mine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by madhan.reddy on 4/26/2017.
 */
@SpringBootApplication
@EnableScheduling
public class MyApp {

  public static void main(String[] args) throws Exception {
    SpringApplication.run(MyApp.class);
  }
}