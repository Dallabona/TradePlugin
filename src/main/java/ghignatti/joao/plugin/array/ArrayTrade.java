package ghignatti.joao.plugin.array;

import java.util.ArrayList;

public class ArrayTrade {
    private static ArrayTrade ourInstance = new ArrayTrade();

    public static ArrayTrade getInstance() {
        return ourInstance;
    }

    private ArrayTrade() {
    }

    public ArrayList<TradeRequisition> arrayList = new ArrayList<TradeRequisition>();
}
