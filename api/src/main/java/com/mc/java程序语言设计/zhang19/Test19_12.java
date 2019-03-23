package com.mc.java程序语言设计.zhang19;

public class Test19_12 extends Test19_10<Double> {
    @Override
    protected Double add(Double o1, Double o2) {
        return o1 + o2;
    }

    @Override
    protected Double multiply(Double o1, Double o2) {
        return o1 * o2;
    }

    @Override
    protected Double zero() {
        return 0.0;
    }
}
