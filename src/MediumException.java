public class MediumException extends Throwable {
    private double balance = 0;

    public void addBalance(int id,double deposit){

    }

    public void getMoney(int id,double amount) throws NotEnoughMoneyException{
        if(amount <= balance){
         balance -= amount;
        }
        else {
            double AmountNeeded = amount - balance;
            throw new NotEnoughMoneyException(AmountNeeded);
        }
    }

    public double getBalance(){
        return balance;
    }
}
