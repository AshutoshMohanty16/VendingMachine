import Service.VendingMachine;
import model.Item;

public class Main {
    public static void main(String[] args) {
        VendingMachine machine = new VendingMachine();

        // 1. Stock the Vending Machine
        machine.getInventory().addItem(new Item("A1", "Coke", 1.50), 2);
        machine.getInventory().addItem(new Item("A2", "Chips", 1.00), 1);

        // Scenario 1: Successful purchase with exact change
        System.out.println("--- Scenario 1: Buy Coke ($1.50) with $2.00 ---");
        machine.insertMoney(1.00);
        machine.insertMoney(1.00); // Balance = $2.00
        machine.selectProduct("A1"); // Dispenses Coke, returns $0.50 change

        // Scenario 2: Insufficient funds
        System.out.println("--- Scenario 2: Insufficient funds for Chips ($1.00) ---");
        machine.insertMoney(0.50);
        machine.selectProduct("A2"); // Fails due to low balance
        machine.refund();
    }
}
