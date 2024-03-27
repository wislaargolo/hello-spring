package br.com.ufrn.helloworld.controller;

import br.com.ufrn.helloworld.negocio.HelloNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloRestController {

    @Autowired
    private HelloNegocio negocio;

    @GetMapping("/hellorest")
    public String helloRest(@RequestParam(name="name", required=false, defaultValue="World") String name) {
        return negocio.message(name);
    }
}
