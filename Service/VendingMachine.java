package Service;

import StatePattern.DispensingState;
import StatePattern.HasMoneyState;
import StatePattern.IdleState;
import StatePattern.State;
import model.Inventory;

public class VendingMachine {

    private State idleState;
    private State hasMoneyState;
    private State dispensingState;

    private State currentState;
    private double balance;
    private String selectedProductCode;
    private final Inventory inventory;

    public VendingMachine() {
        idleState = new IdleState();
        hasMoneyState = new HasMoneyState();
        dispensingState = new DispensingState();

        currentState = idleState;
        balance = 0.0;
        inventory = new Inventory();
    }

    public void insertMoney(double amount) { currentState.insertMoney(this, amount); }
    public void selectProduct(String code) { currentState.selectProduct(this, code); }
    public void refund() { currentState.refund(this); }

    // Getters and Setters for State Management
    public void setState(State state) { this.currentState = state; }
    public State getState() { return currentState; }

    public State getIdleState() { return idleState; }
    public State getHasMoneyState() { return hasMoneyState; }
    public State getDispensingState() { return dispensingState; }

    public void addBalance(double amount) { this.balance += amount; }
    public double getBalance() { return balance; }
    public void resetBalance() { this.balance = 0.0; }

    public void setSelectedProductCode(String code) { this.selectedProductCode = code; }
    public String getSelectedProductCode() { return selectedProductCode; }

    public Inventory getInventory() { return inventory; }
}
