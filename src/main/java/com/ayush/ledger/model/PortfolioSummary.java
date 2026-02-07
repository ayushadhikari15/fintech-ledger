package com.ayush.ledger.model;

import java.math.BigDecimal;

public class PortfolioSummary {

    private final String ticker;
    private final BigDecimal netQuantity;
    private final BigDecimal averagePrice;

    public PortfolioSummary(String ticker, BigDecimal netQuantity, BigDecimal averagePrice) {
        this.ticker = ticker;
        this.netQuantity = netQuantity;
        this.averagePrice = averagePrice;
    }

    public String getTicker() {
        return ticker;
    }

    public BigDecimal getNetQuantity() {
        return netQuantity;
    }

    public BigDecimal getAveragePrice() {
        return averagePrice;
    }
}