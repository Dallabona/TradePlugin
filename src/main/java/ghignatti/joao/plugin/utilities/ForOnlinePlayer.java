package ghignatti.joao.plugin.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ForOnlinePlayer {

    private static ForOnlinePlayer ourInstance = new ForOnlinePlayer();

    public static ForOnlinePlayer getOurInstance() {
        return ourInstance;
    }

    private ForOnlinePlayer() {
    }

    public Player searchPlayer(String namePlayer) {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getName().equals(namePlayer)) {
                return p;
            }
        }
        return null;
    }
}
