# Task 02 – OOP Solution (SRP & OCP applied)

## 1. Identified System Classes

### ● User (Abstract)
- id  
- name  
- age  
- email  
- **Methods:** login(), logout()

### ● Patient (inherits User)
- medicalRecord  
- appointments  
- **Methods:** bookAppointment(), viewRecords(), viewPrescriptions()

### ● Doctor (inherits User)
- specialty  
- schedule  
- appointments  
- **Methods:** updateRecord(), issuePrescription(), viewAvailableTimes()

### ● Nurse (inherits User)
- assignedPatients  
- **Methods:** recordVitals()

### ● Admin (inherits User)
- **Methods:** manageUsers(), assignRoom(), managementMenu()

---

## 2. Additional System Classes

### ● Appointment
- appointmentId  
- doctorId / doctor reference  
- patientId / patient reference  
- date  
- time  
- status  
- **Methods:** schedule(), cancel(), complete(), getTime()

### ● MedicalRecord
- recordId  
- entries / history  
- doctorNotes  
- **Methods:** addEntry(), viewRecord()

### ● Prescription
- prescriptionId  
- patientId / doctorId  
- medicines (list)  
- dosage / duration  
- issuedAt  
- **Methods:** viewPrescription(), toString()

### ● Room
- roomNumber  
- type  
- isAvailable  
- assignedPatient  
- **Methods:** assign(), release()

---

## 3. Application of SOLID Principles (focus: SRP & OCP)

### A. Single Responsibility Principle (SRP)
**What was done:**  
- Extracted ID-related responsibilities into a dedicated class (e.g., `IdManager` or `IdValidator`).  
- This class is *only* responsible for ID generation/validation and nothing else.

**Why SRP helps:**  
- Isolates ID logic for easier testing and reuse.  
- Prevents mixing ID handling with business logic (appointments, patient records, etc.).  
- Makes maintenance safer: changes to ID policy stay local to one class.
---

### B. Open/Closed Principle (OCP)
**What was done:**  
- Introduced a `Schedule` interface and multiple concrete schedule implementations (for example: `SimpleSchedule`, `DoctorSchedule`).  
- Classes that depend on scheduling (e.g., `Doctor`) reference the `Schedule` interface instead of concrete classes.

**Why OCP helps:**  
- You can add new scheduling types (e.g., `WeeklySchedule`, `ShiftSchedule`) without modifying existing consumers.  
- Existing system code remains stable while behavior is extended via new classes.

**Design note:**  
- `Doctor` holds a `Schedule` reference. New schedule types implement `Schedule` and plug in seamlessly.

---

## 4. UML Class Diagram
- Include an updated UML that highlights:
  - `IdManager` / `IdValidator` (SRP)
  - `Schedule` interface and `SimpleSchedule` / `DoctorSchedule` implementations (OCP)
  - Relationships between `Doctor`, `Patient`, `Appointment`, `MedicalRecord`, `Prescription`, and `Room`.
---

## 5. Java Implementation  

- `Admin.java`  
- `Appointment.java`  
- `Doctor.java`  
- `DoctorSchedule.java`  
- `IdValidator.java` (or `IdManager.java`)  
- `Main.java`  
- `MedicalRecord.java`  
- `Patient.java`  
- `Prescription.java`  
- `Schedule.java` (interface)  
- `SimpleSchedule.java`  
- `User.java`  
- `diagram.jpg` (UML image)
---

## 6. Before vs After (summary)

- **Before:** ID handling mixed into various classes; schedule logic fixed in one structure; hard to extend or test.  
- **After:**  
  - ID logic extracted to a single-responsibility class (SRP).  
  - Scheduling behavior abstracted by `Schedule` interface and multiple implementations (OCP).  
  - Consumers (e.g., `Doctor`) depend on interface abstractions — no code changes needed to add new schedule types.
---
