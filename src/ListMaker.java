import java.util.ArrayList;
import java.util.Scanner;

public class ListMaker {

    private static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            displayMenu();
            String choice = SafeInput.getRegExString(scanner, "Enter a choice: ", "[AaDdIiPpQq]").toUpperCase();

            switch (choice) {
                case "A":
                    addItem(scanner);
                    break;
                case "D":
                    deleteItem(scanner);
                    break;
                case "I":
                    insertItem(scanner);
                    break;
                case "P":
                    printList();
                    break;
                case "Q":
                    if (SafeInput.getYNConfirm(scanner, "Are you sure you want to quit?")) {
                        running = false;
                    }
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
        scanner.close();
    }

    // Display the menu and the current list
    private static void displayMenu() {
        System.out.println("\nMenu Options:");
        System.out.println("A - Add an item");
        System.out.println("D - Delete an item");
        System.out.println("I - Insert an item");
        System.out.println("P - Print the list");
        System.out.println("Q - Quit");
        System.out.print("Current List: ");
        printList();
    }

    // Method to add an item to the end of the list
    private static void addItem(Scanner scanner) {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter an item to add: ");
        list.add(item);
        System.out.println("Item added to the list.");
    }

    // Method to delete an item by its number from the list
    private static void deleteItem(Scanner scanner) {
        if (list.isEmpty()) {
            System.out.println("The list is empty. Nothing to delete.");
            return;
        }
        printList();
        int index = SafeInput.getRangedInt(scanner, "Enter the item number to delete: ", 1, list.size()) - 1;
        list.remove(index);
        System.out.println("Item deleted from the list.");
    }

    // Method to insert an item at a specific position in the list
    private static void insertItem(Scanner scanner) {
        String item = SafeInput.getNonZeroLenString(scanner, "Enter an item to insert: ");
        int index = SafeInput.getRangedInt(scanner, "Enter the position number to insert the item: ", 1, list.size() + 1) - 1;
        list.add(index, item);
        System.out.println("Item inserted into the list.");
    }

    // Method to print the current list with numbered items
    private static void printList() {
        if (list.isEmpty()) {
            System.out.println("List is empty.");
        } else {
            for (int i = 0; i < list.size(); i++) {
                System.out.println((i + 1) + ". " + list.get(i));
            }
        }
    }
}
