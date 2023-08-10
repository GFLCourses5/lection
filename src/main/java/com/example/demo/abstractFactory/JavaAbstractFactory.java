package com.example.demo.abstractFactory;

public class JavaAbstractFactory extends LanguageAbstractFactory{
    @Override
    PrintService createPrintService() {
        return new JavaPrintService();
    }

    @Override
    MathService createMathService() {
        return new JavaMathService();
    }
}
