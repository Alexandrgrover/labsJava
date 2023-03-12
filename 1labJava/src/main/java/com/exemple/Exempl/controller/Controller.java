package com.exemple.Exempl.controller;
import com.exemple.Exempl.Json;
import com.exemple.Exempl.Polinom;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("findPolinom/")
public class Controller {
    @GetMapping("{str}")
    public Json getJson(@PathVariable String str){
        return Polinom.findPolinom(str);
    }
}
