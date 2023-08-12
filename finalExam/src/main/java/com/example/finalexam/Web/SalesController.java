package com.example.finalexam.Web;

import com.example.finalexam.Entities.Category;
import com.example.finalexam.Entities.Items;
import com.example.finalexam.Entities.Sales;
import com.example.finalexam.Repository.CategoryRepository;
import com.example.finalexam.Repository.ItemRepository;
import com.example.finalexam.Repository.SalesRepository;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@SessionAttributes({"a","e"})
@Controller
@AllArgsConstructor
public class SalesController {

    @Autowired
    private SalesRepository salesRepository;

    private CategoryRepository categoryRepository;

    private ItemRepository itemRepository;
    static int num = 0;

    @GetMapping(path="/main")
    public String sales(Model model, @RequestParam(name="keyword",defaultValue = "")
    String keyword){
//
        List<Sales> salesList;
        List<Category> categoryList;
        List<Items> itemsList;
        itemsList = itemRepository.findAll();
        categoryList = categoryRepository.findAll();

        System.out.println(itemsList + "");


        if (keyword.isEmpty()) {
            salesList = salesRepository.findAll();
        } else {
            long key = Long.parseLong(keyword);
            salesList = salesRepository.findSalesById(key);
        }

        model.addAttribute("salesList", salesList);
        model.addAttribute("categoryList", categoryList);
        model.addAttribute("itemsList", itemsList);
        return "MainPage";
    }

    @PostMapping(path = "/saveSale")
    public String saveSales(@RequestParam("receiptNumber") String receiptNumber,
                            @RequestParam("itemType") String itemType,
                            @RequestParam("quantity") double quantity,
                            @RequestParam("transactionDate") String transactionDate,
                            ModelMap mm, HttpSession session) {

        // Convert the transactionDate string to LocalDate if needed
        Date parsedDate = Date.valueOf(LocalDate.parse(transactionDate));

        // Create a Sales object and set its attributes
        Sales sale = new Sales();
        sale.setReceiptNumber(receiptNumber);
        sale.setDateOfSale(parsedDate);
        sale.setQuantity(quantity);
        sale.setItemCode(itemType);

        salesRepository.save(sale);

        if (num == 2) {
            mm.put("e", 2);
            mm.put("a", 0);
        } else {
            mm.put("a", 1);
            mm.put("e", 0);
        }

        return "redirect:MainPage";
    }



}
