package justfatlard.bamboo_fence;

import net.fabricmc.api.ModInitializer;
import justfatlard.bamboo_fence.block.BlockRegistry;
import justfatlard.bamboo_fence.item.ItemRegistry;

public class BambooFence implements ModInitializer {
	@Override
	public void onInitialize(){
		BlockRegistry.registerBlocks();
		ItemRegistry.registerItems();
	}
}