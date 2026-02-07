import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { BarChart, Bar, XAxis, YAxis, CartesianGrid, Tooltip, ResponsiveContainer, Cell } from 'recharts';
import './App.css';

function App() {
  const [trades, setTrades] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get('http://localhost:8080/api/trades/summary')
      .then(response => {
        setTrades(response.data);
        setLoading(false);
      })
      .catch(err => {
        setError(err.message);
        setLoading(false);
      });
  }, []);

  const enrichedTrades = trades.map(trade => ({
    ...trade,
    safePrice: trade.averagePrice || 0, 
    value: (trade.netQuantity * (trade.averagePrice || 0))
  }));

  const totalWealth = enrichedTrades.reduce((sum, trade) => sum + trade.value, 0);

  return (
    <div className="app-container">
      <div className="hero-section">
        <div className="hero-content">
          <h1 className="main-title">THE STAGE.</h1> {/* Changed Title */}
          <div className="wealth-box">
            <div className="wealth-label">TOTAL ASSETS</div>
            <div className="wealth-amount">
              {loading ? '...' : error ? 'ERROR' : `₹${totalWealth.toLocaleString()}`}
            </div>
          </div>
        </div>
      </div>
      
      <div className="base-section">
        <div className="base-content">
          <section className="chart-section">
            <h2 className="section-title">PERFORMANCE.</h2>
            {loading ? (
              <div className="empty-state">LOADING...</div>
            ) : error ? (
              <div className="empty-state">FAILED TO LOAD</div>
            ) : enrichedTrades.length === 0 ? (
              <div className="empty-state">ZERO.</div>
            ) : (
              <ResponsiveContainer width="100%" height={300}>
                <BarChart data={enrichedTrades}>
                  <CartesianGrid strokeDasharray="3 3" stroke="#333" /> {/* Dark Grid */}
                  <XAxis dataKey="ticker" stroke="#D4AF37" fontWeight="700" tick={{fontSize: 12}} />
                  <YAxis stroke="#D4AF37" fontWeight="700" tickFormatter={(val) => `₹${val/1000}k`} />
                  <Tooltip 
                    cursor={{fill: '#1a1a1a'}}
                    contentStyle={{ 
                      backgroundColor: '#000', 
                      border: '2px solid #D4AF37',
                      color: '#D4AF37',
                      fontFamily: 'League Spartan'
                    }}
                    itemStyle={{ color: '#FFF' }}
                    formatter={(value) => [`₹${value.toLocaleString()}`, "VALUE"]}
                  />
                  <Bar dataKey="value" stroke="#D4AF37" strokeWidth={1}>
                     {enrichedTrades.map((entry, index) => (
                        <Cell key={`cell-${index}`} fill="url(#goldGradient)" />
                     ))}
                  </Bar>
                  {/* Adding a Gold Gradient Definition */}
                  <defs>
                    <linearGradient id="goldGradient" x1="0" y1="0" x2="0" y2="1">
                      <stop offset="5%" stopColor="#FFD700" stopOpacity={0.8}/>
                      <stop offset="95%" stopColor="#D4AF37" stopOpacity={0.8}/>
                    </linearGradient>
                  </defs>
                </BarChart>
              </ResponsiveContainer>
            )}
          </section>

          <section className="table-section">
            <h2 className="section-title">THE LEDGER.</h2>
            {loading ? (
              <div className="empty-state">LOADING...</div>
            ) : error ? (
              <div className="empty-state">FAILED TO LOAD</div>
            ) : enrichedTrades.length === 0 ? (
              <div className="empty-state">ZERO.</div>
            ) : (
              <table className="ledger-table">
                <thead>
                  <tr>
                    <th>TICKER</th>
                    <th>PRICE</th>
                    <th>QTY</th>
                    <th>VALUE</th>
                  </tr>
                </thead>
                <tbody>
                  {enrichedTrades.map((trade, index) => (
                    <tr key={index}>
                      <td className="ticker-cell">{trade.ticker}</td>
                      <td>₹{(trade.averagePrice || 0).toLocaleString()}</td>
                      <td>{trade.netQuantity}</td>
                      <td>₹{trade.value.toLocaleString()}</td>
                    </tr>
                  ))}
                </tbody>
              </table>
            )}
          </section>
        </div>
      </div>
    </div>
  );
}

export default App;