# Task 01 – OOP Solution  
## 1. Identified System Classes

### ● User (Abstract)
- id  
- name  
- age  
- email  
- Methods: login(), logout()

### ● Patient (inherits User)
- medicalRecord  
- appointments  
- Methods: bookAppointment(), viewRecords(), viewPrescriptions()

### ● Doctor (inherits User)
- specialty  
- appointments  
- Methods: updateRecord(), issuePrescription()

### ● Nurse (inherits User)
- assignedPatients  
- Methods: recordVitals()

### ● Admin (inherits User)
- Methods: manageUsers(), assignRoom()

---

## 2. Additional System Classes

### ● Appointment
- appointmentId  
- doctor  
- patient  
- date  
- time  
- status  
- Methods: schedule(), cancel(), complete()

### ● MedicalRecord
- recordId  
- history  
- doctorNotes  
- Methods: update(), view()

### ● Prescription
- prescriptionId  
- medication  
- dosage  
- duration  
- doctor  
- patient  
- Methods: view()

### ● Room
- roomNumber  
- type  
- isAvailable  
- assignedPatient  
- Methods: assign(), release()

---
## 3. UML Class Diagram

---

## 4. Java Implementation  
All Java files included in the uploaded project:
- Admin.java  
- Appointment.java  
- Doctor.java  
- HospitalManagement.java  
- Main.java  
- MedicalRecord.java  
- Nurse.java  
- Patient.java  
- Prescription.java  
- Room.java  
- User.java  

