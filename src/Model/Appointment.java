/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class Appointment {
    private String appointmentId;
    private String patientId;
    private String doctorId;
    private String date;
    private String time;
    private String reason;

    public Appointment(String appointmentId, String patientId, String doctorId,
                       String date, String time, String reason) {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.doctorId = doctorId;
        this.date = date;
        this.time = time;
        this.reason = reason;
}
    
// Getters & Setters
    public String getAppointmentId() { return appointmentId; }
    public void setAppointmentId(String appointmentId) { this.appointmentId = appointmentId; }

    public String getPatientId() { return patientId; }
    public void setPatientId(String patientId) { this.patientId = patientId; }

    public String getDoctorId() { return doctorId; }
    public void setDoctorId(String doctorId) { this.doctorId = doctorId; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getTime() { return time; }
    
    public void setTime(String time) {
        this.time = time; 
    }

    public String getReason() {
        return reason; 
    }
    
    public void setReason(String reason) {
        this.reason = reason; 
    }

    @Override
    public String toString() {
        return appointmentId + " | Patient: " + patientId + " | Doctor: " + doctorId;
    }
}
