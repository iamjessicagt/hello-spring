package org.launchcode.hellospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {

//     Responds to get and post requests at /hello?coder=LaunchCoder
    @RequestMapping(value = "hello", method = {RequestMethod.GET, RequestMethod.POST})
    public String hello(@RequestParam String coder, @RequestParam String language, Model model) {
        model.addAttribute("greeting", createMessage(coder, language));
        return "hello";
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
        return "form";
    }

    // Responds to get requests at /hello/LaunchCode
    @GetMapping("hello/{name}")
    public String helloAgain(@PathVariable String name, Model model) {
        String message = "Hello, " + name + "!";
        model.addAttribute("greeting", message);
        return "hello";
    }

    @GetMapping("goodbye")
    public String goodbye(Model model) {
        String message = "Goodbye, Spring!";
        model.addAttribute("greeting", message);
        return "hello" ;
    }

    @GetMapping("hello-names")
    public String helloNames(Model model){
        List<String> names = new ArrayList<>();
        names.add("LaunchCoder");
        names.add("Jessica");
        names.add("Juanito");
        names.add("Jackson");
        names.add("Andreas");
        model.addAttribute("names", names);
        return "hello-list";
    }

}
