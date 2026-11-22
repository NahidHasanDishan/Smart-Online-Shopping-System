public class MobileBankingPayment extends Payment {

    @Override
    public void processPayment(double amount) {
        System.out.println(
                "Payment of " + amount +
                        " processed using Mobile Banking."
        );
    }
}