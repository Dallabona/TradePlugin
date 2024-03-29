package ghignatti.joao.plugin.event.inventory;

import ghignatti.joao.plugin.utilities.PermissionToClickVerifier;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClick implements Listener {

    @EventHandler
    public void onInventoryCLick(InventoryClickEvent event) {

        boolean cancel = PermissionToClickVerifier.getInstance().getCancelVerifier(event);

        if(cancel) {
            event.setCancelled(true);
        }
    }
}
