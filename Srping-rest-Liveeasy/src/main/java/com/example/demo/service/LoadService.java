package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Load;
import com.example.demo.repository.LoadRepository;

@Service
public class LoadService {

    @Autowired
    private LoadRepository loadRepository;

    // Get all loads
    public List<Load> getAllLoads() {
        return (List<Load>) loadRepository.findAll();
    }

    // Get load by ID
    public Load getLoadById(int id) {
        return loadRepository.findById(id);
    }

    // Add a new load
    public Load addLoad(Load load) {
        return loadRepository.save(load);
    }

    // Update load
    public void updateLoad(Load load, int id) {
        load.setId(id);
        loadRepository.save(load);
    }

    // Delete load by ID
    public void deleteLoad(int id) {
        loadRepository.deleteById(id);
    }
}
