package ATM;

public class Transaction {
    public String transactionType;
    public double amount;
    public User user;
    public String toAccount;

    public Transaction(String transactionType, double amount,User user){
        this.user = user;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public Transaction(String transactionType, double amount,User user,String toAccount){
        this(transactionType,amount,user);
        this.toAccount = toAccount;
    }

    public String getTransactionType(){
        return transactionType;
    }

    public double getAmount(){
        return amount;
    }

    public User getUser(){
        return user;
    }

    public String getToAccount(){
        return toAccount;
    }




}
