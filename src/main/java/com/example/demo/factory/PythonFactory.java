package com.example.demo.factory;

public class PythonFactory extends PrintFactoryService {
    @Override
    PrintService createPrintService() {
        return new PythonPrintService();
    }
}
