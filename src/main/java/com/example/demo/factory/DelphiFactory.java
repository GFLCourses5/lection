package com.example.demo.factory;

public class DelphiFactory extends PrintFactoryService {
    @Override
    PrintService createPrintService() {
        return new DelphiPrintService();
    }
}
