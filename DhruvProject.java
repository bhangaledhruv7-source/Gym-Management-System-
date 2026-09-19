import java.util.ArrayList;
import java.util.Scanner;

// Interface
interface Manageable {
    void showDetails();
}

// Abstract class
abstract class Person {
    String name, gender, address, phone, email;

    Person(String name, String gender, String address, String phone, String email) {
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
}

// GymMember class
class GymMember extends Person implements Manageable {
    String plan;

    GymMember(String name, String gender, String address, String phone, String email, String plan) {
        super(name, gender, address, phone, email);
        this.plan = plan;
    }

    public void showDetails() {
        System.out.println("Name    : " + name);
        System.out.println("Gender  : " + gender);
        System.out.println("Phone   : " + phone);
        System.out.println("Email   : " + email);
        System.out.println("Address : " + address);
        System.out.println("Plan    : " + plan);
        System.out.println("---------------------------");
    }
}

// Main class
public class DhruvProject {

    static ArrayList<GymMember> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

       

        while (true) {
            System.out.println("\n=== GYM SYSTEM ===");
            System.out.println("1. Add Member");
            System.out.println("2. View Members");
            System.out.println("3. Search by Phone Number"); // ✅ changed
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = sc.nextInt();
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Enter valid input");
                sc.nextLine();
                continue;
            }

            switch (choice) {
                case 1:
                    addMember();
                    break;

                case 2:
                    viewMembers();
                    break;

                case 3:
                    searchByPhone(); // ✅ changed
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // Add member
    static void addMember() {
        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Gender: ");
        String gender = sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        String phone;

    while (true) {
        System.out.print("Enter Phone (10 digits): ");
        phone = sc.nextLine();

    // check: length = 10 AND only digits
        if (phone.length() == 10) {
            break; // valid → exit loop
        } else {
            System.out.println("Invalid Number Entered");
        }
    }

        System.out.print("Enter Email: ");
        String email = sc.nextLine();

        String plan = choosePlan();

        members.add(new GymMember(name, gender, address, phone, email, plan));
        System.out.println("Member added!");
    }

    // Choose plan
    static String choosePlan() {
        System.out.println("1. Monthly  2. Quarterly  3. Half Year  4. Yearly");

        int p;

        try {
            p = sc.nextInt();
            sc.nextLine();
        } catch (Exception e) {
            System.out.println("Enter valid input");
            sc.nextLine();
            return "None";
        }

        switch (p) {
            case 1: return "Monthly";
            case 2: return "Quarterly";
            case 3: return "Half Year";
            case 4: return "Yearly";
            default: return "None";
        }
    }

    // View members
    static void viewMembers() {
        for (GymMember m : members) {
            m.showDetails();
        }
    }

    // 🔍 Search by phone number
    static void searchByPhone() {
        System.out.print("Enter phone number: ");
        String phone = sc.nextLine();

        boolean found = false;

        for (GymMember m : members) {
            if (m.phone.equals(phone)) {
                m.showDetails();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Not Found");
        }
    }
}