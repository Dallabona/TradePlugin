package ghignatti.joao.plugin.inventory;

import ghignatti.joao.plugin.array.ArrayRequisition;
import ghignatti.joao.plugin.utilities.TradeUpVerifier;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryTradeSetter {

    private ArrayRequisition arrayRequisition = ArrayRequisition.getInstance();

    private String senderName = arrayRequisition.requisitionArray.get(TradeUpVerifier.getInstance().index()).getSender();
    private String targetName = arrayRequisition.requisitionArray.get(TradeUpVerifier.getInstance().index()).getTarget();

    private Player sender = Bukkit.getPlayer(senderName);
    private Player target = Bukkit.getPlayer(targetName);

    private Inventory setSenderInventory() {

        Inventory inv = Bukkit.createInventory(null, 36, "Troca " + sender.getName() + "/" + target.getName());

        ItemStack botaoVerde = nameItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "Aceitar");
        ItemStack botaoVermelho = nameItem(Material.REDSTONE_BLOCK, ChatColor.RED + "Recusar");
        ItemStack botaoPedra = nameItem(Material.STONE, ChatColor.BLUE + target.getName() + " escolha");

        ItemStack barreira = nameItem(Material.IRON_FENCE, "");

        inv.setItem(4, barreira);
        inv.setItem(13, barreira);
        inv.setItem(22, barreira);
        inv.setItem(31, barreira);

        inv.setItem(29, botaoVerde);
        inv.setItem(30, botaoVermelho);

        inv.setItem(32, botaoPedra);

        return inv;
    }

    private Inventory setTargetInventory() {

        Inventory inv = Bukkit.createInventory(null, 36, "Troca " + sender.getName() + "/" + target.getName());

        ItemStack botaoVerde = nameItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "Aceitar");
        ItemStack botaoVermelho = nameItem(Material.REDSTONE_BLOCK, ChatColor.RED + "Recusar");
        ItemStack botaoPedra = nameItem(Material.STONE, ChatColor.BLUE + sender.getName() + " escolha");

        ItemStack barreira = nameItem(Material.IRON_FENCE, "Barreira");

        inv.setItem(4, barreira);
        inv.setItem(13, barreira);
        inv.setItem(22, barreira);
        inv.setItem(31, barreira);

        inv.setItem(33, botaoVerde);
        inv.setItem(32, botaoVermelho);

        inv.setItem(30, botaoPedra);

        return inv;
    }

    public Inventory getSenderInventory() {
        return setSenderInventory();
    }

    public Inventory getTargetInventory() {
        return setTargetInventory();
    }

    private ItemStack nameItem(Material item, String name) {
        return nameItem(new ItemStack(item), name);
    }

    private ItemStack nameItem(ItemStack item, String name) {
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(name);
        item.setItemMeta(meta);

        return item;
    }
}
