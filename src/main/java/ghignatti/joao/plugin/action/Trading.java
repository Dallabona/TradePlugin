package ghignatti.joao.plugin.action;

import ghignatti.joao.plugin.inventory.InventoryTrade;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Trading {

    private Player player;
    private Player target;

    public Trading(Player player, Player target) {
        this.player = player;
        this.target = target;
    }

    public void setInventoryTrade() {

        InventoryTrade inventoryTrade = new InventoryTrade();
        Inventory senderInv = inventoryTrade.getSenderInventory();
        Inventory targetInv = inventoryTrade.getTargetInventory();

        player.openInventory(senderInv);
        target.openInventory(targetInv);
    }
}
