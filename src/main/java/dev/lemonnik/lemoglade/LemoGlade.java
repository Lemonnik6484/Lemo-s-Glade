package dev.lemonnik.lemoglade;

import dev.lemonnik.lemoglade.registries.ModBlocks;
import net.fabricmc.api.ModInitializer;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LemoGlade implements ModInitializer {
	public static final String MOD_ID = "lemoglade";

	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Starting Lemo's Glade!");
        ModBlocks.registerModBlocks();
	}

    public static Identifier id(String name) {
        return Identifier.of(MOD_ID, name);
    }
}