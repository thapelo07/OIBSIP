package ATM;

public interface ATM_Interface {
    void transactionsHistory();
    void withdrawCash(double amount);
    void depositCash(double amount);
    void transferCash(String toAccount, double amount);
    void quit();
}
