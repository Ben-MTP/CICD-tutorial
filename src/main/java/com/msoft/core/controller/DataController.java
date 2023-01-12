package com.msoft.core.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ManhKM on 1/12/2023
 * @project cicd-tutorial
 */
@Controller
public class DataController {

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String hello(){
    return "hello";
  }

  /**
   * Controller display form
   * @return
   */
  @RequestMapping(value = "/hello-form", method = RequestMethod.GET)
  public String helloForm(){
    return "hello_form";
  }

  @RequestMapping(value = "/process-form", method = RequestMethod.GET)
  public String processForm(@RequestParam(name = "name") String name,
      @RequestParam(name = "age") Integer age){
    System.out.println("parameter | name: " + name + " ,age: " + age);

    return "hello_form_display";
  }
}
