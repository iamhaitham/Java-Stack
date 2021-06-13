public class BankAccountTest{
    public static void main(String[] args){
        BankAccount John=new BankAccount();
        System.out.println("John's account's number is "+ John.getRandomAccountNumber());       
        John.deposit("checking",1500);
        John.deposit("savings",2000);
        System.out.println(John.getAccountInfo()); 
        System.out.println("Until now we have "+BankAccount.numberOfAccounts+" users who have accounts");
        BankAccount Jack=new BankAccount();
        System.out.println("Until now we have "+BankAccount.numberOfAccounts+" users who have accounts");
        System.out.println(Jack.getCheckingBalance());
        Jack.withdraw("checking",50);
        Jack.deposit("checking",100);
        Jack.withdraw("checking",22);
        System.out.println(Jack.getCheckingBalance());
        System.out.println(Jack.getAccountInfo());       
    }
}