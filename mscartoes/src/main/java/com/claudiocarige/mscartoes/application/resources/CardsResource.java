package com.claudiocarige.mscartoes.application.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cards")
public class CardsResource {
 
    @GetMapping
    public String status(){
        return "Cartões ok";
    }
}
