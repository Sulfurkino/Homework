package Bank;

public class BankAccount {

    private double accountBalance;
    private boolean blocked;

    public BankAccount(double accountBalance) {
        if (accountBalance < 0) {
            throw new NegativeAmountException(
                    "Начальный баланс не может быть отрицательным"
            );
        }

        this.accountBalance = accountBalance;
        this.blocked = false;
    }

    public void deposit(double amount) {
        checkBlocked();

        if (amount <= 0) {
            throw new NegativeAmountException(
                    "Сумма пополнения должна быть больше нуля"
            );
        }

        accountBalance += amount;
    }

    public void withdraw(double amount) {
        checkBlocked();

        if (amount <= 0) {
            throw new NegativeAmountException(
                    "Сумма снятия должна быть больше нуля"
            );
        }

        if (amount > accountBalance) {
            throw new InsufficientFundsException(
                    "Недостаточно средств на счёте"
            );
        }

        accountBalance -= amount;
    }

    private void checkBlocked() {
        if (blocked) {
            throw new AccountBlockedException(
                    "Операция невозможна: счёт заблокирован"
            );
        }
    }

}