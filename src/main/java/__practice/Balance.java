package __practice;

public class Balance {
    private final int balance;


    public Balance(int balance) {
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public Balance add(NaturalNumber i) {
        return new Balance(balance + i.getNumber());
    }

    public Balance sub(NaturalNumber i) {
        if(this.balance < i.getNumber()) {
            throw new IllegalArgumentException();
        }
        return new Balance(balance - i.getNumber());
    }
}
