package com.example.finalexam.Repository;

import com.example.finalexam.Entities.Sales;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SalesRepository extends JpaRepository<Sales,Long> {

    List<Sales> findSalesById (long kw);
}
