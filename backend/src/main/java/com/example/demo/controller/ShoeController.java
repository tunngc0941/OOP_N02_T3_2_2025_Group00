package com.example.demo.controller;

import com.example.demo.model.Shoe;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/api/shoes")
@CrossOrigin
public class ShoeController {
    private final List<Shoe> shoes = new ArrayList<>();
    private final AtomicLong idGen = new AtomicLong(1);

    @GetMapping
    public List<Shoe> getAllShoes() {
        return shoes;
    }

    @GetMapping("/{id}")
    public Shoe getShoe(@PathVariable Long id) {
        return shoes.stream().filter(s -> s.getId().equals(id)).findFirst()
                .orElseThrow(() -> new NoSuchElementException("Shoe not found"));
    }

    @PostMapping
    public Shoe addShoe(@RequestBody Shoe shoe) {
        shoe.setId(idGen.getAndIncrement());
        shoes.add(shoe);
        return shoe;
    }

    @PutMapping("/{id}")
    public Shoe updateShoe(@PathVariable Long id, @RequestBody Shoe shoe) {
        for (Shoe s : shoes) {
            if (s.getId().equals(id)) {
                s.setTen(shoe.getTen());
                s.setGia(shoe.getGia());
                s.setSoLuong(shoe.getSoLuong());
                return s;
            }
        }
        throw new NoSuchElementException("Shoe not found");
    }

    @DeleteMapping("/{id}")
    public void deleteShoe(@PathVariable Long id) {
        shoes.removeIf(s -> s.getId().equals(id));
    }
}
