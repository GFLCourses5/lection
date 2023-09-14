package com.example.demo.aop;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/test")
public class AOPController {
    private final AOPService aopService;

    public AOPController(AOPService aopService) {
        this.aopService = aopService;
    }

    @GetMapping(path = "/1/{msg}")
    public ResponseEntity<Void> get(@PathVariable(value = "msg") String message) throws Exception {
        aopService.testService(message);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/2/{msg}")
    public ResponseEntity<Void> get1(@PathVariable(value = "msg") String message) throws InterruptedException {
        aopService.testService(message, 1);
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/3/{msg}")
    public ResponseEntity<Void> get2(@PathVariable(value = "msg") String message) throws InterruptedException {
        aopService.testService(message, false);
        return ResponseEntity.ok().build();
    }
}
