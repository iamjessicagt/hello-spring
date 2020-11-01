package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
public class HelloController {

    // Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String coder, @RequestParam String language) {
        return createMessage(coder, language);
    }

    public static String createMessage(String coder, String language){
        String message;
        if (language.equals("spanish")) {
            message = "Hola, " + coder + "!";
        } else if (language.equals("portuguese")) {
            message = "Oi, " + coder + "!";
        } else if (language.equals("french")) {
            message = "Bonjuor, " + coder + "!";
        } else if (language.equals("italian")) {
            message = "Ciao, " + coder + "!";
        } else if (language.equals("german")) {
            message = "Hallo, " + coder + "!";
        } else {
            message = "Hello, " + coder + "!";
        }
        return message;
    }

    @GetMapping
    public String helloForm() {
        String html =
                "<html>" +
                        "<body>" +
                        "<form method = 'POST' action = '/hello'>" +
                        "<input type = 'text' name = 'coder'>" +
                        "<label for='languages'>Choose a language:</label>" +
                        "<select name='language'>" +
                            "<option value=''>--Please choose a language--</option>" +
                            "<option value='spanish'>Spanish</option>" +
                            "<option value='portuguese'>Portuguese</option>" +
                            "<option value='french'>French</option>" +
                            "<option value='italian'>Italian</option>" +
                            "<option value='german'>German</option>" +
                        "</select>" +
                        "<input type = 'submit' value = 'Greet Me!'>" +
                        "</form>" +
                        "</body>" +
                        "</html>";
        return html;
    }

    // Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @GetMapping("goodbye")
    public String goodbye() {
        return "Goodbye, Spring!";
    }

}
