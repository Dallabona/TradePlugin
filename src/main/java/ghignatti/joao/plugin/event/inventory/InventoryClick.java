package ghignatti.joao.plugin.event.inventory;

import ghignatti.joao.plugin.action.Trading;
import ghignatti.joao.plugin.inventory.InventoryTrade;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryCLick(InventoryClickEvent event) {

        Trading trading = new Trading();

        Player s = trading.getPlayer();
        Player t = trading.getTarget();

        if(event.getInventory().equals(s.getInventory()) ||
                event.getInventory().equals(t.getInventory())) {

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
