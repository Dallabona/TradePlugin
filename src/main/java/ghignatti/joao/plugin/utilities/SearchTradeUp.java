package ghignatti.joao.plugin.utilities;

import ghignatti.joao.plugin.array.ArrayTrade;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SearchTradeUp {
    private static SearchTradeUp ourInstance = new SearchTradeUp();

    public static SearchTradeUp getInstance() {
        return ourInstance;
    }

    private SearchTradeUp() {
    }

    private ArrayTrade arrayTrade = ArrayTrade.getInstance();
    private ForOnlinePlayer fp = ForOnlinePlayer.getOurInstance();

    private int i;

    public boolean searchArray(Player t) {

        for(i = arrayTrade.arrayList.size()-1; i>=0; i--) {

            Player target = fp.searchPlayer(arrayTrade.arrayList.get(i).getTarget());

            if(t.equals(target)) {

                if(arrayTrade.arrayList.get(i).getRequestTime() + 30000 >= System.currentTimeMillis()) {

                    if(arrayTrade.arrayList.get(i).getStatus()) {
                        Player s = ForOnlinePlayer.getOurInstance().searchPlayer(arrayTrade.arrayList.get(i).getSender());
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
                    arrayTrade.arrayList.get(i).setStatus(false);
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
