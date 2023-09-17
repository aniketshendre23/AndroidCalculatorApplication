package com.example.inclassassessment1;

import java.io.Serializable;

public class CalcObject implements Serializable {
    double a = 0.0;

    double b = 0.0;

    String operation = "";

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getOperation() {
        return operation;
    }

    public CalcObject(double a, double b, String operation) {
        this.a = a;
        this.b = b;
        this.operation = operation;
    }

    public CalcObject() {
    }

    public void setB(double b) {
        this.b = b;
    }



    public double getB() {
        return b;
    }


}
