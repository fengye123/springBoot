package org.honglan.deno.service;

import javax.annotation.Resource;

import org.honglan.deno.config.DBSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
@EnableAutoConfiguration
public class SampleController {
 
    @Value("${name}")
    private String name;

    
    @RequestMapping("/")
    @ResponseBody
    String home() {
    return String.format("Hello %s!", name);
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }
    
    @RequestMapping("/db")
    @ResponseBody
    String getDbConfig(){
        
    
        DBSettings dbconfig=new DBSettings();
    	return dbconfig.toString();
    }
}