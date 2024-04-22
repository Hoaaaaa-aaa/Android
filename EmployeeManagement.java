import java.util.ArrayList;
import java.util.Scanner;

class Employee {
    private int id;
    private String name;
    private int age;
    private String department;
    private String code;
    private double salaryRate;

    public Employee(int id, String name, int age, String department, String code, double salaryRate) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.department = department;
        this.code = code;
        this.salaryRate = salaryRate;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", department='" + department + '\'' +
                ", code='" + code + '\'' +
                ", salaryRate=" + salaryRate;
    }
}

public class EmployeeManagement {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeEmployees();
        displayEmployees();

        boolean a;
        do{
            a = true;
            System.out.println("\nChoose: \n   (1) Add\n   (2) Remove\n   (Other number) End program");
            System.out.print("Choose: ");
            int choice = scanner.nextInt();
            if (choice == 1){
                // Thêm một nhân viên mới
                addEmployee();
                displayEmployees();
                a = false;
            }
            else if (choice == 2){
                // Xóa một nhân viên
                removeEmployee();
                displayEmployees();
                a = false;
            }
            else
                System.out.println("End!");
        }while(!a);   
    }

    private static void initializeEmployees() {
        employees.add(new Employee(1, "Alice", 25, "HR", "A123", 3000.0));
        employees.add(new Employee(2, "Bob", 28, "Finance", "B456", 3200.0));
        employees.add(new Employee(3, "Charlie", 32, "Marketing", "C789", 3400.0));
        employees.add(new Employee(4, "David", 35, "Sales", "D101", 3300.0));
        employees.add(new Employee(5, "Emma", 27, "IT", "E202", 3600.0));
        employees.add(new Employee(6, "Frank", 29, "Finance", "F303", 3100.0));
        employees.add(new Employee(7, "Grace", 31, "Marketing", "G404", 3300.0));
        employees.add(new Employee(8, "Henry", 33, "Sales", "H505", 3500.0));
        employees.add(new Employee(9, "Ivy", 26, "IT", "I606", 3700.0));
        employees.add(new Employee(10, "Jack", 28, "HR", "J707", 3200.0));
    }

    private static void displayEmployees() {
        System.out.println("Employee List:");
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private static void addEmployee() {
        System.out.println("\nEnter new employee details:");
        boolean a;
        int id;
        do{
            a = true;
            System.out.print("ID: ");
            id = scanner.nextInt();
            for (int i = 0; i < employees.size(); i++) {
                if (employees.get(i).getId() == id) {
                    System.out.println("Employee with ID " + id + " already exists.");
                    a = false;
                    break;
                }
            }
        }while(!a);
        scanner.nextLine(); // Consume newline character
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Age: ");
        int age = scanner.nextInt();
        scanner.nextLine(); // Consume newline character
        System.out.print("Department: ");
        String department = scanner.nextLine();
        System.out.print("Code: ");
        String code = scanner.nextLine();
        System.out.print("Salary Rate: ");
        double salaryRate = scanner.nextDouble();

        employees.add(new Employee(id, name, age, department, code, salaryRate));
    }

    private static void removeEmployee() {
        System.out.print("\nEnter ID of employee to remove: ");
        int idToRemove = scanner.nextInt();
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == idToRemove) {
                employees.remove(i);
                System.out.println("Employee with ID " + idToRemove + " removed successfully.");
                return;
            }
        }
        System.out.println("Employee with ID " + idToRemove + " not found.");
    }
}

