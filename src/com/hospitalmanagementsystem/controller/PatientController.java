/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalmanagementsystem.controller;
import com.hospitalmanagementsystem.model.PatientModel;
import java.util.LinkedList;
/**
 *
 * @author Prashna regmi
 */
public class PatientController {

    private final LinkedList<PatientModel> patientList;

    public PatientController() {
        this.patientList = new LinkedList<>();
        
        initializeData();
    }

    private void initializeData() {
        addPatient(new PatientModel(10001, "John Doe", "Dr Unisha", "Pokhara", 20, "9803729956", "Cardiology"));
        addPatient(new PatientModel(10002, "Alice Johnson", "Dr Kritika", "Kathmandu", 25, "9876543211", "Neurology"));
        addPatient(new PatientModel(10003, "Robert Smith", "Dr Saamin", "Biratnagar", 30, "9801234567", "Orthopedics"));
        addPatient(new PatientModel(10004, "Emily Davis", "Dr Prashna", "Butwal", 35, "9812345678", "Pediatrics"));
        addPatient(new PatientModel(10005, "Michael Brown", "Dr Suyesh", "Chitwan", 40, "9823456789", "Oncology"));
        addPatient(new PatientModel(10006, "Kritika", "Dr Tejash", "Dharan", 28, "9834567890", "Dermatology"));
        addPatient(new PatientModel(10007, "David Martinez", "Dr Aayush", "Lalitpur", 50, "9845678901", "Gastroenterology"));
    }

    public boolean authenticate(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }

    public void addPatient(PatientModel patient) {
        
        patientList.add(patient);
    }

    // Read
    public LinkedList<PatientModel> getAllPatients() {
        return patientList;
    }

    // Update
    public void updatePatient(int index, PatientModel updatedPatient) {
        if (index >= 0 && index < patientList.size()) {
            patientList.set(index, updatedPatient);
        }
    }

    // Delete
    public void deletePatient(int index) {
        if (index >= 0 && index < patientList.size()) {
            patientList.remove(index);
        }
    }
    
    // Add this to PatientController.java
    public boolean isIdDuplicate(int id) {
        for (PatientModel p : patientList) {
            if (p.getPatientId() == id) {
                return true;
            }
        }
        return false;
    }
}