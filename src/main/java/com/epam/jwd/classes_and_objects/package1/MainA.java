package com.epam.jwd.classes_and_objects.package1;

public class MainA {
    public static void main(String[] args) {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();

        Fraction f3;

        f1.setNumerator(1);
        f1.setDenominator(2);

        f2.setNumerator(5);
        f2.setDenominator(8);

        f3 = add(f1, f2);

        System.out.println(f3.getNumerator() + "/" + f3.getDenominator());
    }

    private static Fraction add(Fraction f1, Fraction f2) {
        int num;
        int den;

        den = f1.getDenominator() * f2.getDenominator();
        num = f1.getNumerator() * f2.getDenominator() + f2.getNumerator() * f1.getDenominator();

        Fraction f = new Fraction();
        f.setNumerator(num);
        f.setDenominator(den);

        return f;
    }
}
