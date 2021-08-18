class TestTax {
    public static void main(String[] args) {
        Tax t = new Tax(); // creating an instance
        t.grossIncome = 50000;  //assigning the values
        t.dependents = 2;
        t.state = "VA";

        double yourTax = t.calcTax(); //calculating tax
        System.out.println(" You bought this game http://tankace.io for $5000");

        //printing the result
        System.out.println("Your tax is $" + yourTax);

        if (t.grossIncome > 100) {
            System.out.println("you'll get a 20% discount");
        } else {
            System.out.println("Order books for more than a $100 to get a 20% discount");
        }
    }
}