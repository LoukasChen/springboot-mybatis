package com.csp.config;

import com.csp.Filter.WordsFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

 @Bean
 public FilterRegistrationBean wordsFilterRegistrationBean(){
     FilterRegistrationBean bean = new FilterRegistrationBean();
     bean.setFilter(new WordsFilter());
     bean.addUrlPatterns("/*");
     return bean;
 }
}
