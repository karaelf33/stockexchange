package com.stockexchange.stockexchange.service;

import com.stockexchange.stockexchange.dto.StockDto;
import com.stockexchange.stockexchange.model.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface StockService {

    Stock createStock(String stockname, String stockabr);

    ResponseEntity<Stock> updateStock(StockDto stockDto);
}
