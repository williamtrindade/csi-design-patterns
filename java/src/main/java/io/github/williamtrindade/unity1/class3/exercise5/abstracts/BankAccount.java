package io.github.williamtrindade.unity1.class3.exercise5.abstracts;

import io.github.williamtrindade.unity1.class3.exercise5.Movement;

import java.util.ArrayList;
import java.util.List;

public abstract class BankAccount {
    private final Long id;
    protected Double balance;
    private final boolean special;
    private final Type type;
    protected List<Movement> movements;

    public BankAccount(final Long id, Double initialBalance, Type type, boolean special) {
        this.id = id;
        this.balance = initialBalance;
        this.type = type;
        this.special = special;
        movements = new ArrayList<Movement>();
    }

    public Type getType() {
        return type;
    }

    public enum Type {
        CHECKING_ACCOUNT, SAVINGS_ACCOUNT, FIXED_INCOME_FUND, VARIABLE_INCOME_FUND
    }

    public boolean isSpecial() {
        return special;
    }

    public Double getBalance() {
        return balance;
    }

    public List<Movement> getMovements() {
        return new ArrayList<>(this.movements);
    }

    public Long getId() {
        return id;
    }

    public abstract void addMovement(Movement movement) throws IllegalStateException;
}