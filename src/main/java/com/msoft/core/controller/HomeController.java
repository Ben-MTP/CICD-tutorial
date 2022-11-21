package com.msoft.core.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ManhKM on 11/21/2022
 * @project cicd-tutorial
 */
@RestController
public class HomeController {

  @RequestMapping("/")
  public String getIndex(){
    return "CICD Tutorial Step by Step";
  }
}
