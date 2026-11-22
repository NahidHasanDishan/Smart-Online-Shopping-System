import java.util.ArrayList;

public class ShoppingCart {

    private ArrayList<Product> products;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product)
            throws ProductQuantityException {

        if (product.getAvailableQuantity() <= 0) {
            throw new ProductQuantityException(
                    "Product quantity is zero or negative."
            );
        }

        products.add(product);

        product.setAvailableQuantity(
                product.getAvailableQuantity() - 1
        );

        System.out.println("Product added to cart successfully.");
    }

    public void removeProduct(int productId)
            throws ProductNotFoundException {

        for (Product product : products) {

            if (product.getProductId() == productId) {

                product.setAvailableQuantity(
                        product.getAvailableQuantity() + 1
                );

                products.remove(product);

                System.out.println(
                        "Product removed from cart successfully."
                );

                return;
            }
        }

        throw new ProductNotFoundException(
                "Product does not exist in the cart."
        );
    }

    public void displayCart() {

        if (products.isEmpty()) {
            System.out.println("Shopping cart is empty.");
            return;
        }

        System.out.println("========== Shopping Cart ==========");

        for (Product product : products) {
            product.displayInfo();
        }

        System.out.println("Total Amount: " + calculateTotal());
    }

    public double calculateTotal() {

        double total = 0;

        for (Product product : products) {
            total += product.getPrice();
        }

        return total;
    }

    public ArrayList<Product> getProducts() {
        return products;
    }

    public boolean isEmpty() {
        return products.isEmpty();
    }
}