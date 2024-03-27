package br.com.ufrn.helloworld.controller;

import br.com.ufrn.helloworld.dto.Greeting;
import br.com.ufrn.helloworld.negocio.HelloNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.concurrent.atomic.AtomicLong;

@Controller
public class HelloMVCController {

    @Autowired
    private HelloNegocio negocio;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hellomvc")
    public String greeting(@RequestParam(name="name", required = false, defaultValue="World") String name, Model model) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), negocio.message(name));
        model.addAttribute("greeting", greeting);
        return "hello";
    }

}