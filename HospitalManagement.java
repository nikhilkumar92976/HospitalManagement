import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Patient {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String gender;
    private int age;

    public Patient(String name, String gender, int age) {
        this.id = idCounter++;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Patient ID: " + id + ", Name: " + name + ", Gender: " + gender + ", Age: " + age;
    }
}

class Doctor {
    private static int idCounter = 1;
    private int id;
    private String name;
    private String speciality;

    public Doctor(String name, String speciality) {
        this.id = idCounter++;
        this.name = name;
        this.speciality = speciality;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Doctor ID: " + id + ", Name: " + name + ", Speciality: " + speciality;
    }
}

class Appointment {
    private Patient patient;
    private Doctor doctor;
    private String date;

    public Appointment(Patient patient, Doctor doctor, String date) {
        this.patient = patient;
        this.doctor = doctor;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Appointment: [Patient: " + patient + ", Doctor: " + doctor + ", Date: " + date + "]";
    }
}

public class HospitalManagement {
    private static List<Patient> patients = new ArrayList<>();
    private static List<Doctor> doctors = new ArrayList<>();
    private static List<Appointment> appointments = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("***********************************************************");
            System.out.println("Hospital Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. Schedule Appointment");
            System.out.println("4. View Patients");
            System.out.println("5. View Doctors");
            System.out.println("6. View Appointments");
            System.out.println("0. Exit");
            System.out.println("***********************************************************");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            System.out.println("***********************************************************");

            switch (choice) {
                case 1:
                    addPatient(scanner);
                    break;
                case 2:
                    addDoctor(scanner);
                    break;
                case 3:
                    scheduleAppointment(scanner);
                    break;
                case 4:
                    viewPatients();
                    break;
                case 5:
                    viewDoctors();
                    break;
                case 6:
                    viewAppointments();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    System.out.println("Thank You.....");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);
        scanner.close();
    }

    private static void addPatient(Scanner scanner) {
        System.out.print("Enter patient name: ");
        String name = scanner.next();
        System.out.print("Enter patient gender: ");
        String gender = scanner.next();
        System.out.print("Enter patient age: ");
        int age = scanner.nextInt();
        patients.add(new Patient(name, gender, age));
        System.out.println("***********************************************************");
        System.out.println("Patient added successfully.");
        System.out.println("***********************************************************");
    }

    private static void addDoctor(Scanner scanner) {
        System.out.print("Enter doctor name: ");
        String name = scanner.next();
        System.out.print("Enter doctor speciality: ");
        String speciality = scanner.next();
        doctors.add(new Doctor(name, speciality));
        System.out.println("***********************************************************");
        System.out.println("Doctor added successfully.");
        System.out.println("***********************************************************");
    }

    private static void scheduleAppointment(Scanner scanner) {
        if (patients.isEmpty() || doctors.isEmpty()) {
            System.out.println("***********************************************************");
            System.out.println("Please ensure there is at least one patient and one doctor available.");
            System.out.println("***********************************************************");
            return;
        }
        System.out.print("Enter patient ID: ");
        int patientId = scanner.nextInt();
        System.out.print("Enter doctor ID: ");
        int doctorId = scanner.nextInt();
        System.out.print("Enter appointment date (YYYY-MM-DD): ");
        String date = scanner.next();
        Patient patient = findPatientById(patientId);
        Doctor doctor = findDoctorById(doctorId);
        if (patient != null && doctor != null) {
            appointments.add(new Appointment(patient, doctor, date));
            System.out.println("***********************************************************");
            System.out.println("Appointment scheduled successfully.");
            System.out.println("***********************************************************");
        } else {
            System.out.println("***********************************************************");
            System.out.println("Invalid patient or doctor ID.");
            System.out.println("***********************************************************");
        }
    }

    private static void viewPatients() {
        if (patients.isEmpty()) {
            System.out.println("***********************************************************");
            System.out.println("No patients found.");
            System.out.println("***********************************************************");
        } else {
            for (Patient patient : patients) {
                System.out.println("***********************************************************");
                System.out.println(patient);
                System.out.println("***********************************************************");
            }
        }
    }

    private static void viewDoctors() {
        if (doctors.isEmpty()) {
            System.out.println("***********************************************************");
            System.out.println("No doctors found.");
            System.out.println("***********************************************************");
        } else {
            for (Doctor doctor : doctors) {
                System.out.println("***********************************************************");
                System.out.println(doctor);
                System.out.println("***********************************************************");
            }
        }
    }

    private static void viewAppointments() {
        if (appointments.isEmpty()) {
            System.out.println("***********************************************************");
            System.out.println("No appointments found.");
            System.out.println("***********************************************************");
        } else {
            for (Appointment appointment : appointments) {
                System.out.println("***********************************************************");
                System.out.println(appointment);
                System.out.println("***********************************************************");
            }
        }
    }

    private static Patient findPatientById(int id) {
        for (Patient patient : patients) {
            if (patient.getId() == id) {
                return patient;
            }
        }
        return null;
    }

    private static Doctor findDoctorById(int id) {
        for (Doctor doctor : doctors) {
            if (doctor.getId() == id) {
                return doctor;
            }
        }
        return null;
    }
}

