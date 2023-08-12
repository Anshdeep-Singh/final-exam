package com.example.finalexam.Repository;

import com.example.finalexam.Entities.Items;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ItemRepository extends JpaRepository<Items,Long> {


}
