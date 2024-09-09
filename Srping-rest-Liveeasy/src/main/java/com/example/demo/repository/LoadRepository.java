package com.example.demo.repository;


import org.springframework.data.repository.CrudRepository;

import com.example.demo.entity.Load;



public interface LoadRepository extends CrudRepository<Load, Integer> {
    Load findById(int id);
}


