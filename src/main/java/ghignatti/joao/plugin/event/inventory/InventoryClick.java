package ghignatti.joao.plugin.event.inventory;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryCLick(InventoryClickEvent event) {

        if(event.getCurrentItem().equals(Material.EMERALD_BLOCK)) {

            if(verifySlots(event)) {

            }
        }
    }

    private boolean verifySlots(InventoryClickEvent event) {

        Inventory inv = event.getInventory();

        if(inv.contains(Material.EMERALD_BLOCK, 29)) {
            if(inv.getItem(0) == null &&
                    inv.getItem(1) == null &&
                    inv.getItem(2) == null &&
                    inv.getItem(3) == null &&
                    inv.getItem(9) == null &&
                    inv.getItem(10) == null &&
                    inv.getItem(11) == null &&
                    inv.getItem(12) == null &&
                    inv.getItem(13) == null &&
                    inv.getItem(18) == null &&
                    inv.getItem(19) == null &&
                    inv.getItem(20) == null &&
                    inv.getItem(21) == null &&
                    inv.getItem(27) == null &&
                    inv.getItem(28) == null) {
                return false;
            }
        }
        return false;
    }
}
