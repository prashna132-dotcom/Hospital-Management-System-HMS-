/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalmanagementsystem.model;

/**
 *This file is part of the Hospital Management System
 * @author Prashna Regmi
 */

/**
 * The PatientModel class represents a real-world patient in the system.
 * It serves as a "Data Carrier" (POJO) to store all personal and 
 * appointment-related information for a single patient.
 */
public class PatientModel {
    //  Attributes (Private Fields) 
    // We use private fields to ensure "Encapsulation" (data security)
    private int patientId;
    private String patientName;
    private String doctorName;
    private String address;
    private int age;
    private String contact;
    private String department;
    private String appointmentDate;
    private String appointmentTime;
    private String gender;
    
    /**
     * Default Constructor
     * Used to create an empty patient object without setting values immediately.
     */
    public PatientModel() {  
    }
    
    /**
     * Parameterized Constructor
     * Used to create a complete patient object with all data at once.
     * This is useful when adding a new patient from the UI to the LinkedList.
     * @param patientId
     * @param patientName
     * @param doctorName
     * @param address
     * @param age
     * @param contact
     * @param department
     * @param appointmentDate
     * @param appointmentTime
     * @param gender
     */
    
    public PatientModel(int patientId, String patientName, String doctorName,String address, int age, String contact, String department, String appointmentDate, String appointmentTime, String gender) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.address = address;
        this.age = age;
        this.contact = contact;
        this.department = department;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.gender = gender;
    }

    // Getters and Setters
    // Getters: Used to retrieve data to show in the Table (View)
    // Setters: Used to update data when the user edits info
    
    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }
    
   public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
    
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(String appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
}