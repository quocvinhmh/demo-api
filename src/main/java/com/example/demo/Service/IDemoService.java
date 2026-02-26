package com.example.demo.Service;

import com.example.demo.entity.Demo;

import java.util.List;

public interface IDemoService {
    List<Demo> getAll();
    Demo getById(Long id);
    void save(Demo demo);
    void delete(Long id);
    void update(Demo demo);
}
