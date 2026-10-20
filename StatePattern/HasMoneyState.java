package StatePattern;

import Service.VendingMachine;
import model.Item;

public class HasMoneyState implements State{

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.addBalance(amount);
        System.out.println("Additional money inserted: $" + amount + ". Total Balance: $" + machine.getBalance());
    }

    @Override
    public void selectProduct(VendingMachine machine, String code) {
        if (!machine.getInventory().isAvailable(code)) {
            System.out.println("Item " + code + " is Sold Out.");
            return;
        }

        Item item = machine.getInventory().getItem(code);
        if (machine.getBalance() < item.getPrice()) {
            System.out.println("Insufficient funds. Item costs $" + item.getPrice() + ", but you inserted $" + machine.getBalance());
            return;
        }

        System.out.println("Product " + item.getName() + " selected successfully.");
        machine.setSelectedProductCode(code);
        machine.setState(machine.getDispensingState());
        machine.getState().dispense(machine);
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("Please select a product first.");
    }

    @Override
    public void refund(VendingMachine machine) {
        double refundAmount = machine.getBalance();
        machine.resetBalance();
        machine.setState(machine.getIdleState());
        System.out.println("Transaction cancelled. Refunding $" + refundAmount);
    }
}
