# Walmart Advanced Software Engineering Job Simulation

**Certificate of Completion** issued by [Forage](https://www.theforage.com/) in partnership with **Walmart Global Tech**, completed by **Vijay Chandra** — July 2026.

This repository documents my work from the *Advanced Software Engineering* virtual job simulation, where I took on a set of technical projects for different teams at Walmart — from a custom heap implementation for the shipping department, to a UML-modeled data processor, to a relational database design for the pet department, to an ETL script for reconciling shipment data across spreadsheets.

---

## 🏆 Certificate

📄 [`Walmart - Advanced Software Engineering Certificate.pdf`](./Walmart%20-%20Advanced%20Software%20Engineering%20Certificate.pdf)

- **Enrolment Verification Code:** `6a69d19d0595254659241fb1`
- **User Verification Code:** `6a645899e22952070f1529f8`
- **Issued by:** Forage
- **Date:** July 29th, 2026

---

## 📌 Simulation Overview

Over four tasks, I worked through a set of independent engineering problems spanning data structures, software architecture, database design, and data munging:

| Task | Title | Description |
|------|-------|-------------|
| 1 | **Advanced Data Structures** | Implemented a generalized max-heap in Java where each parent node can have `2^x` children instead of the usual 2, with configurable branching factor, dynamic resizing, and overflow-safe index arithmetic. See [`Task1PowerOfTwoMaxHeap.java`](./Task1PowerOfTwoMaxHeap.java). |
| 2 | **Software Architecture** | Designed a UML class diagram for a configurable data processor, using a `Mode` strategy hierarchy (Dump / Passthrough / Validate) and a `DatabaseConnector` hierarchy (Postgres / Redis / Elastic), wired together through a `ModeFactory`. See [`Task_2_Processor_UML.pdf`](./Task_2_Processor_UML.pdf). |
| 3 | **Relational Database Design** | Created an entity relationship diagram for Walmart's pet department, modeling products (food, toy, apparel), their manufacturers and compatible animals, customer transactions, and multi-location shipments — normalized to avoid redundant or nullable columns. See [`Task_3_ERD_Diagram.png`](./Task_3_ERD_Diagram.png). |
| 4 | **Data Munging** | Wrote a Python ETL script that reconciles three differently-structured shipping CSVs into a single SQLite database, deduplicating products and aggregating per-shipment product quantities. See [`Task_4_Model_Answer.pdf`](./Task_4_Model_Answer.pdf). |

---

## 🔍 Key Highlights

- **Task 1:** Generalized the classic binary heap to a `2^x`-ary heap — child/parent index math uses bit shifts instead of division for performance, with `long` arithmetic to avoid integer overflow at large branching factors.
- **Task 2:** Used the Strategy pattern for processor modes and the Factory pattern (`ModeFactory`) to resolve a `ModeIdentifier` + `DatabaseIdentifier` pair into a fully wired `Mode` instance, keeping the `Processor` decoupled from concrete mode/connector implementations.
- **Task 3:** Modeled the three product types (`PetFood`, `PetToy`, `PetApparel`) as subtypes of a shared `Product` supertype, avoiding duplicated manufacturer/animal relationships and eliminating nullable type-specific columns.
- **Task 4:** Handled inconsistent source data — one spreadsheet with one row per shipment and another split across two files — by building an intermediate in-memory structure before writing to the database, so both formats funnel through the same insert logic.

---

## 🛠️ Skills Demonstrated

- Data Structures & Algorithms (heaps, generalized branching factor)
- Object-Oriented Design & Design Patterns (Strategy, Factory)
- UML Class Modeling
- Relational Database Design & Normalization (3NF)
- Entity-Relationship (ER) Modeling
- Data Munging / ETL
- SQL & SQLite
- Java & Python

---

## 📂 Repository Contents

```
├── Walmart - Advanced Software Engineering Certificate.pdf   # Completion certificate
├── Task1PowerOfTwoMaxHeap.java                                # Generalized max-heap (Java)
├── Task_2_Processor_UML.pdf                                   # Data processor UML class diagram
├── Task_3_ERD_Diagram.png                                     # Pet department ERD
├── Task_4_Model_Answer.pdf                                    # Shipment data ETL script (Python)
└── README.md
```

---

## 🔗 About the Simulation

This simulation was completed on Forage's platform in partnership with **Walmart Global Tech**, designed to give students hands-on practice with the kind of engineering problems Walmart's software teams solve day to day — spanning data structures, system design, database architecture, and data engineering.

🔗 [Forage Simulation Platform](https://www.theforage.com/)

---

**Author:** Vijay Chandra
B.Tech CSE (2026) | Data & Full-Stack Development Enthusiast
