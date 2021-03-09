package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    // Responds to /hello?name=LaunchCode
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    @ResponseBody
    public String hello(@RequestParam String name) {
        return "Hello, " + name + "!";
    }

    // Responds to /hello/LaunchCode
    @GetMapping("hello/{name}")
    @ResponseBody
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }


    @GetMapping("form") // removed @ResponseBody since we're no long returning a string. we want SpringBoot to go find a template named "form". once we use templates, we won't use @ResponseBody annotations. When SpringBoot sees a String returned out of a response handler, it assumes that's the name of a template and tries to find a template. @ResponseBody is the exception.
    public String helloForm() {
        return "form"; // returns form.html (name of template), but html is implied so just need to type the String "form"
    }

}
