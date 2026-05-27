package com.nihat.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "todos")
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private boolean completed = false;

    private Long userId; // Tapşırığın hansı istifadəçiyə aid olduğunu bilmək üçün
}