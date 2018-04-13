package com.springboot;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloWorld {
	
	@RequestMapping("/hello")
    String home(HttpServletRequest httpServletRequest) {
		
        return httpServletRequest.getRemoteAddr();
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HelloWorld.class, args);
    }

}
