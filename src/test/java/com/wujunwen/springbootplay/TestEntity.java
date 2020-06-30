package com.wujunwen.springbootplay;


import java.math.BigDecimal;

public class TestEntity {
    private BigDecimal num;

    private Integer num1;

    public TestEntity(Integer num1) {
        this.num1 = num1;
    }

    public Integer getNum1() {
        return num1;
    }

    public void setNum1(Integer num1) {
        this.num1 = num1;
    }

    public TestEntity(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }
}
