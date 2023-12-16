package de.louiletsplaypro.nohorn;

import de.louiletsplaypro.nohorn.commands.toggleHorns;
import de.louiletsplaypro.nohorn.commands.togglePotions;
import de.louiletsplaypro.nohorn.listener.inventoryHorn;
import de.louiletsplaypro.nohorn.listener.inventoryPotion;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Nohorn extends JavaPlugin {

    private static boolean activeHorns = false;
    private static boolean activePotions = false;

    @Override
    public void onEnable() {
        // Plugin startup logic

        registerCommand("toggleHorn", new toggleHorns());
        registerCommand("togglePotion", new togglePotions());

        getServer().getPluginManager().registerEvents(new inventoryHorn(), this);
        getServer().getPluginManager().registerEvents(new inventoryPotion(), this);

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
