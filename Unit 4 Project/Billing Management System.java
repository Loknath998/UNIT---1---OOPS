import java.util.*;
class InvalidBillingException extends Exception {
    public InvalidBillingException(String message) {
        super(message);
    }
}
class BillItem<T extends Number> {
    private String itemName;
    private T price;
    public BillItem(String itemName, T price) {
        this.itemName = itemName;
        this.price = price;
    }
    public String getName() { return itemName; }
    public double getPrice() { return price.doubleValue(); }
}
public class BillingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<BillItem<Double>> cart = new ArrayList<>();
        double total = 0;
        while (true) {
            System.out.println("\n--- RETAIL BILLING SYSTEM ---");
            System.out.println("1. Add Item to Bill");
            System.out.println("2. View Cart & Total");
            System.out.println("3. Checkout & Pay");
            System.out.println("4. Exit");
            System.out.print("Select Option: ");
            try {
                int choice = Integer.parseInt(sc.nextLine());
                if (choice == 1) {
                    System.out.print("Enter Item Name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter Price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    if (price <= 0) throw new InvalidBillingException("Price must be positive!");
                    cart.add(new BillItem<>(name, price));
                    System.out.println("Item added.");
                } 
                else if (choice == 2) {
                    System.out.println("\n--- Current Cart ---");
                    total = 0;
                    if (cart.isEmpty()) {
                        System.out.println("Cart is empty.");
                    } else {
                        for (BillItem<Double> item : cart) {
                            System.out.println(item.getName() + " : Rs." + item.getPrice());
                            total += item.getPrice();
                        }
                        System.out.println("Subtotal: Rs." + total);
                    }
                } 
                else if (choice == 3) {
                    if (cart.isEmpty()) throw new InvalidBillingException("Cart is empty!");
                    double finalAmount = total + (total * 0.05); // 5% GST
                    System.out.println("Total (incl. 5% GST): Rs." + finalAmount);
                    System.out.print("Enter Payment Amount: ");
                    double payment = Double.parseDouble(sc.nextLine());
                    if (payment < finalAmount) {
                        throw new InvalidBillingException("Insufficient Payment! Balance due: " + (finalAmount - payment));
                    }
                    System.out.println("Payment Successful! Change: Rs." + (payment - finalAmount));
                    cart.clear(); 
                } 
                else if (choice == 4) {
                    System.out.println("Exiting System...");
                    break;
                }
            } 
            catch (NumberFormatException e) {
                System.out.println("Error: Please enter a valid numeric value.");
            } 
            catch (InvalidBillingException e) {
                System.out.println("Billing Error: " + e.getMessage());
            }
        }
        sc.close();
    }
}
