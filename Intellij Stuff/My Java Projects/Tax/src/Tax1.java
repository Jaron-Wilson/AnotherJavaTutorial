public class Tax1 {
    public static double main(String[] args) {
        public static double calcTax () {
            double stateTax = 0;
            if (stateTax < 30000) {
                stateTax = stateTax * 0.05;
            } else {
                stateTax = stateTax * 0.06;
            }
            return stateTax;
        }
    }
}