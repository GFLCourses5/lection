package com.example.demo.factory;

public class JavaPrintService implements PrintService{
    @Override
    public void print() {
        System.out.println("Java print");
    }
}
