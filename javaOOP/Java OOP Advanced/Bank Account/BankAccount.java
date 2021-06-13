import java.util.Random;

public class BankAccount{
    protected long accountNumber=0;
    protected double checkingBalance=0;
    protected double savingsBalance=0;
    protected static int numberOfAccounts=0;
    private static double totalAmountOfMoney=0;

    //constructor
    public BankAccount(){
        this.accountNumber=getRandomAccountNumber();
        numberOfAccounts++;
    }

    //getter method for the user's checking account balance
    public double getCheckingBalance(){
        return this.checkingBalance;
    }

    //getter method for the user's saving account balance
    public double getSavingsBalance(){
        return this.savingsBalance;
    }

    // //method that will allow a user to deposit money
    public void deposit(String accountType, double amount){
        if(accountType=="checking"||accountType=="Checking"){
            this.checkingBalance+=amount;
            BankAccount.totalAmountOfMoney+=amount;
        }else if(accountType=="savings"||accountType=="Savings"){
            this.savingsBalance+=amount;
            BankAccount.totalAmountOfMoney+=amount;
        }
    }

    //method that will allow a user to withdraw money
    public void withdraw(String accountType, double amount){
        if(accountType=="checking"||accountType=="Checking"){
            if(this.checkingBalance-amount>=0){
            this.checkingBalance-=amount;
            BankAccount.totalAmountOfMoney-=amount;
            }else{
                System.out.println("You don't have enough money!");
            }
        }else if(accountType=="savings"||accountType=="Savings"){
            if (this.savingsBalance-amount>=0){
            this.savingsBalance-=amount;
            BankAccount.totalAmountOfMoney-=amount;
            }else{
                System.out.println("You don't have enough money!");
            }
        }
    }

    //method to see the total money from the checking and saving
    public String getAccountInfo(){
        return "This account has now $"+this.checkingBalance+" in Checking account, and $"+this.savingsBalance+" in Savings account.";
    }

    //private method that returns a random ten digit account number
    public long getRandomAccountNumber(){
        long lowerLimit = 1000000000L;
        long upperLimit = 9999999999L;
        Random r = new Random();
        long number = lowerLimit+((long)(r.nextDouble()*(upperLimit-lowerLimit)));
        return number;
    }
}
