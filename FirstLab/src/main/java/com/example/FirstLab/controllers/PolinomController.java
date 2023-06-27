package com.example.FirstLab.controllers;

import com.example.FirstLab.core.Result;
import com.example.FirstLab.core.SingleErrorResponse;
import com.example.FirstLab.services.api.ICounter;
import com.example.FirstLab.services.api.IPolinomService;
import jakarta.validation.constraints.NotBlank;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;

@RestController
public class PolinomController {
    private static final Logger logger = LoggerFactory.getLogger(PolinomController.class);
    private final IPolinomService service;

    private final ICounter counter;

    public PolinomController(IPolinomService service, ICounter counter) {
        this.service = service;
        this.counter = counter;
    }

    @GetMapping("/task")
    public ResponseEntity<Result> findPolinom(@RequestParam String str) {
        counter.increment();
        logger.info("Enter in get point");
        if (str.isBlank()) {
            throw new SingleErrorResponse("error", "str is empty");
        }
        return ResponseEntity.status(200).body(service.isPolinom(str));
    }

    @GetMapping("/count")
    public ResponseEntity<Long> getCount() {
        return ResponseEntity.status(200).body(counter.getCount());
    }

    @PostMapping("/saveAll")
    public ResponseEntity<Map<String,Result>> saveAll(@Validated @NotBlank @RequestBody List<String> list){
        CompletableFuture.runAsync(()->service.saveAll(list));
        logger.info("skip save in main thread");
        return ResponseEntity.status(201).body(service.getStatistic(list));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Result>> getAll(){
        return ResponseEntity.status(200).body(service.getAll());
    }
}
