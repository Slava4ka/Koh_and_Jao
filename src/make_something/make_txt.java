package make_something;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 * Created by Slavik on 24.05.2016.
 */
public class make_txt {

    public static void write (int [][] mass){
        try{
            FileWriter sw = new FileWriter("W.txt",true);
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass[0].length; j++) {
                    sw.write(mass[i][j]+"\t");
                }
                sw.write("\n");
            }
            sw.write("\n");
            sw.close();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }

    public static void copy(String name) throws IOException {
        File source = new File ("C:\\forlabasteg\\"+name+".bmp");
        File dest  =  new File("C:\\forlabasteg\\_copy.bmp");
        Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
        }

    public static void delete(String name) throws IOException {
        File file = new File(name);
        if(file.delete()){
            System.out.println("file.txt файл был удален с корневой папки проекта");
        }else System.out.println("Файл file.txt не был найден в корневой папке проекта");
    }

    public static void write_byte (byte [][] mass, String fileName){
        try{
            FileWriter sw = new FileWriter(fileName,true);
            for (int i = 0; i < mass.length; i++) {
                for (int j = 0; j < mass[0].length; j++) {
                    sw.write(mass[i][j]+"\t");
                }
                sw.write("\n");
            }
            sw.write("\n");
            sw.close();
        }catch(Exception e){
            System.out.print(e.getMessage());
        }
    }





}


