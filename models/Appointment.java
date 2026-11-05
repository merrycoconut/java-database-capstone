package models;

import java.beans.Transient;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name="appointment")
public class Appointment{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne
    private Doctor doctor;

    @NotNull
    @ManyToOne
    private Patient patient;

    @Future(message = "Appointment time must be in the future")
    private LocalDateTime appointmentTime;

    private int status; // 0: Scheduled, 1: Completed, 2: Cancelled

    @Transient // prevents getEndTime() from being stored in the database
    public LocalDateTime getEndTime() {
        return appointmentTime.plusHours(1);
    }

    public Appointment() {}

    public Appointment(Long id, Doctor doctor, Patient patient, LocalDateTime appointmentTime, int status) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.appointmentTime = appointmentTime;
        this.status = status; 
    }

    public Long getId() {return id;}
    public Doctor getDoctor() {return doctor;}
    public Patient getPatient() {return patient;}
    public LocalDateTime getAppointmentTime() {return appointmentTime;}
    public int getStatus() {return status;}

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient name) {
        this.patient = name;
    }

    public void setAppointmentTime(LocalDateTime appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public void setStatus(int status) {
        this.status = status;
    }

}