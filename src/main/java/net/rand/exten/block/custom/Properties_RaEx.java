package net.rand.exten.block.custom;

import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.EnumProperty;
import net.rand.exten.block.custom.Enums.ExampleType;

public class Properties_RaEx {
    public static final EnumProperty<ExampleType> Example = EnumProperty.of("example", ExampleType.class);
    public static final BooleanProperty TOP_OR_BOTTOM = BooleanProperty.of("top_or_bottom");
    public static final BooleanProperty IS_ON = BooleanProperty.of("is_on");
}
