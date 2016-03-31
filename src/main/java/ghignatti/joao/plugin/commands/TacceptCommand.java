package ghignatti.joao.plugin.commands;

import ghignatti.joao.plugin.action.Trading;
import ghignatti.joao.plugin.array.ArrayTrade;
import ghignatti.joao.plugin.utilities.ForOnlinePlayer;
import ghignatti.joao.plugin.utilities.SearchTradeUp;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TacceptCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        ArrayTrade arrayTrade = ArrayTrade.getInstance();
        ForOnlinePlayer fp = ForOnlinePlayer.getOurInstance();

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Você precisa ser um player para aceitar uma solicitação de troca.");
            return false;
        }

        Player target = (Player) sender;

        boolean tradeUp = SearchTradeUp.getInstance().searchArray(target);

        if(tradeUp){

            int index = SearchTradeUp.getInstance().index();

            Player player = fp.searchPlayer(arrayTrade.arrayList.get(index).getSender());

            player.sendMessage(ChatColor.GREEN + target.getName() + " aceitou sua solicitação de troca.");
            target.sendMessage(ChatColor.GREEN + "Você aceitou a solicitação de troca de " + player.getName() + ".");

            Trading trading = new Trading(player, target);
            trading.setInventoryTrade();

        } else {
            return false;
        }

        return false;
    }
}