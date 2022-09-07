package br.com.habbora.alura.forum.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/helloword")
public class HelloWordController {

    @GetMapping
    @ResponseBody
    String getHelloWord() {
        return "Get Hello Word";
    }

}
