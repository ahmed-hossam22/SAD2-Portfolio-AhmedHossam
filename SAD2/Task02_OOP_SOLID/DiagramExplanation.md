# UML Class Diagram Explanation – Task 02 (SRP & OCP)

This document explains the UML diagram created for the OOP & SOLID (SRP & OCP) task.  
The diagram represents the structure of a hospital management system with proper abstraction, inheritance, and clear application of SOLID principles.

---

## 1. Main Inheritance Structure

### **User (Abstract Class)**
- Superclass for: **Doctor**, **Patient**, **Nurse**, and **Admin**.  
- Defines shared fields: `name`, `id`.  
- Defines shared behavior: `showMenu()`, `getName()`, `getId()`.

This demonstrates **generalization** and avoids repeated attributes among system user types.

---

## 2. SRP Application — IdValidator
The class **IdValidator** is the dedicated component responsible for:
- Checking whether a doctor exists  
- Checking whether a patient exists  

**This class follows Single Responsibility Principle (SRP)** because:
- It handles *only* validation logic  
- No business logic (appointments, prescriptions, schedules) is mixed inside it  
- Admin depends on it for ID validation without needing to implement validation rules internally

**Used by:** `Admin`

---

## 3. OCP Application — Schedule Interface & Implementations

### **Schedule (Interface)**
Declares:
- `getAvailableTimes()`
- `removeTime()`
- `addTime()`
- `toString()`

### **SimpleSchedule (Implements Schedule)**
- Stores available time slots  
- Allows adding and removing time  
- Used as a simple, general-purpose schedule

### **DoctorSchedule (Implements Schedule)**
- Specialized schedule assigned to a specific doctor  
- Holds doctor-specific availability  
- Extends functionality *without modifying the Schedule interface*

**This is the Open/Closed Principle (OCP)** because:
- The system can add new scheduling types (e.g., WeeklySchedule, EmergencySchedule)  
- No existing code needs to be modified  
- Only new classes need to be added

---

## 4. Main System Classes and Relationships

### **Doctor**
- Inherits from `User`  
- Has a `Schedule` (dependency on interface)  
- Creates `Appointment` objects  
- Issues `Prescription` objects  
- Reads patient medical records

### **Patient**
- Inherits from `User`  
- Has a `MedicalRecord` (composition → 1..1 strong relationship)  
- Has a list of `Prescription`  
- Has a list of `Appointment`  
- Can view and manage personal health-related information

### **Admin**
- Inherits from `User`  
- Manages lists of doctors and patients  
- Uses `IdValidator` for ID checks  
- Handles creating appointments and assigning schedules

### **Appointment**
- Connects `Doctor` and `Patient`  
- Contains appointment details such as `date`, `time`, and `status`  
- The doctor *creates* the appointment  
- The patient *has* the appointment  
- Represents a clear association between both classes

### **MedicalRecord**
- Linked to exactly one patient  
- Stores medical history entries  
- Uses composition: without the patient, the record cannot exist

### **Prescription**
- Linked to both doctor and patient  
- Stores medication, dosage, and duration  
- Created by doctor and attached to the patient's history

---

## 5. Relationships (Summarized)

| Relationship | Description |
|-------------|-------------|
| **Inheritance** | User → Doctor, Patient, Nurse, Admin |
| **Interface Implementation** | Schedule → SimpleSchedule, DoctorSchedule |
| **Composition** | Patient → MedicalRecord |
| **Aggregation / Association** | Doctor ↔ Appointment ↔ Patient |
| **Dependency** | Admin → IdValidator |
| **Doctor creates** | Appointment, Prescription |
| **Patient has** | Appointments, Prescriptions |

---

## 6. Why This Diagram Supports SOLID
- **SRP:**  
  - `IdValidator` handles one responsibility only  
  - Schedules are separated into independent classes  
- **OCP:**  
  - New schedule types can be added without modifying `Doctor`  
  - The diagram uses interfaces to enable extension instead of modification  
- **Low Coupling:**  
  - Doctor depends on `Schedule` interface, not on a specific implementation  
- **High Cohesion:**  
  - Each class focuses on a single well-defined purpose

---

## Conclusion
This UML diagram demonstrates a clean OOP design supported by SOLID principles (SRP & OCP).  
It highlights proper inheritance, composition, abstraction, and extensibility through interfaces.

The structure ensures the system is maintainable, scalable, and easy to extend with future features.
