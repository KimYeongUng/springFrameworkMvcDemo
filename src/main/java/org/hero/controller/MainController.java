package org.hero.controller;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
    protected Logger logger= Logger.getLogger(this.getClass());

    @RequestMapping("/")
    public String index(Model model) throws Exception{
        model.addAttribute("greeting","hello world");
        logger.info("index........");
        return "index";

    }

    @RequestMapping("/main.do")
    public String main(){
        logger.info("main......");
        System.out.printf("main\n");
        return "index";
    }

}
