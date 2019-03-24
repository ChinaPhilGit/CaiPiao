package com.phil.colson.CaiPiao.enums;

public enum EnumBigOrSmall {
    大((byte) 0), 小((byte) 1);

    Byte value;

    EnumBigOrSmall(Byte value) {
        this.value = value;
    }

    public static EnumBigOrSmall getEnum(Byte value) {
        if (value == null)
            return null;
        for (EnumBigOrSmall examType : EnumBigOrSmall.values()) {
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
