package com.example.demo.Repository;

import com.example.demo.entity.Demo;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IDemoRepository extends JpaRepository<Demo, Long> {
}