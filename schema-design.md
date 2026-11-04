# Schema Design

## MySQL Database Design

### Table: patient
- id: INT, Primary Key, Auto Increment
- first_name: VARCHAR(35), Not Null
- last_name: VARCHAR(35), Not Null
- email: VARCHAR(320), Not Null
- phone_number: VARCHAR(25), Not Null

### Table: doctor
- id: INT, Primary Key, Auto Increment
- first_name: VARCHAR(35), Not Null
- last_name: VARCHAR(35), Not Null
- email: VARCHAR(320), Not Null
- phone_number: VARCHAR(25), Not Null

### Table: appointments
- id: INT, Primary Key, Auto Increment
- doctor_id: INT, Foreign Key → doctors(id)
- patient_id: INT, Foreign Key → patients(id)
- appointment_time: DATETIME, Not Null
- status: INT (0 = Scheduled, 1 = Completed, 2 = Cancelled)

### Table: admin
- id: INT, Primary Key, Auto Increment
- name: VARCHAR(35), Not Null
- email: VARCHAR(320), Not Null
- phone_number: VARCHAR(25), Not Null

## MongoDB Collection Design

### Collection: prescriptions
```json
{
  "_id": "ObjectId('64abc123456')",
  "patientId": { "$oid": "64a2f111e4b0a1b2c3d4e5aa" },
  "doctorId": { "$oid": "64a2f222e4b0a1b2c3d4e5bb" },
  "issuedDate": { "$date": "2026-06-06T09:45:00Z" },
  "appointmentId": 51,
  "medication": "Paracetamol",
  "dosage": "500mg",
  "doctorNotes": "Take 1 tablet every 6 hours.",
  "refillCount": 2,
  "pharmacy": {
    "name": "Walgreens SF",
    "location": "Market Street"
  }
}
```

### Collection: patient feedback
```json
{
  "_id": "ObjectId('64abc123456')",
  "patientId": { "$oid": "64a2f111e4b0a1b2c3d4e5aa" },
  "appointmentId": 51,
  "rating": 5,
  "comments": "The wait time was very short, and the doctor explained everything clearly.",
  "submittedAt": { "$date": "2026-06-06T10:15:00Z" }
}
```

### Collection: doctor notes
```json
{
  "_id": { "$oid": "64a2f8b5e4b0a1b2c3d4e5f6" },
  "patientId": { "$oid": "64a2f111e4b0a1b2c3d4e5aa" },
  "doctorId": { "$oid": "64a2f222e4b0a1b2c3d4e5bb" },
  "appointmentId": 51,
  "notes": "Patient presents with mild persistent cough and low-grade fever for 3 days. Lungs clear to auscultation bilaterally. Advised rest and increased fluid intake.",
}
```
### Collection: log records
```json
{
  "_id": { "$oid": "64a2f8b5e4b0a1b2c3d4e5fa" },
  "timestamp": { "$date": "2026-06-06T09:30:05Z" },
  "level": "INFO",
  "service": "appointment-service",
  "userId": { "$oid": "64a2f111e4b0a1b2c3d4e5aa" },
  "action": "CREATE_APPOINTMENT",
  "message": "Appointment successfully booked for patient with Dr. Smith.",
}
```