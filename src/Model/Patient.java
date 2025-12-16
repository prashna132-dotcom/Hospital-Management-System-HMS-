/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */
public class Patient {
    private String patientId;
    private String name;
    private int age;
    private String gender;
    private String phone;
    private String address;

    public Patient(String patientId, String name, int age, String gender, String phone, String address) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.phone = phone;
        this.address = address;
}

// Getters & Setters
    
    public String getPatientId() {
        return patientId; 
    }
    
    public void setPatientId(String patientId) {
        this.patientId = patientId; 
    }

    public String getName() {
        return name; 
    }
    
    public void setName(String name) {
        this.name = name; 
    }

    public int getAge() {
        return age; 
    }
    
    public void setAge(int age) {
        this.age = age; 
    }

    public String getGender() {
        return gender; 
    }
    
    public void setGender(String gender) {
        this.gender = gender; 
    }

    public String getPhone() {
        return phone; 
    }
    
    public void setPhone(String phone) {
        this.phone = phone; 
    }

    public String getAddress() {
        return address; 
    }
    
    public void setAddress(String address) {
        this.address = address; 
    }

    @Override
    public String toString() {
        return patientId + " - " + name;
    }
}