package com.stockexchange.stockexchange.service.impl;

import com.stockexchange.stockexchange.dto.StockDto;
import com.stockexchange.stockexchange.model.Portfolio;
import com.stockexchange.stockexchange.model.Stock;
import com.stockexchange.stockexchange.repository.StockRepository;
import com.stockexchange.stockexchange.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockServiceImpl implements StockService {

    StockRepository stockRepository;

    @Autowired
    public StockServiceImpl(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }


    @Override
    public Stock createStock(String stockname, String stockabr) {
        try {
            Stock stock = new Stock();
            stock.setStockabr(stockabr);
            stock.setStockname(stockname);
            stockRepository.save(stock);


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    @Override
    public ResponseEntity<Stock> updateStock(StockDto stockDto) {
        Optional<Stock> stock = null;
        try {
            stock = stockRepository.findById(stockDto.getId());
            stock.get().setStockname(stockDto.getStockname());
            stock.get().setStockabr(stockDto.getStockabr());
            stockRepository.save(stock.get());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
