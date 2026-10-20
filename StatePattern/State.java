package StatePattern;

import Service.VendingMachine;

public interface State {
    void insertMoney(VendingMachine machine, double amount);
    void selectProduct(VendingMachine machine, String code);
    void dispense(VendingMachine machine);
    void refund(VendingMachine machine);
}
