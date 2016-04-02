package ghignatti.joao.plugin.commands;

import ghignatti.joao.plugin.action.InstructionsOfTrading;
import ghignatti.joao.plugin.array.ArrayRequisition;
import ghignatti.joao.plugin.array.HashMapTrading;
import ghignatti.joao.plugin.utilities.TradeUpVerifier;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TacceptCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        ArrayRequisition arrayRequisition = ArrayRequisition.getInstance();

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Você precisa ser um player para aceitar uma solicitação de troca.");
            return false;
        }

        Player target = (Player) sender;

        boolean tradeUp = TradeUpVerifier.getInstance().searchArray(target);

        if(tradeUp){

            int index = TradeUpVerifier.getInstance().index();

            Player player = Bukkit.getPlayer(arrayRequisition.requisitionArray.get(index).getSender());

            player.sendMessage(ChatColor.GREEN + target.getName() + " aceitou sua solicitação de troca.");
            target.sendMessage(ChatColor.GREEN + "Você aceitou a solicitação de troca de " + player.getName() + ".");

            InstructionsOfTrading instructionsOfTrading = new InstructionsOfTrading(player, target);
            HashMapTrading.getInstance().tradingHashMap.put(player, instructionsOfTrading);
            HashMapTrading.getInstance().tradingHashMap.put(target, instructionsOfTrading);

            instructionsOfTrading.setInventoryTrade();

        } else {
            return false;
        }

        return false;
    }
}