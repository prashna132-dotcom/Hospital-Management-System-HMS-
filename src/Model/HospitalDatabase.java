/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Dell
 */

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class HospitalDatabase {
    public static ArrayList<Patient> patientList = new ArrayList<>();
    public static ArrayList<Doctor> doctorList = new ArrayList<>();
    public static ArrayList<Appointment> appointmentList = new ArrayList<>();

    // Queue for recently added patients
    public static Queue<Patient> recentPatients = new LinkedList<>();

    // Stack for undo operations
    public static Stack<Object> undoStack = new Stack<>();
}
