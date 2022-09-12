package inventoryinterception.inventoryinterception;

import org.bukkit.plugin.java.JavaPlugin;

public final class InventoryInterception extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("interception").setExecutor(new Interception());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
