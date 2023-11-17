package net.rand.exten.block.custom.Enums;

import net.minecraft.util.StringIdentifiable;

public enum ExampleType implements StringIdentifiable {

    EXAMPLE_TYPE("example"),
    EXAMPLE_TYPE_2("example2"),
    EXAMPLE_TYPE_3("example3"),
    ;

    private final String name;

    private ExampleType(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }


    @Override
    public String asString() {
        return this.name;
    }
}
