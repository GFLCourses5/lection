package com.example.demo.abstractFactory;

public class JavaFactory extends PrintFactoryService {
    @Override
    PrintService createPrintService() {
        return new JavaPrintService();
    }
}
