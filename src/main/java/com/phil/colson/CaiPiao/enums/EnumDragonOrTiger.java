package com.phil.colson.CaiPiao.enums;

public enum EnumDragonOrTiger {
    龙((byte) 0), 虎((byte) 1), 合((byte) 2);

    Byte value;

    EnumDragonOrTiger(Byte value) {
        this.value = value;
    }

    public static EnumDragonOrTiger getEnum(Byte value) {
        if (value == null)
            return null;
        for (EnumDragonOrTiger examType : EnumDragonOrTiger.values()) {
            if (value == examType.value) {
                return examType;
            }
        }
        return null;
    }

    public String getName() {
        return this.name();
    }

    public Byte getValue() {
        return value;
    }
}
