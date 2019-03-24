package com.phil.colson.CaiPiao.enums;

public enum EnumSingleOrDouble {
    单((byte) 0), 双((byte) 1);

    Byte value;

    EnumSingleOrDouble(Byte value) {
        this.value = value;
    }

    public static EnumSingleOrDouble getEnum(Byte value) {
        if (value == null)
            return null;
        for (EnumSingleOrDouble examType : EnumSingleOrDouble.values()) {
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
