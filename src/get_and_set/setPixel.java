package get_and_set;

import make_something.make_txt;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * Created by Slavik on 25.05.2016.
 */
public class setPixel {
        public static void setInPixel(String fileName, String fileName2, byte [][] Pic) throws IOException {
            make_txt.copy(fileName2);
            File file= new File("C:\\forlabasteg\\"+fileName+".bmp");
            BufferedImage image = ImageIO.read(file);

            // Getting pixel color by position x=100 and y=80

            int width = image.getWidth();
            int higth = image.getHeight();
            int razmer = width * higth;
            int x = razmer / 8;

            byte[] pic_mass_temp = new byte[razmer];

            int sss = 0;
            for (int i = 0; i < x; i++) {
                for (int j = 0; j < 8; j++) {
                    pic_mass_temp[sss] = Pic[i][j];
                    sss = sss + 1;
                }
            }

            // обрати внимание, что пиксели он считывает сверху
            sss = 0;
            for (int i = 0; i < width; i++) {
                for (int j = 0; j < higth; j++) {
                    int clr = image.getRGB(i, j);
                    int temp = clr & 0xffffff00;
                    int temp2 = temp | pic_mass_temp[sss];
                   // System.out.println("это исходный "+clr+"; это с нулями на конце "+temp+"; это то что прибавляю "+pic_mass_temp[sss]+"; итог "+temp2);
                    image.setRGB(i,j,temp2);
                   // System.out.println(image.getRGB(i,j)+" "+pic_mass_temp[sss]+" "+temp2);
                    sss = sss + 1;
                }
            }

            System.out.print("ok");
            ImageIO.write(image, "bmp", new File("C:\\forlabasteg\\out.bmp"));
        }

    }