package com.ayush.ledger.controller;

import com.ayush.ledger.model.PortfolioSummary; // <-- Ye Import zaroori hai
import com.ayush.ledger.model.TradeEntry;
import com.ayush.ledger.service.TradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
@CrossOrigin(origins = "http://localhost:3000") // Frontend connection ke liye zaroori
public class TradeController {

    @Autowired
    private TradeService tradeService;

    // 1. Add a new trade
    @PostMapping
    public TradeEntry addTrade(@RequestBody TradeEntry trade) {
        return tradeService.saveTrade(trade);
    }

    // 2. Get all raw trades
    @GetMapping
    public List<TradeEntry> getAllTrades() {
        return tradeService.getAllTrades();
    }

    // 3. Get Portfolio Summary (FIXED: Return Type matched with Service)
    @GetMapping("/summary")
    public List<PortfolioSummary> getSummary() {
        System.out.println("API /summary was hit from Frontend!");
        return tradeService.getPortfolioSummary();
    }
}