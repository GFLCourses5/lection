package com.example.demo.abstractFactory;

public class DelphiFactory extends PrintFactoryService {
    @Override
    PrintService createPrintService() {
        return new DelphiPrintService();
    }
}
