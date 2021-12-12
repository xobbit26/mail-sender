package com.example.mail_sender.enums;

public enum TestEnum {
    VALUE_ONE(0, "zero"),
    VALUE_TWO(1, "one");

    private final int value;
    private final String str;

    TestEnum(final int value, final String str) {
        this.value = value;
        this.str = str;
    }

    public int getValue() {
        return value;
    }

    public String getStr() {
        return str;
    }
}
