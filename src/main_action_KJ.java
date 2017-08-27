import make_something.redudancy;
import test.test_vstavka;

import java.io.IOException;
import java.util.Date;

import static get_and_set.getRGB.getBlue;
import static get_and_set.getRGB.getBlue_without_chek;
import static get_and_set.get_Message_mass.getMessage;
import static make_something.Bytes_and_Bits.ByteToBit;
import static make_something.make_file.makeFile;

/**
 * Created by Slavik on 25.05.2016.
 */
public class main_action_KJ {

    public static void main(String[] args) throws IOException {

        Date start = new Date();
        int izbitochnost = 3;
        String istochnik = "winnie-the-pooh-disneyscreencaps.com-101";
        byte [] message = getMessage("catandvasya");     // это сообщение в байтах

        for (int i=0; i<message.length; i++){
            System.out.print(message[i]);
        }

        System.out.println("\n");

        byte[] bit_message = ByteToBit(message); //это сообщение в битовом виде

        for (int i=0; i<bit_message.length; i++){
            System.out.print(bit_message[i]);
        }System.out.println("\n");

        // тут вносим избыточность

        byte [] bit_mess_s_izb = redudancy.redundancy_in(bit_message, izbitochnost);

        byte [][] conteyner = getBlue(istochnik, bit_mess_s_izb); // тут проверяется длина
        System.out.println("\n"+conteyner[35][7]); // просто смотрю на произвольный массив

        byte [][] omega = test_vstavka.omega_in(conteyner, bit_mess_s_izb);
        make_something.make_txt.delete("Omega.txt");
        make_something.make_txt.write_byte(omega, "Omega.txt");

        get_and_set.setPixel.setInPixel("_copy", istochnik,omega);

       // начанается декодер

        byte [][] for_dec = getBlue_without_chek("out");
        byte [] out_bit_message_s_izb = test_vstavka.omega_out(for_dec, bit_mess_s_izb.length);
      /*  System.out.println(); for (int i=0; i<out_bit_message_s_izb.length;i++){
            System.out.print(out_bit_message_s_izb[i]);
        }*/

        //тут надо убирать избыточность
        byte [] out_bit_message = redudancy.redundancy_out(out_bit_message_s_izb, izbitochnost);

        byte [] out_byte_message =  make_something.Bytes_and_Bits.BitToByte(out_bit_message);
        System.out.println(); for (int i=0; i<out_byte_message.length;i++){
            System.out.print(out_byte_message[i]);
        }

        // Это должно быть в конце в декодере
        makeFile("Tester",out_byte_message);

        Date finish = new Date();
        long ms = finish.getTime() - start.getTime();
        System.out.println(); System.out.println("Время выполнения: " + ms + " миллисекунд");


    }
}
