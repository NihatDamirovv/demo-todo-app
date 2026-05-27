package com.nihat.demo.repository;

import com.nihat.demo.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    List<Todo> findByUserId(Long userId); // Ancaq daxil olan userin tasklarını gətirmək üçün
}