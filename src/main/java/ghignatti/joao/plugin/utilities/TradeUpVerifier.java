package ghignatti.joao.plugin.utilities;

import ghignatti.joao.plugin.array.ArrayRequisition;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class TradeUpVerifier {
    private static TradeUpVerifier ourInstance = new TradeUpVerifier();

    public static TradeUpVerifier getInstance() {
        return ourInstance;
    }

    private TradeUpVerifier() {
    }

    private ArrayRequisition arrayRequisition = ArrayRequisition.getInstance();

    private int i;

    public boolean searchArray(Player t) {

        for(i = arrayRequisition.requisitionArray.size()-1; i>=0; i--) {

            Player target = Bukkit.getPlayer(arrayRequisition.requisitionArray.get(i).getTarget());

            if(t.equals(target)) {

                if(arrayRequisition.requisitionArray.get(i).getRequestTime() + 30000 >= System.currentTimeMillis()) {

                    if(arrayRequisition.requisitionArray.get(i).getStatus()) {
                        Player s = Bukkit.getPlayer(arrayRequisition.requisitionArray.get(i).getSender());
                        if(s == null) {
                            t.sendMessage(ChatColor.RED + "O player que solicitou a troca não está mais online.");
                            return false;
                        }
                        else {
                            return true;
                        }
                    } else {
                        t.sendMessage(ChatColor.RED + "O tempo de aceitar solicitação expirou.");
                        return false;
                    }
                } else {
                    t.sendMessage(ChatColor.RED + "O tempo de aceitar solicitação expirou.");
                    arrayRequisition.requisitionArray.get(i).setStatus(false);
                    return false;
                }
            }
        }

        t.sendMessage(ChatColor.RED + "Você não foi solicitado a fazer uma troca.");
        return false;
    }

    public int index() {
        return i;
    }
}
