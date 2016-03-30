package ghignatti.joao.plugin.array;

import org.bukkit.entity.Player;

public class TradeRequisition {

    private String sender;
    private String target;

    private boolean status;

    private long requestTime;

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

    private void setStatus(boolean status) {
        this.status = status;
    }

    public boolean getStatus() {
        return status;
    }

    private void setRequestTime() {
        this.requestTime = System.currentTimeMillis();
    }

    public long getRequestTime() {
        return requestTime;
    }

    public TradeRequisition(Player sender, Player target) {
        setSender(sender);
        setTarget(target);
    }
}
