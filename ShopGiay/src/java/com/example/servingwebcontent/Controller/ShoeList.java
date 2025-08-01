package com.example.servingwebcontent.Controller;

import com.example.servingwebcontent.Model.Shoe;
import com.example.servingwebcontent.Database.ShoeDatabase;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class ShoeController {

    @GetMapping("/shoelist")
    public String showShoeList(Model model) {
        // Lấy danh sách giày từ "database" (lớp giả lập)
        ShoeDatabase shoeDB = new ShoeDatabase();
        List<Shoe> shoeList = shoeDB.getAllShoes();

        // Đưa danh sách giày sang view
        model.addAttribute("shoes", shoeList);

        // Trả về template shoelist.html
        return "shoelist";
    }
}