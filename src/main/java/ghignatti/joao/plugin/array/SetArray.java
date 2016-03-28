package ghignatti.joao.plugin.array;

import java.util.ArrayList;

public class SetArray {
    private static SetArray ourInstance = new SetArray();

    public static SetArray getInstance() {
        return ourInstance;
    }

    private SetArray() {
    }

    public ArrayList<TradeRequisition> arrayList;
}
