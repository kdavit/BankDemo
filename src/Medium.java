import java.io.IOException;
import java.util.List;

public interface Medium {
    void write(String user,long dataId,String data) throws MediumException, IOException;
    String read(String user,long dataId) throws MediumException;
    List<String> read(String user) throws MediumException;
}
