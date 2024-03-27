package br.com.ufrn.helloworld.negocio;

import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class HelloNegocio {
    public String message(String name){
        if (name == null) {
            name = "world";
        }

        Integer now = LocalTime.now().getHour();
        String message;

        if (now < 12) {
            message = "Good morning";
        } else if (now < 18) {
            message = "Good afternoon";
        } else {
            message = "Good evening";
        }

        return String.format("Hello. %s, %s!", message, name);
    }
}
