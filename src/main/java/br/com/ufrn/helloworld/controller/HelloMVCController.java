package br.com.ufrn.helloworld.controller;

import br.com.ufrn.helloworld.negocio.HelloNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloMVCController {

    @Autowired
    private HelloNegocio negocio;

    @GetMapping("/hellomvc")
    public String greeting(@RequestParam(name="name", required = false, defaultValue="World") String name, Model model) {
        model.addAttribute("message", negocio.message(name));
        return "hello";
    }

}