package com.ayush.ledger.repository;

import com.ayush.ledger.model.TradeEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TradeRepository extends JpaRepository<TradeEntry, Long> {

    @Query("SELECT t.ticker, " +
            "SUM(CASE WHEN t.transactionType = 'BUY' THEN t.quantity ELSE -t.quantity END), " +
            "AVG(t.pricePerUnit) " +
            "FROM TradeEntry t GROUP BY t.ticker")
    List<Object[]> getPortfolioSummaryRaw();
}