/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalmanagementsystem.controller;
import java.util.LinkedList;
import java.util.Collections;
/**
 *
 * @author Prashna regmi
 */
public class PatientController {
    private LinkedList<PatientModel> patientList;

    public PatientController() {
        this.patientList = new LinkedList<>();
    }

    // FIX 2: Added the missing '/' here. It was "/ CREATE", which caused a syntax error.
    // CREATE 
    public void addPatient(PatientModel patient) {
        patientList.add(patient);
    }

    // READ
    public LinkedList<PatientModel> getAllPatients() {
        return patientList;
    }

    // UPDATE
    public void updatePatient(int index, PatientModel updatedPatient) {
        if (index >= 0 && index < patientList.size()) {
            patientList.set(index, updatedPatient);
        }
    }

    // DELETE
    public void deletePatient(int index) {
        if (index >= 0 && index < patientList.size()) {
            patientList.remove(index);
        }
    }

    // AUTHENTICATION LOGIC
    public boolean login(String username, String password) {
        return username.equals("admin") && password.equals("admin");
    }

    // SORTING LOGIC
    public void sortById(boolean ascending) {
        Collections.sort(patientList, (p1, p2) -> {
            return ascending ? Integer.compare(p1.getPatientId(), p2.getPatientId()) 
                             : Integer.compare(p2.getPatientId(), p1.getPatientId());
        });
    }

    public void sortByName(boolean ascending) {
        Collections.sort(patientList, (p1, p2) -> {
            return ascending ? p1.getPatientName().compareToIgnoreCase(p2.getPatientName()) 
                             : p2.getPatientName().compareToIgnoreCase(p1.getPatientName());
        });
    }
}