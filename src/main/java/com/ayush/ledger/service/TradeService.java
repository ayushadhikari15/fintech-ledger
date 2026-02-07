package com.ayush.ledger.service;

import com.ayush.ledger.model.PortfolioSummary;
import com.ayush.ledger.model.TradeEntry;
import com.ayush.ledger.repository.TradeRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class TradeService {

    private final TradeRepository tradeRepository;

    public TradeService(TradeRepository tradeRepository) {
        this.tradeRepository = tradeRepository;
    }

    public TradeEntry saveTrade(TradeEntry trade) {
        return tradeRepository.save(trade);
    }

    public List<TradeEntry> getAllTrades() {
        return tradeRepository.findAll();
    }

    public List<PortfolioSummary> getPortfolioSummary() {

        List<Object[]> rawData = tradeRepository.getPortfolioSummaryRaw();
        List<PortfolioSummary> result = new ArrayList<>();

        if (rawData == null) return result;

        for (Object[] row : rawData) {
            String ticker = String.valueOf(row[0]);

            BigDecimal netQty = (row[1] instanceof BigDecimal)
                    ? (BigDecimal) row[1]
                    : new BigDecimal(String.valueOf(row[1]));

            BigDecimal avgPrice = (row[2] instanceof BigDecimal)
                    ? (BigDecimal) row[2]
                    : new BigDecimal(String.valueOf(row[2]));

            result.add(new PortfolioSummary(ticker, netQty, avgPrice));
        }

        return result;
    }
}