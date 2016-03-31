package ghignatti.joao.plugin.event.inventory;

import ghignatti.joao.plugin.array.HashMapTrading;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryCLick(InventoryClickEvent event) {

        HashMapTrading hmt = HashMapTrading.getInstance();

        Player s = hmt.tradingHashMap.get(event.getWhoClicked()).getPlayer();
        Player t = hmt.tradingHashMap.get(event.getWhoClicked()).getTarget();

        if(!(event.getInventory().equals(s.getInventory()) ||
                event.getInventory().equals(t.getInventory()))) {

            event.getWhoClicked().sendMessage("LLLLLL");

            String ci = event.getCurrentItem().getItemMeta().getDisplayName();

            if (ci.equals("Aceitar") && event.getCurrentItem().getType().equals(Material.EMERALD_BLOCK)) {
                event.setCancelled(true);
            }
        }
    }
}
