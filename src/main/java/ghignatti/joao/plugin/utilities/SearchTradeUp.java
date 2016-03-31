package ghignatti.joao.plugin.utilities;

import ghignatti.joao.plugin.array.ArrayRequisition;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SearchTradeUp {
    private static SearchTradeUp ourInstance = new SearchTradeUp();

    public static SearchTradeUp getInstance() {
        return ourInstance;
    }

    private SearchTradeUp() {
    }

    private ArrayRequisition arrayRequisition = ArrayRequisition.getInstance();
    private ForOnlinePlayer fp = ForOnlinePlayer.getOurInstance();

    private int i;

    public boolean searchArray(Player t) {

        for(i = arrayRequisition.requisitionArray.size()-1; i>=0; i--) {

            Player target = fp.searchPlayer(arrayRequisition.requisitionArray.get(i).getTarget());

            if(t.equals(target)) {

                if(arrayRequisition.requisitionArray.get(i).getRequestTime() + 30000 >= System.currentTimeMillis()) {

                    if(arrayRequisition.requisitionArray.get(i).getStatus()) {
                        Player s = ForOnlinePlayer.getOurInstance().searchPlayer(arrayRequisition.requisitionArray.get(i).getSender());
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
