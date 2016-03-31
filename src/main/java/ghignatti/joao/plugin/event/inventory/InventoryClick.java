package ghignatti.joao.plugin.event.inventory;

import ghignatti.joao.plugin.inventory.InventoryTrade;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    private InventoryTrade inventoryTrade = new InventoryTrade();

    @EventHandler
    public void onInventoryCLick(InventoryClickEvent event) {

        if(event.getInventory().equals(inventoryTrade.getSenderInventory()) ||
                event.getInventory().equals(inventoryTrade.getTargetInventory())) {

            ItemStack eb = new ItemStack(Material.EMERALD_BLOCK);
            ItemStack rb = new ItemStack(Material.REDSTONE_BLOCK);
            ItemStack ifn = new ItemStack(Material.IRON_FENCE);
            ItemStack st = new ItemStack(Material.STONE);

            ItemStack ci = event.getCurrentItem();

            if(ci.equals(eb) || ci.equals(rb) || ci.equals(ifn) || ci.equals(st)) {
                event.setCancelled(true);
            }
        }
    }
}
