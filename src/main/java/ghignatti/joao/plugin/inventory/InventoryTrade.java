package ghignatti.joao.plugin.inventory;

import ghignatti.joao.plugin.array.ArrayTrade;
import ghignatti.joao.plugin.utilities.ForOnlinePlayer;
import ghignatti.joao.plugin.utilities.SearchTradeUp;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class InventoryTrade {

    private ArrayTrade arrayTrade = ArrayTrade.getInstance();

    private String senderName = arrayTrade.arrayList.get(SearchTradeUp.getInstance().index()).getSender();
    private String targetName = arrayTrade.arrayList.get(SearchTradeUp.getInstance().index()).getTarget();

    private ForOnlinePlayer fp = ForOnlinePlayer.getOurInstance();

    private Player sender = fp.searchPlayer(senderName);
    private Player target = fp.searchPlayer(targetName);

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
        ItemStack botaoPedra = nameItem(Material.STONE, ChatColor.GREEN + sender.getName() + " escolha");

        ItemStack barreira = nameItem(Material.IRON_FENCE, "");

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
