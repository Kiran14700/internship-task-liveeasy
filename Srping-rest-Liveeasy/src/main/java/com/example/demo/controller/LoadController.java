package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Load;
import com.example.demo.service.LoadService;

@RestController
public class LoadController {

    @Autowired
    private LoadService loadService;

    // Get all loads
    @GetMapping("/load")
    public ResponseEntity<List<Load>> getAllLoads() {
        List<Load> loads = loadService.getAllLoads();
        if (loads.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(loads);
    }

    // Get load by ID
    @GetMapping("/load/{loadid}")
    public ResponseEntity<Load> getLoadById(@PathVariable("id") int loadid) {
        Load load = loadService.getLoadById(loadid);
        if (load == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(load));
    }

    // Add a new load
    @PostMapping("/load")
    public ResponseEntity<Load> addLoad(@RequestBody Load load) {
        try {
            Load savedLoad = loadService.addLoad(load);
            return ResponseEntity.of(Optional.of(savedLoad));
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Update load by ID
    @PutMapping("/load/{loadid}")
    public ResponseEntity<Load> updateLoad(@RequestBody Load load, @PathVariable("loadid") int loadid) {
        try {
            loadService.updateLoad(load, loadid);
            return ResponseEntity.ok().body(load);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    // Delete load by ID
    @DeleteMapping("/load/{loadid}")
    public ResponseEntity<Void> deleteLoad(@PathVariable("loadid") int loadid) {
        try {
            loadService.deleteLoad(loadid);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
