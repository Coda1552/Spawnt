package codyhuh.spawnt;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;

@Mod(Spawnt.MOD_ID)
public class Spawnt {
    public static final String MOD_ID = "spawnt";

    public Spawnt() {
        IEventBus bus = MinecraftForge.EVENT_BUS;

        bus.addListener(this::removeSpawnEggUsage);
    }

    private void removeSpawnEggUsage(PlayerInteractEvent.RightClickBlock e) {
        BlockHitResult result = e.getHitVec();
        Player player = e.getEntity();
        ItemStack stack = player.getItemInHand(e.getHand());

        if (!player.isCreative() && stack.getItem() instanceof SpawnEggItem && player.level().getBlockState(result.getBlockPos()).is(Blocks.SPAWNER)) {
            e.setCanceled(true);
        }
    }
}
