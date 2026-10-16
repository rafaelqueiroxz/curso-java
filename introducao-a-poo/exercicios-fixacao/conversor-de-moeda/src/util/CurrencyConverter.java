package util;

public class CurrencyConverter {

    public static final double IOF = 0.06;

    public static double dollarsToReais(double dollarPrice, double dollarsQuantity) {
        return (dollarsQuantity + (dollarsQuantity * IOF)) * dollarPrice;
    }


}
