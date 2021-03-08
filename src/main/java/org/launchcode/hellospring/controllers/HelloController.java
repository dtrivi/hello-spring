package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    //Handle requests from query parameters of the form /hello?name=LaunchCode :
    // (note that /hello has to be commented out to run this method since they live at the same path)
//    @GetMapping("hello")
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "hello") //@RequestMapping is more general mapping annotation. Putting the types or requests in annotation params specifies which types of requests a @RequestMapping will accept
    @ResponseBody
    public String helloWithQueryParam(@RequestParam String name) { //@RequestParam signifies to Spring that this method expects a query param called 'name'. query param and method param have to match
        return "Hello, " + name + "!";
    }

    //Handle requests where variable is part path, not query ... of the form /hello/LaunchCode :
    @GetMapping("hello/{name}") //put '/' after hello and variable 'name' in curly brackets to signify you want this to accept piece of data in path
    @ResponseBody
    public String helloWithPathParam(@PathVariable String name) { //@PathVariable tells SpringBoot that handler method is looking for a request to /hello/name where the name can be anything and we're going to take the value of that 'name' and place it in the method param 'name'.
        return "Hello, " + name + "!";
    }

//    //Method to display a form :
//    //*note: form element itself (line 55) does not have a method attribute like 'method='get''. default method is GET, which we're set up for with our helloWithQueryParam handler being set up with @GetMapping for get requests
//    @GetMapping("form")
//    @ResponseBody
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action='hello'>" + //'action' tells form to submit request to /hello. we can do this because we already created a handler method that can dynamically create requests with the query parameter called name (found in method helloWithQueryParam), so we already have the HTTP handler we need
//                "<input type='text' name='name'>" + //'name' to left of '=' is the param identifier used to submit what's in the form input, and 'name' to right of '=' is just what we're calling that. our form has a single input called 'name' (right of '='? or both sides?), and we have a request handler that accepts requests at the same path with a query param called 'name'.
//                "<input type='submit' value='Greet me!'>" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    @GetMapping("form")
    @ResponseBody
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action='hello' method='post'>" + //changed mapping annotation for helloWithQueryParam from @GetMapping to @RequestMapping so we can use the method='post'
                "<input type='text' name='name'>" +
                "<input type='submit' value='Greet me!'>" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
