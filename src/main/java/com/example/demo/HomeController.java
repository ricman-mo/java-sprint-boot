package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by M93349 on 2018/6/9.
 */
@Controller
public class HomeController {
  @RequestMapping("/index")
  public String viewHome() {
    return "/index";
  }
}
