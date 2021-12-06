package com.example.mail_sender.enums;

public enum TestEnum {
    VALUE_ONE(0),
    VALUE_TWO(1);

    private final int value;

    TestEnum(final int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
