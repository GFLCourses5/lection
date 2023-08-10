package com.example.demo.abstractFactory;

public class PythonFactory extends PrintFactoryService {
    @Override
    PrintService createPrintService() {
        return new PythonPrintService();
    }
}
