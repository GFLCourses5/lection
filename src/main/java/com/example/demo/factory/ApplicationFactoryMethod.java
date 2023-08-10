package com.example.demo.factory;

public class ApplicationFactoryMethod {
    private static PrintFactoryService printFactoryService;

    public static void main(String[] args) {
        configuration(Language.DELPHI);
        printFactoryService.print();
    }

    private static void configuration(Language language) {
        switch (language) {
            case JAVA:
                printFactoryService = new JavaFactory();
                break;
            case PYTHON:
                printFactoryService = new PythonFactory();
                break;
            case DELPHI:
                printFactoryService = new DelphiFactory();
                break;
        }
    }
}
