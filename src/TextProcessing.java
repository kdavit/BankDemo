import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TextProcessing implements Medium {
    private String Path = "C:\\Users\\David\\IdeaProjects\\BankDemo\\src\\data";

    URI uri = new File(Path).toURI();
    List<String> striqonebi;

    {
        try {
            striqonebi = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /* same as getBalance */
    public String read(String user,long dataId){
        double amount = 0;

        for (String i:striqonebi) {
            if(i.split(" ")[1].equals(user) && i.split(" ")[0].equals(Long.toString(dataId))){
                amount += Double.parseDouble(i.split(" ")[2]);
            }
        }
        
        return Double.toString(amount);
    }

    public List<String> read(String user){


        List<String> data = new ArrayList<>();
        for (String i:striqonebi) {
            if(i.split(" ")[1].equals(user)){
                data.add(i);
            }
        }
        return data;
    }

    public void write(String user,long dataId,String data) throws IOException {
        FileWriter fileWriter = new FileWriter(Path,true);

        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(dataId + " " + user + " " + data + "\n");
        bufferedWriter.close();

        /* backup plan(creating second file)*/
        URI uri = new File(Path).toURI();
        List<String> striqonebi = null;

        {
            try {
                striqonebi = Files.readAllLines(Paths.get(uri), Charset.defaultCharset());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        
        PrintWriter writer = new PrintWriter("data2.txt", "UTF-8");
        for (String i:striqonebi) {
            writer.write(i + "\n");
        }
        writer.close();
    }
}
