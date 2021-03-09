package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Chris Bay
 */
@Controller
@ResponseBody
@RequestMapping("hello")
public class HelloController {

    //    // Handle request at path /hello
//    @GetMapping("hello")
//    @ResponseBody
//    public String hello() {
//        return "Hello, Spring!";
//    }

    // lives at /hello/goodbye
    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

//    // Handles requests of the form /hello?name=LaunchCode
//    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
//    public String helloWithQueryParam(@RequestParam String name) {
//        return "Hello, " + name + "!";
//    }

    // Handles requests of the form /hello/LaunchCode
    @GetMapping("{name}")
    public String helloWithPathParam(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

//    // /hello/form
//    @GetMapping("form")
//    public String helloForm() {
//        return "<html>" +
//                "<body>" +
//                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
//                "<input type = 'text' name = 'name' >" +
//                "<input type = 'submit' value = 'Greet Me!' >" +
//                "</form>" +
//                "</body>" +
//                "</html>";
//    }

    // /hello (?)
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST})
    public static String createMessage(@RequestParam String name, String language) {
        if (language.equals("english")) {
            return "Hello, " + name + "!";
        } else if (language.equals("spanish")) {
            return "¡Hola, " + name + "!";
        } else if (language.equals("italian")) {
            return "Ciao, " + name + "!";
        } else if (language.equals("french")) {
            return "Salut " + name + "!";
        } else if (language.equals("croatian")) {
            return "Pozdrav, " + name + "!";
        } else {
            return "You didn't pick a language, " + name + ". What are you? A dingus?";
        }
    }

    // /hello/form
    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "form")
    public String helloForm() {
        return "<html>" +
                "<body>" +
                "<form action = '/hello' method = 'post'>" + // submit a request to /hello
                "<input type = 'text' name = 'name' >" +
                "<label for = 'language'>Choose language:</label>" +
                "<select name = 'language' id = 'language'>" +
                    "<option value = ''>---</option>" +
                    "<option value = 'english'>English</option>" +
                    "<option value = 'spanish'>Spanish</option>" +
                    "<option value = 'italian'>Italian</option>" +
                    "<option value = 'french'>French</option>" +
                    "<option value = 'croatian'>Croatian</option>" +
                "<input type = 'submit' value = 'Greet Me!' >" +
                "</form>" +
                "</body>" +
                "</html>";
    }

}
