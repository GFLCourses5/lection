package com.example.demo.factory;

public abstract class PrintFactoryService {
    public PrintService print() {
        PrintService printService = createPrintService();
        printService.print();
        return printService;
    }

    abstract PrintService createPrintService();
}
