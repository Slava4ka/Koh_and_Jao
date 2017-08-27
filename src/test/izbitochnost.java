package test;

/**
 * Created by Slavik on 26.05.2016.
 */
public class izbitochnost {
    public static void main(String[] args) {
        byte [] message = {1,0,1,0,1,0,1,1,1,0};

        int izbitochnost = 7;

        for(int i=0; i<message.length;i++){System.out.print(message[i]+" ");}
        System.out.println("\n"+"Длина сообщения = "+message.length);

        byte [] message_s_izb = new byte [message.length*izbitochnost];
        System.out.println("Длина сообщения с избыточностью = "+message_s_izb.length);

        int sss = 0;
        for(int i = 0; i<message.length;i++){
             for(int j = sss; j<sss+izbitochnost;j++){
                 message_s_izb[j] = message[i];
             }
            sss = sss+izbitochnost;
        }
        for(int i=0; i<message_s_izb.length;i++){System.out.print(message_s_izb[i]+" ");}



        //декодер
        byte [] mess_vostanlennoe = new byte[message_s_izb.length/izbitochnost];

        int qqq = 0;
        for(int i = 0; i<message.length;i++){
                int tempOne = 0;
                int tempZero = 0;
            for(int j = qqq; j<qqq+izbitochnost;j++){
              if (message_s_izb[j]==1){tempOne = tempOne+1;}
              if (message_s_izb[j]==0){tempZero = tempZero+1;}
            }
            if (tempZero>tempOne){mess_vostanlennoe[i]=0;}
            if (tempOne>tempZero){mess_vostanlennoe[i]=1;}
            qqq = qqq+izbitochnost;
        }
        System.out.println();
        for(int i=0; i<mess_vostanlennoe.length;i++){System.out.print(mess_vostanlennoe[i]+" ");}
    }
}
