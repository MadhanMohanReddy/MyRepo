package org.mine.components;

import org.springframework.stereotype.Component;

/**
 * Created by madhan.reddy on 4/27/2017.
 */
@Component
public class MyComponent2 implements MyComponent {
  public String hello() {
    return "hello maddy2";
  }
}
