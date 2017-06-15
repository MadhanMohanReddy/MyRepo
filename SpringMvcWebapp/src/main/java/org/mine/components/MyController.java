package org.mine.components;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by madhan.reddy on 4/27/2017.
 */
@RestController
public class MyController {
  //@Autowired
  //@Autowired(required = false)
  @Autowired
  @Qualifier("MyComponent1")
  private MyComponent1 myComponent;

  @GetMapping("/sayHello")
  public String sayHello() {
    return myComponent.hello();
  }
}
