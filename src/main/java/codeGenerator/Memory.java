package codeGenerator;

import java.util.ArrayList;

/**
 * Created by mohammad hosein on 6/27/2015.
 */
public class Memory {
    private final ArrayList<AddressCodeBag> codeBlock;
    private int lastTempIndex;
    private int lastDataAddress;
    private static final int START_TEMP_MEMORY_ADDRESS = 500;
    private static final int START_DATA_MEMORY_ADDRESS = 200;
    private static final int DATA_SIZE = 4;
    private static final int TEMP_SIZE = 4;

    public Memory() {
        codeBlock = new ArrayList<>();
        lastTempIndex = START_TEMP_MEMORY_ADDRESS;
        lastDataAddress = START_DATA_MEMORY_ADDRESS;
    }

    public int getTemp() {
        lastTempIndex += TEMP_SIZE;
        return lastTempIndex - TEMP_SIZE;
    }

    public int getDateAddress() {
        lastDataAddress += DATA_SIZE;
        return lastDataAddress - DATA_SIZE;
    }

    public int saveMemory() {
        codeBlock.add(new AddressCodeBag());
        return codeBlock.size() - 1;
    }

    public void addAddressCodeBag(Operation op, Address opr1, Address opr2, Address opr3) {
        codeBlock.add(new AddressCodeBag(op, opr1, opr2, opr3));
    }

    public void addAddressCodeBag(int i, Operation op, Address opr1, Address opr2, Address opr3) {
        codeBlock.remove(i);
        codeBlock.add(i, new AddressCodeBag(op, opr1, opr2, opr3));
    }


    public int getCurrentCodeBlockAddress() {
        return codeBlock.size();
    }

    public void pintCodeBlock() {
        System.out.println("Code Block");
        for (int i = 0; i < codeBlock.size(); i++) {
            System.out.println(i + " : " + codeBlock.get(i).toString());
        }
    }
}

class AddressCodeBag {
    public Operation operation;
    public Address Operand1;
    public Address Operand2;
    public Address Operand3;

    public AddressCodeBag() {

    }

    public AddressCodeBag(Operation op, Address opr1, Address opr2, Address opr3) {
        operation = op;
        Operand1 = opr1;
        Operand2 = opr2;
        Operand3 = opr3;
    }

    public String toString() {
        if (operation == null) {
            return "";
        }
        StringBuilder res = new StringBuilder("(");
        res.append(operation).append(",");
        if (Operand1 != null) {
            res.append(Operand1);
        }
        res.append(",");
        if (Operand2 != null) {
            res.append(Operand2);
        }
        res.append(",");
        if (Operand3 != null) {
            res.append(Operand3);
        }
        res.append(")");

        return res.toString();
    }
}
