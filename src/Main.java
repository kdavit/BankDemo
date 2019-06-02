import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException, MediumException {
        TextProcessing textProcessing = new TextProcessing();
        double data = Double.parseDouble(textProcessing.read("akaki",745));
        System.out.println(data);
        List<String> user = textProcessing.read("giorgi");
        System.out.println(user.get(0));
        textProcessing.write("zurabi",493,"432");
        Core core = new Core();
        System.out.println(core.getdataId("zurabi"));
        System.out.println(textProcessing.read("zurabi",core.getdataId("zurabi")));
        core.withdraw("davit",60);
        System.out.println(textProcessing.read("davit",core.getdataId("davit")));
        core.transferAmount("zurabi","davit",500);
        System.out.println(textProcessing.read("davit",core.getdataId("davit")));
        System.out.println(textProcessing.read("zurabi",core.getdataId("zurabi")));
    }
}