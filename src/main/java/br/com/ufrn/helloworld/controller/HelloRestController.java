package br.com.ufrn.helloworld.controller;

import br.com.ufrn.helloworld.dto.Greeting;
import br.com.ufrn.helloworld.negocio.HelloNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRestController {

    @Autowired
    private HelloNegocio negocio;

    private final AtomicLong counter = new AtomicLong();

    @GetMapping("/hellorest")
    public Greeting greeting(@RequestParam(value = "name", required=false, defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), negocio.message(name));
    }
}
