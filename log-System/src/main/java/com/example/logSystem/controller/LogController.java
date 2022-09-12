package com.example.logSystem.controller;

import com.example.logSystem.entity.Log;
import com.example.logSystem.service.LogService;
import com.example.logSystem.utils.Action;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/log")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/{id}")
    public Optional<Log> findById(@PathVariable String id) {
        return logService.findById(id);
    }

    @GetMapping
    public List<Log> findAll() {
        return logService.findAll();
    }

    @GetMapping("/action/{id}")
    public Optional<Log> findByAction(@PathVariable Action id) {
        return logService.findByAction(id);
    }

    @GetMapping("/user/{id}")
    public Optional<Log> findByuser(@PathVariable String userId) {
        return logService.findByUser(userId);
    }
}
