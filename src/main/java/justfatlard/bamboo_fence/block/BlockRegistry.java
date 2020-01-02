package justfatlard.bamboo_fence.block;

import net.fabricmc.fabric.api.block.FabricBlockSettings;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class BlockRegistry {
    private static final String MODID = "bamboo-fence-justfatlard";
    public static final BlockBambooFence BAMBOO_FENCE_BLOCK = new BlockBambooFence(FabricBlockSettings.of(Material.BAMBOO).sounds(BlockSoundGroup.BAMBOO).strength(2.0F, 15F).build());
    public static final BlockBambooFenceGate BAMBOO_FENCE_GATE_BLOCK = new BlockBambooFenceGate(FabricBlockSettings.of(Material.BAMBOO).sounds(BlockSoundGroup.BAMBOO).strength(2.0F, 15F).build());
    public static final BlockBambooFenceWall BAMBOO_FENCE_WALL_BLOCK = new BlockBambooFenceWall(FabricBlockSettings.of(Material.BAMBOO).sounds(BlockSoundGroup.BAMBOO).strength(2.0F, 15F).build());

    public static void registerBlocks(){
        Registry.register(Registry.BLOCK, new Identifier(MODID, "bamboo_fence_gate"), BAMBOO_FENCE_GATE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "bamboo_fence"), BAMBOO_FENCE_BLOCK);
        Registry.register(Registry.BLOCK, new Identifier(MODID, "bamboo_fence_wall"), BAMBOO_FENCE_WALL_BLOCK);
    }
}