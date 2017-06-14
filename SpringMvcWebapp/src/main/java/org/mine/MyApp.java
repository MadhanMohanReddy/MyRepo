package org.mine;

import org.mine.components.MyComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by madhan.reddy on 4/27/2017.
 */
@EnableWebMvc //mvc:annotation-driven
@Configuration
@ComponentScan({"org.mine"})
public class MyApp extends WebMvcConfigurerAdapter {
  //  @Override
  //  public void addFormatters(FormatterRegistry formatterRegistry) {
  //    formatterRegistry.addConverter(new MyConverter());
  //  }
  //
  //  @Override
  //  public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
  //    converters.add(new MyHttpMessageConverter());
  //  }
}
