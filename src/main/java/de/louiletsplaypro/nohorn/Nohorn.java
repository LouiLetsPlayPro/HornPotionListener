package de.louiletsplaypro.nohorn;

import de.louiletsplaypro.nohorn.commands.ToggleHorns;
import de.louiletsplaypro.nohorn.commands.TogglePotions;
import de.louiletsplaypro.nohorn.listener.InventoryHorn;
import de.louiletsplaypro.nohorn.listener.InventoryPotion;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Nohorn extends JavaPlugin {

    private static boolean activeHorns = false;
    private static boolean activePotions = false;

    @Override
    public void onEnable() {
        // Plugin startup logic

        registerCommand("toggleHorn", new ToggleHorns());
        registerCommand("togglePotion", new TogglePotions());

        getServer().getPluginManager().registerEvents(new InventoryHorn(), this);
        getServer().getPluginManager().registerEvents(new InventoryPotion(), this);

    }

    public static boolean isActiveHorns() {
        return activeHorns;
    }

    public static void setActiveHorns(boolean activeHorns) {
        Nohorn.activeHorns = activeHorns;
    }

    public static boolean isActivePotions() {
        return activePotions;
    }

    public static void setActivePotions(boolean activePotions) {
        Nohorn.activePotions = activePotions;
    }

    public void registerCommand(String name, CommandExecutor executor){
        PluginCommand command = getCommand(name);
        assert command != null;
        command.setExecutor(executor);
    }
}
