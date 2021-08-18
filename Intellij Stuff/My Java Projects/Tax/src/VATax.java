class VATax extends Tax{
    VATax  t= new VATax();

    double adjustForStudents (double stateTax) {
        double adjustedTax = stateTax - 500;
        return adjustedTax;
    }
}
