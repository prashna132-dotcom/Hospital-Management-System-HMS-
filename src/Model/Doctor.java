/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class Doctor {
    private String doctorId;
    private String name;
    private String specialization;
    private String phone;

    public Doctor(String doctorId, String name, String specialization, String phone) {
        this.doctorId = doctorId;
        this.name = name;
        this.specialization = specialization;
        this.phone = phone;
}

// Getters & Setters
    
    public String getDoctorId() {
        return doctorId; 
    }
    
    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId; 
    }

    public String getName() {
        return name; 
    }
    
    public void setName(String name) {
        this.name = name; 
    }

    public String getSpecialization() {
        return specialization; 
    }
    
    public void setSpecialization(String specialization) {
        this.specialization = specialization; 
    }

    public String getPhone() {
        return phone; 
    }
    
    public void setPhone(String phone) {
        this.phone = phone; 
    }

    @Override
    public String toString() {
        return doctorId + " - " + name;
    }
}