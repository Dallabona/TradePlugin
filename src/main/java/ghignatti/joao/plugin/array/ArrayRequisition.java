package ghignatti.joao.plugin.array;

import java.util.ArrayList;

public class ArrayRequisition {
    private static ArrayRequisition ourInstance = new ArrayRequisition();

    public static ArrayRequisition getInstance() {
        return ourInstance;
    }

    private ArrayRequisition() {
    }

    public ArrayList<TradeRequisition> requisitionArray = new ArrayList<TradeRequisition>();
}
