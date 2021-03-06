package io.github.williamtrindade.unity1.class3.exercise5;

import io.github.williamtrindade.unity1.class3.exercise5.abstracts.BankAccount;
import io.github.williamtrindade.unity1.class3.exercise5.interfaces.NormalAccountInterface;

public class CheckingAccount extends BankAccount implements NormalAccountInterface {

    private Double limit;

    CheckingAccount(Long id, Double initialBalance, BankAccount.Type type, boolean special) {
        super(id, initialBalance, type, special);
    }

    @Override
    public Double getLimit() {
        return limit + super.getBalance();
    }

    @Override
    public void setLimit(Double limit) {
        this.limit = limit;
    }

    @Override
    public void addMovement(Movement movement) throws IllegalStateException {
        switch(movement.getType()) {
            case CREDIT: 
                this.balance += movement.getValue();
                break;
            case DEBIT:
                if (movement.getValue() > this.getLimit()) {
                    throw new IllegalStateException("Value exceed the limit");
                }
                this.balance -= movement.getValue();
                break;
            default:
                throw new IllegalStateException("Incorrect movement type");
        }
        this.movements.add(movement);
    }
    
}