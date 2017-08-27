package make_something;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by Slavik on 25.05.2016.
 */
public class make_file {

    public static void makeFile(String fileName, byte[]byteMass) {
            try {
                Files.write(Paths.get("C:\\forlabasteg\\"+fileName+".txt"), byteMass, StandardOpenOption.CREATE);
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
    }



