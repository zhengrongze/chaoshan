package com.mc.java程序语言设计.zhang19;

public class Test19_11 extends  Test19_10<Integer> {
    @Override
    protected Integer add(Integer o1, Integer o2) {
        return o1 + o2;
    }

    @Override
    protected Integer multiply(Integer o1, Integer o2) {
        return o1 * o2;
    }

    @Override
    protected Integer zero() {
        return 0;
    }
}
