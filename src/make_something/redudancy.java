package make_something;

/**
 * Created by Slavik on 31.05.2016.
 */
public class redudancy {

    public static byte [] redundancy_in(byte [] message, int kol_vo_dop_bit){

        for(int i=0; i<message.length;i++){System.out.print(message[i]+" ");}
        System.out.println("\n"+"Длина сообщения = "+message.length);
        byte[] message_s_izb = new byte [message.length*kol_vo_dop_bit];
        System.out.println("Длина сообщения с избыточностью = "+message_s_izb.length);
        int sss = 0;
        for(int i = 0; i<message.length;i++){
            for(int j = sss; j<sss+kol_vo_dop_bit;j++){
                message_s_izb[j] = message[i];
            }
            sss = sss+kol_vo_dop_bit;
        }

        for(int i=0; i<message_s_izb.length;i++){System.out.print(message_s_izb[i]+" ");}

        return message_s_izb;
    }


    public  static byte [] redundancy_out(byte [] message, int kol_vo_dop_bit){
        System.out.println("\n"+"Избавимся от избыточности");
        byte[] mess_vostanlennoe = new byte[message.length/kol_vo_dop_bit];
        int qqq = 0;
        for(int i = 0; i<message.length/kol_vo_dop_bit;i++){
            int tempOne = 0;
            int tempZero = 0;
            for(int j = qqq; j<qqq+kol_vo_dop_bit;j++){
                if (message[j]==1){tempOne = tempOne+1;}
                if (message[j]==0){tempZero = tempZero+1;}
            }
            if (tempZero>tempOne){mess_vostanlennoe[i]=0;}
            if (tempOne>tempZero){mess_vostanlennoe[i]=1;}
            qqq = qqq+kol_vo_dop_bit;
        }

        System.out.println();
        for(int i=0; i<mess_vostanlennoe.length;i++){System.out.print(mess_vostanlennoe[i]+" ");}

        return mess_vostanlennoe;
    }

}
