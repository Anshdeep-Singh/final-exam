package com.example.finalexam.Entities;

import com.example.finalexam.Repository.SalesRepository;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Items {

    @Column(name = "Icode")
    private String ItemCode;

    @Column(name = "Idesc")
    private String ItemDescription;

    @Column(name = "Price")
    private String ItemPrice;

    @Column(name = "Catcode")
    private String CategoryCode;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    public String getItemCode() {
        return ItemCode;
    }

    public void setItemCode(String itemCode) {
        ItemCode = itemCode;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
    }

    public String getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(String itemPrice) {
        ItemPrice = itemPrice;
    }

    public String getCategoryCode() {
        return CategoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        CategoryCode = categoryCode;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Items(String itemCode, String itemDescription, String itemPrice, String categoryCode) {
        ItemCode = itemCode;
        ItemDescription = itemDescription;
        ItemPrice = itemPrice;
        CategoryCode = categoryCode;
    }
}
