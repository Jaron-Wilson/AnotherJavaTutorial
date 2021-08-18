class TestTax2 {
    public static void main(String[] args) {
        Tax t = new Tax(); // creating an instance
        t.grossIncome = 50000;  //assigning the values
        t.dependents = 2;
        t.state = "VA";
        double yourTax = t.calcTax(); //calculating tax
        int taxCode = 2;
        switch (taxCode) {
            case 0:
                System.out.println("Tax Exempt");
                break;
            case 1:
                System.out.println("Low Tax Bracket");
                break;
            case 2:
                System.out.println("High Tax Bracket");
                break;
            default:
                System.out.println("Wrong Tax Bracket");
        }
    }
}