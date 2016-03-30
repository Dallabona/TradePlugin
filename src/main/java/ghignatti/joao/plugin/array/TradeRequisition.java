package ghignatti.joao.plugin.array;

import org.bukkit.entity.Player;

public class TradeRequisition {

    private String sender;
    private String target;

    private void setSender(Player player) {
        this.sender = player.getName();
    }

    public String getSender() {
        return sender;
    }

    private void setTarget(Player player) {
        this.target = player.getName();
    }

    public String getTarget() {
        return target;
    }

    public TradeRequisition(Player sender, Player target) {
        setSender(sender);
        setTarget(target);
    }
}
