package ghignatti.joao.plugin.utilities;

import ghignatti.joao.plugin.array.HashMapTrading;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;

public class PermissionToClickVerifier {
    private static PermissionToClickVerifier ourInstance = new PermissionToClickVerifier();

    public static PermissionToClickVerifier getInstance() {
        return ourInstance;
    }

    private PermissionToClickVerifier() {
    }

    private boolean cancelVerifier(InventoryClickEvent event) {

        HashMapTrading hmt = HashMapTrading.getInstance();

        Player s = hmt.tradingHashMap.get(event.getWhoClicked()).getPlayer();
        Player t = hmt.tradingHashMap.get(event.getWhoClicked()).getTarget();

        if(event.getWhoClicked().equals(s)) {

            if(!(event.getInventory().equals(s.getInventory()))) {

                if(event.getCurrentItem().getType() == Material.EMERALD_BLOCK) {

                    if(event.getSlot() == 29) {
                        return true;
                    }
                } else if(event.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {

                    if(event.getSlot() == 30) {
                        return true;
                    }
                } else if(event.getCurrentItem().getType() == Material.STONE) {

                    if(event.getSlot() == 32) {
                        return true;
                    }
                } else if(event.getCurrentItem().getType() == Material.IRON_FENCE) {

                    if(event.getSlot() == 4 || event.getSlot() == 13 ||
                            event.getSlot() == 22 || event.getSlot() == 31) {
                        return true;
                    }
                }
            }
        } else if(event.getWhoClicked().equals(t)) {

            if(!(event.getInventory().equals(t.getInventory()))) {

                if(event.getCurrentItem().getType() == Material.EMERALD_BLOCK) {

                    if(event.getSlot() == 33) {
                        return true;
                    }
                } else if(event.getCurrentItem().getType() == Material.REDSTONE_BLOCK) {

                    if(event.getSlot() == 32) {
                        return true;
                    }
                } else if(event.getCurrentItem().getType() == Material.STONE) {

                    if(event.getSlot() == 30) {
                        return true;
                    }
                } else if(event.getCurrentItem().getType() == Material.IRON_FENCE) {

                    if(event.getSlot() == 4 || event.getSlot() == 13 ||
                            event.getSlot() == 22 || event.getSlot() == 31) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public boolean getCancelVerifier(InventoryClickEvent event) {
        return cancelVerifier(event);
    }
}
