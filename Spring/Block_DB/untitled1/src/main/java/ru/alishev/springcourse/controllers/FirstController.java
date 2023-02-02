package ru.alishev.springcourse.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Controller
@RequestMapping("/first")
public class FirstController {

    @GetMapping("/hello")
    public String helloPage(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "surname", required = false) String surname, Model model) {

        //System.out.println("Hello, " + name + " " + surname);
        model.addAttribute("message", "Hello, " + name + " " + surname);

        return "first/hello";
    }

    @GetMapping("/goodbye")
    public String doodByePage() {
        return "first/goodbye";
    }

//    @GetMapping("/calculator")
//    public String calculatorPage(@RequestParam(value = "a", required = false) String a,
//                                 @RequestParam(value = "b", required = false) String b,
//                                 @RequestParam(value = "mul", required = false) String mul, Model model) {
//
//        int A = Integer.parseInt(a);
//        int B = Integer.parseInt(b);
//        int c = 0;
//
//        if (mul.equals("plus")){
//            c = A + B;
//        }
//        if (mul.equals("minus")){
//            c = A - B;
//        }
//        if (mul.equals("add")){
//            c = A * B;
//        }
//        if (mul.equals("del")){
//            c = A / B;
//        }
//
//        model.addAttribute("mes", "Result: " + c);
//
//
//        return "first/calculator";
//    }

    @GetMapping("/calculator")
    public String calculator(@RequestParam("a") int a, @RequestParam("b") int b,
                             @RequestParam("action") String action, Model model) {
        double result;
        switch (action) {
            case "multiplication":
                result = a * b;
                break;
            case "division":
                result = a / (double)b;
                break;
            case "subtraction":
                result = a - b;
                break;
            case "addition":
                result = a + b;
                break;
            default:
                result = 0;
                break;
        }

        model.addAttribute("mes","Result: " + result);

        return "first/calculator";
    }

}
