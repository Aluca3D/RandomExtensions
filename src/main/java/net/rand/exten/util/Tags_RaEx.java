package net.rand.exten.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.rand.exten.RandomExtensions;

public class Tags_RaEx {
    public static class Blocks {

        public static final TagKey<Block> PAXEL_MINEABLE =
                createTag("mineable/paxel");

        private static TagKey<Block> createTag(String name) {
            return TagKey.of(RegistryKeys.BLOCK, new Identifier(RandomExtensions.MOD_ID, name));
        }
    }

    public static class Items {

        public static final TagKey<Item> GEMS =
                createTag("gems");

        public static final TagKey<Item> PROJECTILE =
                createTag("projectile");

        public static final TagKey<Item> LEGENDARY =
                createTag("legendary");

        public static final TagKey<Item> SWORD =
                createTag("sword");

        private static TagKey<Item> createTag(String name) {
            return TagKey.of(RegistryKeys.ITEM, new Identifier(RandomExtensions.MOD_ID, name));
        }
    }
}
