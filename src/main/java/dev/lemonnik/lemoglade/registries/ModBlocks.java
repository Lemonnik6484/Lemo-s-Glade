package dev.lemonnik.lemoglade.registries;

import dev.lemonnik.lemoglade.LemoGlade;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;

import java.util.function.Function;

public class ModBlocks {
    public static final Block SMALL_CLOVERS = registerBlock("small_clovers",
            properties -> new FlowerbedBlock(
                    AbstractBlock.Settings.create()
                            .mapColor(MapColor.EMERALD_GREEN)
                            .noCollision()
                            .sounds(BlockSoundGroup.PINK_PETALS)
                            .pistonBehavior(PistonBehavior.DESTROY)
            )
    );

    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create());
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, LemoGlade.id(name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, LemoGlade.id(name),
                function.apply(AbstractBlock.Settings.create()));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, LemoGlade.id(name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        LemoGlade.LOGGER.info("Registering blocks for " + LemoGlade.MOD_ID);
    }
}
