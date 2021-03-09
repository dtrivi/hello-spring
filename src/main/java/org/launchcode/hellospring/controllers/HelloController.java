package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chris Bay
 */
@Controller
public class HelloController {

    // Responds to /hello?name=LaunchCode (uses query parameter or POST parameter)
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String name, Model model) { // To pass variable into our view (of MVC), we need the Model object. Model class is used to pass data between controller and view
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting); // Local variable on line 16 has to match up with second parameter we're passing through in line 17 (the second 'greeting'). First argument to 'model.addAttribute' needs to match up with variable name we're referencing in our template.
        return "hello";
    }

    // Responds to /hello/LaunchCode
    // Since this returns the same view as our /hello handler, we can use the same template we used in /hello. Remove @ResponseBody, return templateName, then create local variable to hold something we want to pass into the view, then add that local variable to the model.
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        String greeting = "Hello, " + name + "!";
        model.addAttribute("greeting", greeting);
        return "hello";
    }

    @GetMapping("form") // removed @ResponseBody since we're no long returning a string. we want SpringBoot to go find a template named "form". once we use templates, we won't use @ResponseBody annotations. When SpringBoot sees a String returned out of a response handler, it assumes that's the name of a template and tries to find a template. @ResponseBody is the exception.
    public String helloForm() {
        return "form"; // returns form.html (name of template), but html is implied so just need to type the String "form"
    }

    @GetMapping("hello-names")
    public String helloNames(Model model) { // To pass our list of names into a template, we need a Model object.
        List<String> names = new ArrayList<>(); // Need to pass in a list of names into hello-list.html. So, we construct a list that has a collection of names here.
        names.add("LaunchCode");
        names.add("Java");
        names.add("JavaScript");
        model.addAttribute("names", names); // Again, these two values don't have to be called the same thing here. What matters is the first argument is the variable the template will see, while the second argument is the value that variable should have.
        return "hello-list";
    }

}
