package StatePattern;

import Service.VendingMachine;

public class IdleState implements State {

    @Override
    public void insertMoney(VendingMachine machine, double amount) {
        machine.addBalance(amount);
        System.out.println("Money inserted: $" + amount);
        machine.setState(machine.getHasMoneyState());
    }

    @Override
    public void selectProduct(VendingMachine machine, String code) {
        System.out.println("Please insert money first!");
    }

    @Override
    public void dispense(VendingMachine machine) {
        System.out.println("No product selected or paid for.");
    }

    @Override
    public void refund(VendingMachine machine) {
        System.out.println("No money to refund.");
    }
}
