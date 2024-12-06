import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static ContactDAO contactDAO = new ContactDAO();

    public static void main(String[] args) {
        boolean exit = false;

        while (!exit) {
            System.out.println("1. Add Contact");
            System.out.println("2. View Contacts");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addContact();
                    break;
                case 2:
                    viewContacts();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    deleteContact();
                    break;
                case 5:
                    exit = true;
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    private static void addContact() {
        System.out.print("Enter name: ");
        String name = scanner.nextLine();
        System.out.print("Enter phone number: ");
        String phone = scanner.nextLine();

        contactDAO.addContact(name, phone);
    }

    private static void viewContacts() {
        contactDAO.viewContacts();
    }

    private static void updateContact() {
        System.out.print("Enter contact ID to update: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.print("Enter new name: ");
        String name = scanner.nextLine();
        System.out.print("Enter new phone number: ");
        String phone = scanner.nextLine();

        contactDAO.updateContact(id, name, phone);
    }

    private static void deleteContact() {
        System.out.print("Enter contact ID to delete: ");
        int id = scanner.nextInt();

        contactDAO.deleteContact(id);
    }
}
