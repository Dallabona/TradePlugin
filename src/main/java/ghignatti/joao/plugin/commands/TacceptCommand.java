package ghignatti.joao.plugin.commands;

import ghignatti.joao.plugin.array.ArrayTrade;

import ghignatti.joao.plugin.inventory.InventoryTrade;
import ghignatti.joao.plugin.utilities.ForPlayer;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class TacceptCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player;

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Você precisa ser um player para aceitar uma solicitação de troca.");
            return false;
        }

        ArrayTrade arrayTrade = ArrayTrade.getInstance();

        ForPlayer fp = ForPlayer.getOurInstance();

        String targetName = arrayTrade.arrayList.get(arrayTrade.arrayList.size()-1).getTarget();

        if(!(sender.equals(fp.searchPlayer(targetName)))) {
            sender.sendMessage(ChatColor.RED + "Você não foi solicitado a fazer nenhuma troca.");
            return false;
        }

        Player target = (Player) sender;

        player = fp.searchPlayer(arrayTrade.arrayList.get(arrayTrade.arrayList.size()-1).getSender());

        if(player == null) {
            target.sendMessage(ChatColor.RED + "O player que solicitou a troca não está mais online.");
            return false;
        }

        player.sendMessage(ChatColor.GREEN + target.getName() + " aceitou sua solicitação de troca.");
        target.sendMessage(ChatColor.GREEN + "Você aceitou a solicitação de troca de " + player.getName() + ".");
        // Trading
        InventoryTrade inventoryTrade = new InventoryTrade();
        Inventory senderInv = inventoryTrade.getSenderInventory();
        Inventory targetInv = inventoryTrade.getTargetInventory();

        player.openInventory(senderInv);
        target.openInventory(targetInv);

        return true;
    }
}