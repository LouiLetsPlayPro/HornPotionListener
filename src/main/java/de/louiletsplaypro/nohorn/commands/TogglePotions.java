package de.louiletsplaypro.nohorn.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import static de.louiletsplaypro.nohorn.Nohorn.*;

public class TogglePotions implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command cmd, @NotNull String s, @NotNull String[] strings) {
        // Schalte die Variable um
        setActivePotions(!isActivePotions());

        // Gib eine Nachricht aus
        sender.sendMessage("Variable wurde umgeschaltet. Aktueller Status: " + isActivePotions());
        return true;
    }

}
