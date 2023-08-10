package com.example.demo.abstractFactory;

import org.springframework.context.annotation.Bean;

public class ApplicationFactoryMethod {
    private static LanguageAbstractFactory printFactoryService;

    public static void main(String[] args) {
        configuration(Language.PYTHON);
        printFactoryService.print();
        printFactoryService.math();
    }

    @Bean
    private static void configuration(Language language) {
        switch (language) {
            case JAVA:
                printFactoryService = new JavaAbstractFactory();
                break;
            case PYTHON:
                printFactoryService = new PythonAbstractFactory();
                break;
            case DELPHI:
                break;
        }
    }
}
