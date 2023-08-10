package com.example.demo.abstractFactory;

public class DelphiPrintService implements PrintService {
    @Override
    public void print() {
        System.out.println("Delphi print");
    }
}
