package de.louiletsplaypro.nohorn.listener;

import de.louiletsplaypro.nohorn.Nohorn;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCreativeEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class InventoryHorn implements Listener{

    @EventHandler(ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        ItemStack item = event.getItem();

        // Überprüfe, ob der Spieler ein Horn benutzen will
        if (item != null && item.getType().equals(Material.GOAT_HORN) && !Nohorn.isActiveHorns()) {
            // Die Variable ist false, verhindere das Benutzen des Horns
            event.setCancelled(true);
        }
    }

    @EventHandler(ignoreCancelled = true)
    public void onInventoryClick(InventoryClickEvent event) {

        if (event.getWhoClicked() instanceof Player) {
            Inventory clickedInventory = event.getClickedInventory();
            ItemStack clickedItem = event.getCurrentItem();

            // Überprüfe, ob ein Trank aus dem kreativen Inventar genommen werden soll
            if (clickedInventory != null && clickedInventory.getType() == InventoryType.CREATIVE && clickedItem != null && clickedItem.getType() == Material.GOAT_HORN && !Nohorn.isActiveHorns()) {
                // Die Variable ist false, verhindere das Nehmen des Tranks
                event.setCancelled(true);
            }
        }

    }

    @EventHandler
    public void onInventoryCreative(InventoryCreativeEvent event) {
        if ((event.getWhoClicked() instanceof Player) && event.getCursor().getType() == Material.GOAT_HORN && !Nohorn.isActiveHorns()) {
            // Die Variable ist false, verhindere das Nehmen des Tranks
            event.setCancelled(true);
        }
    }

}
