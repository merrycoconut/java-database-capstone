# Schema Design

## MySQL Database Design

### Table: admin
- id: INT, Primary Key, Auto Increment
- username: VARCHAR(35), Not Null
- password: VARCHAR(12), Not Null

### Table: doctor
- id: INT, Primary Key, Auto Increment
- name: VARCHAR(35), Not Null
- password: VARCHAR(12), Not Null
- email: VARCHAR(320), Not Null
- phone: VARCHAR(25), Not Null
- specialty: VARCHAR(100), Not Null

### Table: doctor_available_times
- id: INT, Primary Key, Auto Increment
- doctor_id: INT, Foreign Key -> doctor(id)
- available_times: VARCHAR(20)

### Table: patient
- id: INT, Primary Key, Auto Increment
- name: VARCHAR(35), Not Null
- password: VARCHAR(12), Not Null
- email: VARCHAR(320), Not Null
- phone: VARCHAR(25), Not Null
- address: VARCHAR(255), Not Null

### Table: appointment
- id: INT, Primary Key, Auto Increment
- doctor_id: INT, Foreign Key -> doctor(id)
- patient_id: INT, Foreign Key -> patient(id)
- appointment_time: DATETIME, Not Null
- status: TINYINT (0 = Scheduled, 1 = Completed, 2 = Cancelled)

## MongoDB Collection Design

### Collection: prescriptions
```json
{
  "_id": "ObjectId('64abc123456')",
  "patientName": { "$oid": "64a2f111e4b0a1b2c3d4e5aa" },
  "appointmentId": 51,
  "medication": "Paracetamol",
  "dosage": "500mg",
  "doctorNotes": "Take 1 tablet every 6 hours.",
}
```