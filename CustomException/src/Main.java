public class Main {
    public static void main(String[] args) {
        CoffeeCup cup = new CoffeeCup();
        VirtualPerson customer = new VirtualPerson();

        cup.setTemperature(12);
//         cup.setTemperature(90);
//         cup.setTemperature(75);
        VirtualCafe.serveCustomer(customer, cup);
    }
}
