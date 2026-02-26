package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "demo")
public class Demo {
    @Id
    private Long id;
    private String name;
    private String age;

    public Demo(String name, String age, Long id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    public Demo() {

    }

}
