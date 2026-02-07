# 🦁 The FinTech Ledger - Full Stack Portfolio Manager

> *"Your money shouldn't just sit there. It should perform."*

A high-performance, real-time investment tracking dashboard built for speed and aesthetics. Features a **Luxury Black & Gold** Neo-Brutalist UI powered by a robust Spring Boot engine.

![Project Status](https://img.shields.io/badge/Status-Active-gold?style=for-the-badge)
![Backend](https://img.shields.io/badge/Java-Spring%20Boot-black?style=for-the-badge&logo=springboot)
![Frontend](https://img.shields.io/badge/React-JS-black?style=for-the-badge&logo=react)
![Database](https://img.shields.io/badge/MySQL-Database-black?style=for-the-badge&logo=mysql)

---

## 📸 Dashboard Preview
*(Upload your screenshots here later)*

## 🛠️ Tech Stack (The Engine)

### **Backend (Java Spring Boot)**
* **Core:** Java 21, Spring Boot 3.4
* **Data Layer:** Spring Data JPA (Hibernate)
* **Database:** MySQL 8.0
* **API:** RESTful Endpoints with CORS enabled

### **Frontend (React.js)**
* **Core:** React 18 (Hooks & Functional Components)
* **Visualization:** Recharts (Dynamic Bar Charts)
* **Networking:** Axios
* **Design System:** CSS3 (Custom "Luxury Gold" Theme)

---

## 🚀 Installation & Setup

### 1. Backend Setup
1.  Clone the repository:
    ```bash
    git clone [https://github.com/ayushadhikari15/fintech-ledger.git](https://github.com/ayushadhikari15/fintech-ledger.git)
    ```
2.  Open the folder in **IntelliJ IDEA**.
3.  Configure Database in `src/main/resources/application.properties`:
    ```properties
    spring.datasource.url=jdbc:mysql://localhost:3306/fintech_db
    spring.datasource.username=root
    spring.datasource.password=YOUR_PASSWORD
    ```
4.  Run `FinTechLedgerApplication.java`.

### 2. Frontend Setup
1.  Navigate to the frontend folder:
    ```bash
    cd frontend
    ```
2.  Install dependencies:
    ```bash
    npm install
    ```
3.  Start the dashboard:
    ```bash
    npm start
    ```
4.  Open `http://localhost:3000` to view the app.

---

## 📡 API Endpoints

| Method | Endpoint | Description |
| :--- | :--- | :--- |
| **POST** | `/api/trades` | Add a new trade (Buy/Sell) |
| **GET** | `/api/trades` | Fetch full trade history |
| **GET** | `/api/trades/summary` | Get aggregated portfolio metrics |

---

## 🎨 Design Philosophy
The UI follows a **"Luxury Neo-Brutalist"** approach:
* **Palette:** Pitch Black (`#000`) & Metallic Gold (`#D4AF37`).
* **Typography:** 'League Spartan' for a bold, geometric look.
* **Layout:** High-contrast split screen for focused data visualization.

---

### 👤 Author
**Ayush Adhikari**
*Full Stack Developer | Java & React Enthusiast*
