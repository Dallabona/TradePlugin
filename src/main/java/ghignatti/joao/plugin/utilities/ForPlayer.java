package ghignatti.joao.plugin.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class ForPlayer {

    private static ForPlayer ourInstance = new ForPlayer();

    public static ForPlayer getOurInstance() {
        return ourInstance;
    }

    private ForPlayer() {

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
