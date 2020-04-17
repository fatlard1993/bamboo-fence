package justfatlard.bamboo_fence.item;

import justfatlard.bamboo_fence.block.BlockRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ItemRegistry {
	private static final String MODID = "bamboo-fence-justfatlard";
	private static final ItemGroup GROUP = ItemGroup.DECORATIONS;

	public static void registerItems(){
		Registry.register(Registry.ITEM, new Identifier(MODID, "bamboo_fence_gate"), new BlockItem(BlockRegistry.BAMBOO_FENCE_GATE_BLOCK, new Item.Settings().group(GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MODID, "bamboo_fence"), new BlockItem(BlockRegistry.BAMBOO_FENCE_BLOCK, new Item.Settings().group(GROUP)));
		Registry.register(Registry.ITEM, new Identifier(MODID, "bamboo_fence_wall"), new BlockItem(BlockRegistry.BAMBOO_FENCE_WALL_BLOCK, new Item.Settings().group(GROUP)));
	}
}