package get_and_set;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by Slavik on 25.05.2016.
 */
public class get_Message_mass {
    public static byte [] getMessage(String name){
        byte mass [] = null;
        Path path = Paths.get("C:\\forlabasteg\\"+name+".txt");
        try {
            mass = Files.readAllBytes(path);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return mass;
    }
}
