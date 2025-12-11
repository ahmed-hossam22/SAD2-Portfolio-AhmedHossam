# Task 01 – OOP  
## Hospital Management System – Case Study Description

### Case Study Overview
You are required to perform object-oriented analysis and design for a **Hospital Management System (HMS)** intended to automate daily hospital operations.  
The system manages multiple user types and supports core functionalities such as appointments, prescriptions, medical records, and room assignments.
---
## System Actors
- **Patient**
  - Registers into the system  
  - Books appointments  
  - Views prescriptions  
  - Accesses medical records  

- **Doctor**
  - Views/updates patient medical histories  
  - Manages appointments  
  - Issues prescriptions  

- **Nurse**
  - Records patient vitals  
  - Assists in monitoring and patient care  

- **Admin**
  - Manages system users  
  - Assigns rooms  
  - Oversees hospital operations  

---
## Core Functionalities
1. **Appointment Management**  
   Each appointment links a Patient with a Doctor on a specific date/time and has a status (Scheduled, Completed, Cancelled).

2. **Room Management**  
   Each room belongs to the hospital and can be assigned to a Patient during admission and released upon discharge.

3. **Medical Records**  
   Stores complete patient history, diagnosis, and doctor notes.

4. **Prescriptions**  
   Contains medication name, dosage, frequency, and duration; always linked to a Doctor and a Patient.

