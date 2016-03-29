package ghignatti.joao.plugin.inventory;

import ghignatti.joao.plugin.array.SetArray;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class SetInventory {

    private SetArray setArray = SetArray.getInstance();

    private Player sender = setArray.arrayList.get(setArray.arrayList.size()-1).getSender();
    private Player target = setArray.arrayList.get(setArray.arrayList.size()-1).getTarget();

    private Inventory setSenderInventory() {

        Inventory inv = Bukkit.createInventory(null, 36, "Troca " + sender.getName() + "/" + target.getName());

        ItemStack botaoVerde = nameItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "Aceitar");
        ItemStack botaoVermelho = nameItem(Material.REDSTONE_BLOCK, ChatColor.RED + "Recusar");
        ItemStack botaoOutro = nameItem(Material.STONE, ChatColor.BLUE + target.getName() + " escolha");

        ItemStack barreira = nameItem(Material.IRON_FENCE, "");

        inv.setItem(4, barreira);
        inv.setItem(13, barreira);
        inv.setItem(22, barreira);
        inv.setItem(31, barreira);

        inv.setItem(29, botaoVerde);
        inv.setItem(30, botaoVermelho);

        inv.setItem(32, botaoOutro);

        return inv;
    }

    private Inventory setTargetInventory() {

        Inventory inv = Bukkit.createInventory(null, 36, "Troca " + sender.getName() + "/" + target.getName());

        ItemStack botaoVerde = nameItem(Material.EMERALD_BLOCK, ChatColor.GREEN + "Aceitar");
        ItemStack botaoVermelho = nameItem(Material.REDSTONE_BLOCK, ChatColor.RED + "Recusar");
        ItemStack botaoOutro = nameItem(Material.STONE, ChatColor.GREEN + sender.getName() + " escolha");

        ItemStack barreira = nameItem(Material.IRON_FENCE, "");

        inv.setItem(4, barreira);
        inv.setItem(13, barreira);
        inv.setItem(22, barreira);
        inv.setItem(31, barreira);

        inv.setItem(33, botaoVerde);
        inv.setItem(32, botaoVermelho);

        inv.setItem(30, botaoOutro);

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
