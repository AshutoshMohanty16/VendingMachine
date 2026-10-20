package StatePattern;

import Service.VendingMachine;
import model.Item;

public class DispensingState implements State{

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        System.out.println("Please wait, dispensing in progress...");
    }

    @Override
    public void selectProduct(VendingMachine machine, String code) {
        System.out.println("Please wait, dispensing in progress...");
    }

    @Override
    public void dispense(VendingMachine machine) {
        String code = machine.getSelectedProductCode();
        Item item = machine.getInventory().getItem(code);

        // Deduct stock and calculate change
        machine.getInventory().deductStock(code);
        double change = machine.getBalance() - item.getPrice();

        System.out.println("Dispensing product: " + item.getName());
        if (change > 0) {
            System.out.println("Returning change: $" + change);
        }

        // Reset machine state back to Idle
        machine.resetBalance();
        machine.setSelectedProductCode(null);
        machine.setState(machine.getIdleState());
        System.out.println("Transaction complete. Machine is now IDLE.\n");
    }

    @Override
    public void refund(VendingMachine machine) {
        System.out.println("Cannot refund while dispensing.");
    }
}
