import java.io.IOException;
import java.util.List;

public class Core {
    Medium medium = new TextProcessing();

    public void deposit(String cliet,int amount) throws MediumException, IOException {

        long dataId = getdataId(cliet);
        /* get balance using medium read */
        double balance = Double.parseDouble(this.medium.read(cliet,dataId));

        if(balance + amount >= 0){
            medium.write(cliet,dataId,Integer.toString(amount));
        }
    }

    public void withdraw(String client,int amount) throws MediumException, IOException {
        deposit(client,-amount);
    }

    public void transferAmount(String fromClient,String toClient,int amount) throws MediumException, IOException {
        deposit(fromClient,-amount);
        deposit(toClient,amount);
    }
//    public double getBalance(String client) throws MediumException {
//        double balance = 0;
//        List<String> striqonebi = new ArrayList<>();
//        striqonebi = medium.read(client);
//        for (String striqoni:striqonebi) {
//            balance += Double.parseDouble(striqoni.split(" ")[2]);
//        }
//        return balance;
//    }

    public long getdataId(String client) throws MediumException {
        List<String> clientlist = this.medium.read(client);
        return Long.parseLong(clientlist.get(0).split(" ")[0]);
    }

}
