import java.util.*;

class Item {
    private String name;
    private int quantity;
    private double price;

    public Item(String name, int quantity, double price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Name: " + name + " | Qty: " + quantity + " | Price: Rs." + price;
    }
}

public class InventorySystem {
    public static void main(String[] args) {
        HashMap<String, Item> inventory = new HashMap<>();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n----- INVENTORY SYSTEM -----");
            System.out.println("1. Add/Update Item");
            System.out.println("2. View Inventory");
            System.out.println("3. Remove Item");
            System.out.println("4. Exit");
            System.out.print("Enter Choice: ");
            
            int choice = sc.nextInt();
            sc.nextLine(); 
            if (choice == 1) {
                System.out.print("Enter Item ID: ");
                String id = sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Quantity: ");
                int qty = sc.nextInt();
                System.out.print("Enter Price: ");
                double price = sc.nextDouble();

                inventory.put(id, new Item(name, qty, price));
                System.out.println("Item saved successfully.");

            } else if (choice == 2) {
                System.out.println("\n--- Current Stock ---");
                if (inventory.isEmpty()) {
                    System.out.println("Inventory is empty.");
                } else {
                    for (String id : inventory.keySet()) {
                        System.out.println("ID: " + id + " | " + inventory.get(id));
                    }
                }

            } else if (choice == 3) {
                System.out.print("Enter ID to remove: ");
                String id = sc.nextLine();
                if (inventory.containsKey(id)) {
                    inventory.remove(id);
                    System.out.println("Item deleted.");
                } else {
                    System.out.println("Error: ID not found.");
                }

            } else if (choice == 4) {
                System.out.println("Exiting System...");
                break;
            } else {
                System.out.println("Invalid Option.");
            }
        }
        sc.close();
    }
}
