package ghignatti.joao.plugin.array;

import org.bukkit.entity.Player;

public class TradeRequisition {

    private Player sender;
    private Player target;

    public void setSender(Player player) {
        this.sender = player;
    }

    public Player getSender() {
        return sender;
    }

    public void setTarget(Player player) {
        this.target = player;
    }

    public Player getTarget() {
        return target;
    }

    public TradeRequisition(Player sender, Player target) {
        setSender(sender);
        setTarget(target);
    }
}
