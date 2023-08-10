package com.example.demo.factory;

public class JavaFactory extends PrintFactoryService{
    @Override
    PrintService createPrintService() {
        return new JavaPrintService();
    }
}
