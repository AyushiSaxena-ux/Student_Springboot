package com.example.test.sample.service;

public class FactoryCreator {


        public static StudentFactory getFactory() {
        return new StudentFactoryImpl();
        }


    }
