# Task 02 – OOP & SOLID 

## Objective
The goal of this task is to apply Object-Oriented Programming concepts along with two SOLID principles:
- **SRP (Single Responsibility Principle)**
- **OCP (Open/Closed Principle)**

---

## Requirements

### 1. Apply SRP  
Choose a component from the system and refactor it so that it has only **one clear responsibility**.  
In this project, SRP is applied by creating a dedicated class responsible only for **ID handling** (such as generating or validating IDs), instead of mixing that logic with other behaviors.

### 2. Apply OCP  
Create an interface that allows adding new behaviors **without modifying existing code**.  
In this task, OCP is demonstrated by designing a `Schedule` interface and providing multiple implementations, such as:
- `SimpleSchedule`
- `DoctorSchedule`

The system should work with any future schedule type without requiring modifications in the classes that depend on the interface.

---

## Deliverables  

Include the following files inside the **Task02_OOP_SOLID** folder:

- **TaskDescription.md** — (this file)
- **Solution.md** — Explanation of SRP & OCP, before/after design, and code snippets.
- **DiagramExplanation.md** — Description of the updated UML diagram.
- **Reflection.md** — What you learned, what was challenging, improvements.
- **Java source files** used in this task:
  - `IdManager.java` or `IdValidator.java`
  - `Schedule.java`
  - `SimpleSchedule.java`
  - `DoctorSchedule.java`
- **Updated UML diagram** (e.g., `diagram_task02.png` or `.jpg`)
---
