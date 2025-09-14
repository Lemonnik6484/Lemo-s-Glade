package dev.lemonnik.lemoglade;

import dev.lemonnik.lemoglade.registries.ModBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.RenderLayer;

public class LemoGladeClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SMALL_CLOVERS, RenderLayer.getTranslucent());

        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> 0x43c839, ModBlocks.SMALL_CLOVERS);
    }
}
