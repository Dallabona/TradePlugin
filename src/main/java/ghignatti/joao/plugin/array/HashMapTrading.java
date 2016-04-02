package ghignatti.joao.plugin.array;

import ghignatti.joao.plugin.action.InstructionsOfTrading;

import org.bukkit.entity.Player;

import java.util.HashMap;

public class HashMapTrading {
    private static HashMapTrading ourInstance = new HashMapTrading();

    public static HashMapTrading getInstance() {
        return ourInstance;
    }

    private HashMapTrading() {
    }

    public HashMap<Player, InstructionsOfTrading> tradingHashMap = new HashMap<Player, InstructionsOfTrading>();
}
