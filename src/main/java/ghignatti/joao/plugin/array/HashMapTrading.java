package ghignatti.joao.plugin.array;

import ghignatti.joao.plugin.action.Trading;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class HashMapTrading {
    private static HashMapTrading ourInstance = new HashMapTrading();

    public static HashMapTrading getInstance() {
        return ourInstance;
    }

    private HashMapTrading() {
    }

    public HashMap<Player, Trading> tradingHashMap = new HashMap<Player, Trading>();
}
