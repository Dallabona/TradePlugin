package ghignatti.joao.plugin.commands;

import ghignatti.joao.plugin.array.ArrayTrade;
import ghignatti.joao.plugin.array.TradeRequisition;

import ghignatti.joao.plugin.utilities.ForOnlinePlayer;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TradeCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cnd, String commandLabel, String[] args) {

        Player target;

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Você precisa ser um player para chamar este comando.");
            return false;
        }

        Player player = (Player) sender;

        if (args.length == 0) {
            player.sendMessage(ChatColor.RED + "Você precisa informar o player a fazer a troca.");
            return false;
        }

        ForOnlinePlayer fp = ForOnlinePlayer.getOurInstance();
        target = fp.searchPlayer(args[0]);

        if (target == null) {
            player.sendMessage(ChatColor.RED + "Player não encontrado. Somente players online podem fazer troca.");
            return false;
        } else if (target.equals(player)) {
            player.sendMessage(ChatColor.RED + "Você não pode trocar com você mesmo.");
            return false;
        }

        player.sendMessage(ChatColor.AQUA + "Você solicitou troca com " + target.getName() + ".");

        target.sendMessage(ChatColor.AQUA + player.getName() + " deseja trocar itens com você.");
        target.sendMessage(ChatColor.AQUA + "Digite " + ChatColor.DARK_AQUA + "/taccept" +
                ChatColor.AQUA + " para aceitar e " + ChatColor.DARK_AQUA + "/tdecline" +
                ChatColor.AQUA + " para declinar oferta.");

        ArrayTrade arrayTrade = ArrayTrade.getInstance();

        arrayTrade.arrayList.add(new TradeRequisition(player, target, true));

        return true;
    }
}