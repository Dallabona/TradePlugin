package ghignatti.joao.plugin.action;

import ghignatti.joao.plugin.inventory.InventoryTradeSetter;

import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class InstructionsOfTrading {

    private Player player;
    private Player target;

    public InstructionsOfTrading(Player player, Player target) {
        this.player = player;
        this.target = target;
    }

    public void setInventoryTrade() {

        InventoryTradeSetter inventoryTradeSetter = new InventoryTradeSetter();
        Inventory senderInv = inventoryTradeSetter.getSenderInventory();
        Inventory targetInv = inventoryTradeSetter.getTargetInventory();

        player.openInventory(senderInv);
        target.openInventory(targetInv);
    }

    public Player getPlayer() {
        return player;
    }

    public Player getTarget() {
        return target;
    }
}
