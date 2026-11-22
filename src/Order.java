import java.io.FileWriter;
import java.io.IOException;

public class Order implements Discountable {

    private int orderId;
    private Customer customer;
    private ShoppingCart cart;
    private Payment payment;

    public Order(int orderId, Customer customer,
                 ShoppingCart cart, Payment payment) {

        this.orderId = orderId;
        this.customer = customer;
        this.cart = cart;
        this.payment = payment;
    }

    @Override
    public double calculateDiscount(double total) {

        if (total >= 1000) {
            return total * 0.10;
        }

        return 0;
    }

    public double getFinalAmount() {

        double total = cart.calculateTotal();
        double discount = calculateDiscount(total);

        return total - discount;
    }

    public void checkout() {

        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
            return;
        }

        double total = cart.calculateTotal();
        double discount = calculateDiscount(total);
        double finalAmount = total - discount;

        payment.processPayment(finalAmount);

        System.out.println("Checkout completed successfully.");
        System.out.println("Total Amount: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + finalAmount);
    }

    public void generateInvoice() {

        double total = cart.calculateTotal();
        double discount = calculateDiscount(total);
        double finalAmount = total - discount;

        System.out.println();
        System.out.println("========== INVOICE ==========");
        System.out.println("Order ID: " + orderId);
        System.out.println("Customer: " +
                customer.getCustomerName());

        System.out.println("\nPurchased Products:");

        for (Product product : cart.getProducts()) {

            System.out.println(
                    product.getProductName() +
                            " - " + product.getPrice()
            );
        }

        System.out.println("-----------------------------");
        System.out.println("Total Amount: " + total);
        System.out.println("Discount: " + discount);
        System.out.println("Final Amount: " + finalAmount);
        System.out.println("=============================");
    }

    public void saveOrder(String paymentMethod) {

        try {

            FileWriter writer =
                    new FileWriter("orders.txt", true);

            writer.write("Order ID: " + orderId + "\n");
            writer.write("Customer Name: " +
                    customer.getCustomerName() + "\n");

            writer.write("Purchased Products:\n");

            for (Product product : cart.getProducts()) {

                writer.write(
                        product.getProductName() +
                                " - " +
                                product.getPrice() +
                                "\n"
                );
            }

            writer.write("Total Amount: " +
                    getFinalAmount() + "\n");

            writer.write("Payment Method: " +
                    paymentMethod + "\n");

            writer.write("-----------------------------\n");

            writer.close();

            System.out.println(
                    "Order information saved successfully."
            );

        } catch (IOException e) {

            System.out.println(
                    "Error saving order information."
            );
        }
    }
}