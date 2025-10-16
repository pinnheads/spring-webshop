package com.da.da_25_26;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

  @GetMapping("/hello")
  public String index() {
    return "Hello World from SpringFramework!";
  }

}
