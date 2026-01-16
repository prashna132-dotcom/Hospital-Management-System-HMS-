/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalmanagementsystem.controller;
import com.hospitalmanagementsystem.model.PatientModel;
import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Stack;
/**
 *
 * @author Prashna regmi
 */

/**
 * Controller Class: Acts as a bridge between the User Interface (View) and Data (Model).
 * It handles all the "Business Logic" using Data Structures and Algorithms.
 */
public class PatientController {
    // LinkedList: Used for the main database because it allows easy adding/removing of records.
    private final LinkedList<PatientModel> patientList;
    // Queue: Used to track the 'Last 5 Bookings' (FIFO - First In, First Out logic).
    private final Queue<PatientModel> patientQueue;
    // Stack: Used for the 'Undo' feature (LIFO - Last In, First Out logic).
    private final Stack<PatientModel> deletedStack; 
    
    public PatientController() {
        this.patientList = new LinkedList<>();
        this.patientQueue = new ArrayDeque<>(5); 
        this.deletedStack = new Stack<>(); 
        initializeData(); // Load dummy data on startup
    }
    /**
     * Loads default data into the system on startup.
     */
    private void initializeData() {
        addPatient(new PatientModel(1, "Unisha", "Suyesh", "Biratnagr", 18, "9852030114", "Cardiology", "2023-10-01", "10:00 AM", "Female"));
    
        addPatient(new PatientModel(2, "Kritika", "Deshan", "Kathmandu", 20, "9843651432", "Neurology", "2023-10-02", "11:00 AM", "Female"));
    
        addPatient(new PatientModel(3, "Sammin", "Denish", "Lahan", 21, "9841333333", "Orthopedics", "2023-10-03", "12:00 PM", "Female"));
    
        addPatient(new PatientModel(4, "Jaya", "Shreyash", "Dhankuta", 25, "9841444444", "Cardiology", "2023-10-04", "01:00 PM", "Female"));
    
        addPatient(new PatientModel(5, "Tejas", "Prashna", "Dang", 28, "9841555555", "Psychology", "2023-10-05", "02:00 PM", "Male"));
    }
    
    // MANUAL EMPTY CHECKS 
    // These methods prove we understand that 'Empty' means 'Size is 0'.
    public boolean isStackEmpty() {
        return deletedStack.size() == 0;
    }

    public boolean isQueueEmpty() {
        return patientQueue.size() == 0;
    }

    public boolean isListEmpty() {
        return patientList.size() == 0;
    }
    
    // AUTHENTICATION LOGIC
    
    //validation for login
    public boolean authenticate(String username, String password) {
        return "admin".equals(username) && "admin".equals(password);
    }
    public boolean authenticateUser(String username, String password) {
    return "user".equals(username) && "user".equals(password);
    }
    
    // CRUD OPERATIONS 
    
    /**
     * Adds a patient to the list and updates the "Recent Bookings" Queue.
     * @param patient
     */
    
    public void addPatient(PatientModel patient) {
        patientList.add(patient);
        // Queue logic: Keep only the 5 most recent additions
        if (patientQueue.size() == 5) {
            patientQueue.poll();
        }
        patientQueue.add(patient);
    }

    // Return all patient for the table
    public LinkedList<PatientModel> getAllPatients() {
        return patientList;
    }
    
    //Get the letest 5 entries for the home screen
     public Queue<PatientModel> getLetest() {
         return patientQueue; 
     }
     
     /**
     * Binary Search: Finds a patient by ID. 
     * Requires the list to be sorted by ID first.
     * @param id
     * @return 
     */
    public PatientModel binarySearchById(int id) {
        // First, sort by ID to ensure binary search works
        patientList.sort((p1, p2) -> Integer.compare(p1.getPatientId(), p2.getPatientId()));
        
        int low = 0;
        int high = patientList.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (patientList.get(mid).getPatientId() == id) {
                return patientList.get(mid);
            }
            if (patientList.get(mid).getPatientId() < id) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return null;
    }

    /**
     * Linear Search: Finds patients matching a string query.
     * Used for searching Names/Doctors/Departments.
     * @param query
     * @return 
     */
    public LinkedList<PatientModel> linearSearch(String query) {
        LinkedList<PatientModel> results = new LinkedList<>();
        String lowerQuery = query.toLowerCase();

        for (int i = 0; i < patientList.size(); i++) {
            PatientModel p = patientList.get(i);
        
            // Manual check for Name, Doctor, or Dept
            if (p.getPatientName().toLowerCase().contains(lowerQuery) || 
                p.getDoctorName().toLowerCase().contains(lowerQuery) ||
                p.getDepartment().toLowerCase().contains(lowerQuery)) {
            
            results.add(p);
            }
        }
        return results;
    }
    
    // STATISTICS FOR HOME SCREEN
    public int getTotalPatients() {
        return patientList.size(); 
    }
    
    public long getDeptCount(String dept) {
        return patientList.stream()
                .filter(p -> p.getDepartment()
                        .equalsIgnoreCase(dept))
                .count();
    }


    /**
     * Updates an existing patient record at a specific index.
     * @param index
     * @param updatedPatient
     */
    public void updatePatient(int index, PatientModel updatedPatient) {
        if (index >= 0 && index < patientList.size()) {
            patientList.set(index, updatedPatient);
        }
    }

    /**
     * Deletes a patient and PUSHES them onto the Stack for potential Undo.
     * @param index
     */
    public void deletePatient(int index) {
        if (index >= 0 && index < patientList.size()) {
            // Remove from list and PUSH onto stack
            PatientModel removed = patientList.remove(index);
            deletedStack.push(removed); //LIFO Push
        }
    }

    /**
     * Restores the last deleted patient from the Stack (Undo).
     * @return 
     */
    public boolean undoDelete() {
        if (isStackEmpty() == false) {
            // Pop the last item from the top of the stack (LIFO)
            PatientModel lastDeleted = deletedStack.pop();
            patientList.add(lastDeleted);
            return true;
        }
        return false;
    }

    // VALIDATION & STATISTICS 

    /**
     * Checks if a Patient ID is already taken.
     * @param patientId
     * @return 
     */
    public boolean isIdDuplicate(int patientId) {
        for (int i = 0; i < patientList.size(); i++) {
            PatientModel p = patientList.get(i);
            if (p.getPatientId() == patientId) { 
                return true;
            }
        }
        return false;
    }
    
    /**
 * Finds the highest ID in the list and returns the next serial number.
     * @return 
 */
    public int getNextAutoId() {
        int maxId = 0;
        for (PatientModel p : patientList) {
            if (p.getPatientId() > maxId) {
                maxId = p.getPatientId();
            }
        }
    return maxId + 1;
    }
    /**
     * Returns a string describing the most recent deletion from the stack.
     * @return 
     */
    public String getLatestAction() {
        if (deletedStack.isEmpty()){
            return "No recent deletions.";
        }
        // peek() lets us look at the top item without removing it
        return "Deleted: " + deletedStack.peek().getPatientName();
    }
}