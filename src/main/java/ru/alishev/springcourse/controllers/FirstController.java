package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname,
                            Model model) {
        model.addAttribute("message", name + " " + surname);
        model.addAttribute("new_message", "Your name is " + name);
        model.addAttribute("q", name + name + name + " " + new Random().nextInt(100));
        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String goodByePage(HttpServletRequest request) {
        String number = request.getParameter("number");
        String month = request.getParameter("month");
        System.out.println(month + " " + number);
        return "first/goodbye";
    }

    @GetMapping("/exit")
    public String exitPage(@RequestParam(value = "age", required = false) String age,
                           @RequestParam(value = "sex", required = false) String sex,
                           @RequestParam(value = "season", required = false) String season) {
        System.out.println(sex + " " + season + " " + age);
        return "first/exit";
    }
}
