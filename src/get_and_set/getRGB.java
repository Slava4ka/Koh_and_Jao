package get_and_set;

import make_something.make_txt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Slavik on 24.05.2016.
 */
public class getRGB {
    public static byte[][] getBlue(String fileName, byte [] Message) throws IOException {
        File file= new File("C:\\forlabasteg\\"+fileName+".bmp");
        BufferedImage image = ImageIO.read(file);

        // Getting pixel color by position x=100 and y=80

        int width = image.getWidth();
        int higth = image.getHeight();
        int razmer = width * higth;
        System.out.println("высота " + higth + "; ширина " + width + "; всего пикселей " + razmer);

        if(Message.length>=razmer/64){
            System.out.println("вы выбрали слишком длинное сообщение " +Message.length);System.exit(1);}
        else System.out.println("Сообщение подходящей длины");

        int x = razmer / 8;

        byte[][] blue_mass = new byte[x][8];
        System.out.println("параметры массива " + x + " " + 8);
        System.out.println("Всего " + x / 8 + " матриц");

        byte[] pic_mass_blue_temp = new byte[razmer];

        // обрати внимание, что пиксели он считывает сверху
        int sss = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < higth; j++) {
                int clr = image.getRGB(i, j);
                int blue = clr & 0x000000ff;
                pic_mass_blue_temp[sss] = (byte) blue;
                //System.out.println(pic_mass_blue_temp.length+" "+sss);
                sss = sss + 1;
            }
        }

        sss = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 8; j++) {
                blue_mass[i][j] = pic_mass_blue_temp[sss];
                sss = sss + 1;
            }
        }

        make_txt write = new make_txt();
        write.delete("Blue_mass.txt");
        write.write_byte(blue_mass, "Blue_mass.txt");

        System.out.print("ok");
        return blue_mass;
    }


    public static byte[][] getBlue_without_chek(String fileName) throws IOException {
        File file= new File("C:\\forlabasteg\\"+fileName+".bmp");
        BufferedImage image = ImageIO.read(file);

        // Getting pixel color by position x=100 and y=80

        int width = image.getWidth();
        int higth = image.getHeight();
        int razmer = width * higth;
        System.out.println("высота " + higth + "; ширина " + width + "; всего пикселей " + razmer);

        int x = razmer / 8;

        byte[][] blue_mass = new byte[x][8];
        System.out.println("параметры массива " + x + " " + 8);
        System.out.println("Всего " + x / 8 + " матриц");

        byte[] pic_mass_blue_temp = new byte[razmer];

        // обрати внимание, что пиксели он считывает сверху
        int sss = 0;
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < higth; j++) {
                int clr = image.getRGB(i, j);
                int blue = clr & 0x000000ff;
                pic_mass_blue_temp[sss] = (byte) blue;
                //System.out.println(pic_mass_blue_temp.length+" "+sss);
                sss = sss + 1;
            }
        }

        sss = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < 8; j++) {
                blue_mass[i][j] = pic_mass_blue_temp[sss];
                sss = sss + 1;
            }
        }

        //make_txt write = new make_txt();
        //write.delete("Blue_mass.txt");
        //write.write_byte(blue_mass, "Blue_mass.txt");

        System.out.print("ok");
        return blue_mass;
    }
}
