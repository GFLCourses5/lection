package com.example.demo.abstractFactory;

public class PythonAbstractFactory extends LanguageAbstractFactory {
    @Override
    PrintService createPrintService() {
        return new PythonPrintService();
    }

    @Override
    MathService createMathService() {
        return new PythonMathService();
    }
}
