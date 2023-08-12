package com.example.finalexam.Entities;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Sales {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "recno")
    private String ReceiptNumber;

    @Column(name = "icode")
    private String ItemCode;

    @Column(name = "qty")
    private double Quantity;

    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(name = "dot")
    private Date DateOfSale;


    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
