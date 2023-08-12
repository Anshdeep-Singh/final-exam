package com.example.finalexam.Repository;

import com.example.finalexam.Entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
