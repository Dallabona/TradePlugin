package ghignatti.joao.plugin.event.inventory;

import ghignatti.joao.plugin.array.HashMapTrading;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryCLick(InventoryClickEvent event) {

        HashMapTrading hmt = HashMapTrading.getInstance();

        Player s = hmt.tradingHashMap.get(event.getWhoClicked()).getPlayer();
        Player t = hmt.tradingHashMap.get(event.getWhoClicked()).getTarget();

        if(!(event.getInventory().equals(s.getInventory()) ||
                event.getInventory().equals(t.getInventory()))) {

            if(((event.getCurrentItem().getType() == Material.EMERALD_BLOCK) &&
                    event.getCurrentItem().getType().getData().getName().equals("Aceitar"))) {
                event.setCancelled(true);
            }
        }
    }
}
