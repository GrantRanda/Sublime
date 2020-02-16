package gr.sublime.world.storage.loot;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class SublimeLootTables {

    public static final ResourceLocation CHESTS_GAZEBO_DROPPER = register("chests/gazebo_dropper");

    private static ResourceLocation register(String id) {
        return LootTableList.register(new ResourceLocation("sublime", id));
    }
}
