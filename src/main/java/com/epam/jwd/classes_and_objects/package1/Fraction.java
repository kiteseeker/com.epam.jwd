package com.epam.jwd.classes_and_objects.package1;

public class Fraction {
    private int numerator;
    private int denominator;

    public Fraction() {
        numerator = 0;
        denominator = 1;
    }

    public Fraction(int numerator, int denominator) {
        this.numerator = numerator;
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator is zero.");
        }
        this.denominator = denominator;
    }

    public int getNumerator() {
        return numerator;
    }

    public int getDenominator() {
        return denominator;
    }

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public void setDenominator(int denominator) {
        if (denominator == 0) {
            throw new IllegalArgumentException("The denominator is zero.");
        }
        this.denominator = denominator;
    }

    public Fraction addition(Fraction f) {
        int num;
        int den;
        den = denominator * f.denominator;
        num = numerator * f.denominator + f.numerator * denominator;
        Fraction result = new Fraction(num, den);
        return result;
    }

    public Fraction substraction(Fraction f) {
        int num;
        int den;
        den = denominator * f.denominator;
        num = numerator * f.denominator - f.numerator * denominator;
        Fraction result = new Fraction(num, den);
        return result;
    }

    public Fraction multiplication(Fraction f) {
        int num, den;
        den = denominator * f.denominator;
        num = numerator * f.numerator;
        Fraction result = new Fraction(num, den);
        return result;
    }

    public Fraction division(Fraction f) {
        int num, den;
        den = denominator * f.numerator;
        num = numerator * f.denominator;
        Fraction result = new Fraction(num, den);
        return result;
    }
}
