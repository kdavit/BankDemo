public class NotEnoughMoneyException extends Exception {
    private double amount;

    public NotEnoughMoneyException(double amount){
        this.amount = amount;
    }
    public double getAmount(){
        return amount;
    }
}
