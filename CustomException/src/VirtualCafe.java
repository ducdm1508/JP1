class VirtualCafe {
    public static void serveCustomer(VirtualPerson cust,CoffeeCup cup){
        try {
            cust.drinkCoffee(cup);
            System.out.println("Coffee is just right");
        }
        catch (TooColdException e) {
            System.out.println("Coffee is too cold");
        }
        catch (TemperatureException e) {

            System.out.println("There's temperature trouble in this coffee");

        }
    }
}