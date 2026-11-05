package models;

@Document(collection = "prescriptions")
public class Prescription {
    @Id
    private Long id;

    @NotNull
    private Long patientId;
    
    @NotNull
    private Long appointmentId;
    
    @NotNull
    @Size(min = 3, max = 100)
    private String medication;

    @NotNull
    @Size(min = 3, max = 20)
    private String dosage;
    
    @Size(max = 200)
    private String doctorNotes;

    public Prescription() {}
    
    public Prescription(Long id, Long patientId, Long apponitmentId, String medication, String dosage, String doctorNotes) {
        this.id = id;
        this.patientId = patientId;
        this.appointmentId = apponitmentId;
        this.medication = medication;
        this.dosage = dosage;
        this.doctorNotes = doctorNotes;
    }

    public Long getPatientId() {return patientId;}
    public Long getAppointmentId() {return appointmentId;}
    public String getMedication() {return medication;}
    public String getDosage() {return dosage;}
    public String getDoctorNotes() {return doctorNotes;}

    public void setMedication(String medication) {
        this.medication = medication;
    }

    public void setDosage(String dosage) {
        this.dosage = dosage;
    }

    public void setDoctorNotes(String doctorNotes) {
        this.doctorNotes = doctorNotes;
    }

    
}
