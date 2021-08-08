package com.stockexchange.stockexchange.controller;

import com.stockexchange.stockexchange.dto.BuyStockDto;
import com.stockexchange.stockexchange.dto.SellStockDto;
import com.stockexchange.stockexchange.model.Portfolio;
import com.stockexchange.stockexchange.model.Stock;
import com.stockexchange.stockexchange.service.PortfolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
@CrossOrigin(origins = "http://localhost:4200")
*/
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/portfolio")
public class PortfolioController {

    @Autowired
    PortfolioService portfolioService;


    @GetMapping(value = "/{userId}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Portfolio> getAllPortfolio(@PathVariable Long userId) {
        return portfolioService.getAllPortfolio(userId);
    }

    @PostMapping(value = "/sellstock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Portfolio sellStock(@RequestBody SellStockDto sellStockDto) {
        return portfolioService.sellStock(sellStockDto.getPortfolioId(), sellStockDto.getAmount());
    }


    @PostMapping(value = "/buystock", produces = MediaType.APPLICATION_JSON_VALUE)
    public Portfolio buyStock(@RequestBody BuyStockDto buyStockDto) {
        return portfolioService.buyStock(buyStockDto.getStockId(), buyStockDto.getUserId(), buyStockDto.getAmount());
    }
}
