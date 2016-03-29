package ghignatti.joao.plugin.commands;

import ghignatti.joao.plugin.array.SetArray;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class TacceptCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {

        Player player = null;

        if(!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "Você precisa ser um player para aceitar uma solicitação de troca.");
            return false;
        }

        SetArray setArray = SetArray.getInstance();

        Player targetAux = setArray.arrayList.get(setArray.arrayList.size()-1).getTarget();

        if(!(sender.equals(targetAux))) {
            sender.sendMessage(ChatColor.RED + "Você não foi solicitado a fazer nenhuma troca.");
            return false;
        }

        Player target = (Player) sender;

        Player playerAux = setArray.arrayList.get(setArray.arrayList.size()-1).getSender();

        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.equals(playerAux)) {
                player = p;
                break;
            }
        }

        if(player == null) {
            target.sendMessage(ChatColor.RED + "O player que solicitou a troca não está mais online.");
            return false;
        }

        player.sendMessage(ChatColor.GREEN + target.getName() + " aceitou sua solicitação de troca.");
        target.sendMessage(ChatColor.GREEN + "Você aceitou a solicitação de troca de " + player.getName() + ".");

        return true;
    }
}