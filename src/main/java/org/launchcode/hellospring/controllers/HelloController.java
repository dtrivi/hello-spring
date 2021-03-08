package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //To designate a given class as a controller within the Spring framework, place @Controller annotation atop controller class
public class HelloController {

//    //Handle requests at the root path (doesn't have routing info in method) :
//    @GetMapping //annotation tells Spring Boot that this method will only accept 'get requests'.
//    @ResponseBody //annotation tells Spring Boot that this method will return a plain text HTTP response. Doesn't use HTML.
//    public String hello() {
//        return "Hello, Spring!";
//    }

//    //Handle requests at path /hello :
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    //Method says 'goodbye' instead of 'hello' :
    @GetMapping("goodbye")
    @ResponseBody
    public String goodbye() {
        return "Goodbye, Spring!";
    }

    //Handle requests of the form /hello?name=LaunchCode :
    // (note that /hello has to be commented out to run this method since they live at the same path)
    @GetMapping("hello")
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) { //@RequestParam signifies to Spring that this method expects a query param called 'name'. query param and method param have to match
        return "Hello, " + name + "!";
    }

}
