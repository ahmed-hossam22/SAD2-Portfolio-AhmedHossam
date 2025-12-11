# UML Class Diagram Explanation – Hospital Management System

This document explains the UML Class Diagram designed for the Hospital Management System.  
The diagram represents the main system entities (classes), their attributes, methods, and the relationships between them.

---

## 1. HospitalManagement
This is the central class responsible for managing all hospital-related operations.

### **Attributes**
- List of patients  
- List of doctors  
- List of nurses  
- List of admins  
- List of appointments  
- List of rooms  

### **Methods**
- addPatient(), addDoctor(), addNurse(), addAdmin(), addRoom()  
- scheduleAppointment()  
- assignRoomToPatient()  

### **Purpose**
Acts as the manager/controller of the entire system.

---

## 2. User (Abstract Class)
A generic base class for all users in the system.

### **Attributes**
- id  
- name  
- email  
- phone  

### **Methods**
- login()  
- logout()  

### **Inherited By**
- Patient  
- Doctor  
- Nurse  
- Admin

---

## 3. Patient
Represents a hospital patient.

### **Attributes**
- patientId  
- room  
- appointments  
- prescriptions  
- medicalRecord  

### **Methods**
- register()  
- bookAppointment()  
- viewMedicalRecord()  

### **Relationships**
- **1 Patient → 1 MedicalRecord** (composition)  
- **Patient → many Appointments**  
- **Patient → many Prescriptions**  
- **Patient assigned to Room** (aggregation)

---

## 4. Doctor
Represents a doctor in the hospital.

### **Attributes**
- doctorId  
- specialization  
- appointments  
- writtenPrescriptions  

### **Methods**
- viewPatientRecord()  
- writePrescription()  

### **Relationships**
- **Doctor → many Appointments**  
- **Doctor → many Prescriptions** (writes)

---

## 5. Nurse
Represents a nurse who assists doctors.

### **Attributes**
- nurseId  
- assignedPatients  

### **Methods**
- assignPatient()  
- recordVitals()  

### **Relationships**
- **Nurse → many Patients** (association)

---

## 6. Admin
Represents a system administrator.

### **Attributes**
- adminId  

### **Methods**
- addUser()  
- removeUser()  
- assignRoom()  
- monitorResources()  

### **Relationships**
- Admin manages hospital resources but does not inherit clinical functions.

---

## 7. Room
Represents a hospital room.

### **Attributes**
- roomId  
- type  
- occupied (boolean)  
- assignedPatient  

### **Methods**
- assignToPatient()  
- freeRoom()  

### **Relationships**
- **1 Room → 0..1 Patient** (aggregation)

---

## 8. Appointment
Represents a scheduled meeting between a doctor and a patient.

### **Attributes**
- appointmentId  
- dateTime  
- status  

### **Methods**
- schedule()  
- cancel()  
- complete()  

### **Relationships**
- **1 Appointment → 1 Patient**  
- **1 Appointment → 1 Doctor**

---

## 9. MedicalRecord
Represents the patient’s full health history.

### **Attributes**
- recordId  
- history  

### **Methods**
- addEntry()  
- viewRecord()  

### **Relationship**
- **Patient → MedicalRecord** (composition — record cannot exist without patient)

---

## 10. Prescription
Represents medication information issued by a doctor for a patient.

### **Attributes**
- prescriptionId  
- medicineName  
- dosa
