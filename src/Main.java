import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        ArrayList<Product> products = new ArrayList<>();

        ShoppingCart cart = new ShoppingCart();

        Customer customer = null;

        Order order = null;

        int choice;

        // Student information
        System.out.println("====================================");
        System.out.println("Student ID: 251-35-290");
        System.out.println("Student Name: Md Nahid Hasan Dishan");
        System.out.println("====================================");

        do {

            System.out.println();
            System.out.println("========== Online Shopping System ==========");
            System.out.println("1. Add Product");
            System.out.println("2. Display Products");
            System.out.println("3. Add Product to Cart");
            System.out.println("4. Remove Product from Cart");
            System.out.println("5. Display Shopping Cart");
            System.out.println("6. Checkout");
            System.out.println("7. Save Order");
            System.out.println("8. Exit");

            System.out.print("Enter Your Choice: ");
            choice = input.nextInt();
            input.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Enter Product ID: ");
                    int productId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Product Name: ");
                    String productName = input.nextLine();

                    System.out.print("Enter Price: ");
                    double price = input.nextDouble();

                    System.out.print("Enter Available Quantity: ");
                    int quantity = input.nextInt();

                    try {

                        if (quantity <= 0) {
                            throw new ProductQuantityException(
                                    "Product quantity must be greater than zero."
                            );
                        }

                        Product product = new Product(
                                productId,
                                productName,
                                price,
                                quantity
                        );

                        products.add(product);

                        System.out.println(
                                "Product added successfully."
                        );

                    } catch (ProductQuantityException e) {

                        System.out.println(
                                "Error: " + e.getMessage()
                        );
                    }

                    break;

                case 2:

                    if (products.isEmpty()) {

                        System.out.println(
                                "No products available."
                        );

                    } else {

                        System.out.println(
                                "\n========== Products =========="
                        );

                        for (Product p : products) {
                            p.displayInfo();
                        }
                    }

                    break;

                case 3:

                    System.out.print("Enter Product ID: ");
                    int addId = input.nextInt();

                    boolean foundAdd = false;

                    for (Product p : products) {

                        if (p.getProductId() == addId) {

                            foundAdd = true;

                            try {
                                cart.addProduct(p);
                            } catch (ProductQuantityException e) {
                                System.out.println(
                                        "Error: " +
                                                e.getMessage()
                                );
                            }

                            break;
                        }
                    }

                    if (!foundAdd) {
                        System.out.println(
                                "Error: Product does not exist."
                        );
                    }

                    break;

                case 4:

                    System.out.print("Enter Product ID: ");
                    int removeId = input.nextInt();

                    try {

                        cart.removeProduct(removeId);

                    } catch (ProductNotFoundException e) {

                        System.out.println(
                                "Error: " + e.getMessage()
                        );
                    }

                    break;

                case 5:

                    cart.displayCart();

                    break;

                case 6:

                    if (cart.isEmpty()) {

                        System.out.println(
                                "Cannot checkout. Cart is empty."
                        );

                        break;
                    }

                    System.out.print("Enter Customer ID: ");
                    int customerId = input.nextInt();
                    input.nextLine();

                    System.out.print("Enter Customer Name: ");
                    String customerName = input.nextLine();

                    customer = new Customer(
                            customerId,
                            customerName
                    );

                    System.out.println(
                            "1. Credit Card"
                    );

                    System.out.println(
                            "2. Mobile Banking"
                    );

                    System.out.print(
                            "Choose Payment Method: "
                    );

                    int paymentChoice = input.nextInt();

                    Payment payment;
                    String paymentMethod;

                    if (paymentChoice == 1) {

                        payment = new CreditCardPayment();
                        paymentMethod = "Credit Card";

                    } else if (paymentChoice == 2) {

                        payment = new MobileBankingPayment();
                        paymentMethod = "Mobile Banking";

                    } else {

                        System.out.println(
                                "Invalid payment method."
                        );

                        break;
                    }

                    System.out.print("Enter Order ID: ");
                    int orderId = input.nextInt();

                    order = new Order(
                            orderId,
                            customer,
                            cart,
                            payment
                    );

                    order.checkout();
                    order.generateInvoice();

                    break;

                case 7:

                    if (order == null) {

                        System.out.println(
                                "Please complete checkout first."
                        );

                    } else {

                        System.out.println(
                                "1. Credit Card"
                        );

                        System.out.println(
                                "2. Mobile Banking"
                        );

                        System.out.print(
                                "Enter Payment Method: "
                        );

                        int method = input.nextInt();

                        if (method == 1) {

                            order.saveOrder("Credit Card");

                        } else if (method == 2) {

                            order.saveOrder("Mobile Banking");

                        } else {

                            System.out.println(
                                    "Invalid payment method."
                            );
                        }
                    }

                    break;

                case 8:

                    System.out.println(
                            "Thank you for using the Online Shopping System."
                    );

                    break;

                default:

                    System.out.println(
                            "Invalid choice."
                    );
            }

        } while (choice != 8);

        input.close();
    }
}