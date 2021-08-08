package com.stockexchange.stockexchange.controller;

import com.stockexchange.stockexchange.dto.StockDto;
import com.stockexchange.stockexchange.exception.ResourceNotFoundException;
import com.stockexchange.stockexchange.model.ERole;
import com.stockexchange.stockexchange.model.Role;
import com.stockexchange.stockexchange.model.Stock;
import com.stockexchange.stockexchange.model.User;
import com.stockexchange.stockexchange.repository.StockRepository;
import com.stockexchange.stockexchange.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class StockController {
    @Autowired
    private StockRepository stockRepository;

    @Autowired
    private StockService stockService;


    @GetMapping("/stock")
    public List<Stock> getAllStock() {
        return stockRepository.findAll();
    }

    @PostMapping("/stock")
    public Stock createStock(@RequestBody StockDto stock) {
        return stockService.createStock(stock.getStockname(), stock.getStockabr());
    }

    @GetMapping("/stock/{id}")
    public ResponseEntity<Stock> selectById(@PathVariable Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stock not found" + id));
        return ResponseEntity.ok(stock);
    }

    @PutMapping("/stock/{id}")
    public ResponseEntity<Stock> updateStock(@RequestBody StockDto stockDto) {
        return stockService.updateStock(stockDto);

    }

    @DeleteMapping("/stock/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteStock(@PathVariable Long id) {
        Stock stock = stockRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Stock not found" + id));
        stockRepository.delete(stock);
        Map<String, Boolean> res = new HashMap<>();
        res.put("Deleted", Boolean.TRUE);
        return ResponseEntity.ok(res);
    }

}