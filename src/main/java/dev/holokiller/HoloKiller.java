package dev.holokiller;

import org.bukkit.Bukkit;
import org.bukkit.command.*;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.plugin.java.JavaPlugin;

public class HoloKiller extends JavaPlugin {

    @Override
    public void onEnable() {
        getCommand("holokill").setExecutor((sender, cmd, label, args) -> {
            int count = 0;
            for (org.bukkit.World world : Bukkit.getWorlds()) {
                for (Entity e : world.getEntities()) {
                    if (e instanceof ArmorStand stand && stand.isInvisible()) {
                        stand.remove();
                        count++;
                    }
                }
            }
            sender.sendMessage("Removed " + count + " invisible ArmorStand(s).");
            return true;
        });
        getLogger().info("HoloKiller ready. Run /holokill to remove all invisible ArmorStands.");
    }
}
