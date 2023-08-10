package com.example.demo.abstractFactory;

public abstract class LanguageAbstractFactory {

    public PrintService print() {
        PrintService printService = createPrintService();
        printService.print();
        return printService;
    }

    public MathService math() {
        MathService mathService = createMathService();
        mathService.math();
        return mathService;
    }

    abstract PrintService createPrintService();

    abstract MathService createMathService();
}
