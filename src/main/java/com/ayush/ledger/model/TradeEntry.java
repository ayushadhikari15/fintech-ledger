package com.ayush.ledger.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "trade_entries")
@Data
public class TradeEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ticker;

    @Column(name = "transaction_type")
    private String transactionType;

    @Column(precision = 19, scale = 4)
    private BigDecimal quantity;

    @Column(name = "price_per_unit", precision = 19, scale = 4)
    private BigDecimal pricePerUnit;

    @Column(name = "trade_date", insertable = false, updatable = false)
    private LocalDateTime tradeDate;
}
