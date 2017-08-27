package test;

import make_something.DCP_and_iDCP;

/**
 * Created by Slavik on 25.05.2016.
 */
public class test_vstavka {
    public static byte [][] omega_in(byte [][] conteyner, byte [] bit_message){

        int P = 25;

        DCP_and_iDCP qr = new DCP_and_iDCP();

        byte [][] omega = new byte [conteyner.length][conteyner[0].length];
        int vsego_matrix = conteyner.length/8;

        int lol = 0;
        int lolo = 0;

        for (int i=0;i<vsego_matrix;i++){
            byte [][] temp = new byte [8][8];

            for (int j=lol;j<lol+8;j++) {
                for (int k = 0; k < 8; k++) {
                    temp[j%8][k] = conteyner [j][k];
                }
            }

            double [][] temp_d = qr.dcp(temp);

           //ssdsdsds
            if ((bit_message.length != i) && (bit_message.length > i) ) {
               /* int z1 = 0, z2 = 0;
                double coefficient1 = Math.abs(temp_d[4][3]);
                double coefficient2 = Math.abs(temp_d[3][4]);

                if (temp_d[4][3] >= 0) z1 = 1;
                else z1 = -1;
                if (temp_d[3][4] >= 0) z2 = 1;
                else z2 = -1;

                if (bit_message[i] == 0 && coefficient1 <= coefficient2) coefficient1 = P + coefficient2 + 1;
                if (bit_message[i] == 1 && coefficient1 >= coefficient2) coefficient2 = P + coefficient1 + 1;

                temp_d[4][3] = z1 * coefficient1;
                temp_d[3][4] = z2 * coefficient2;*/

                if (bit_message[i]==0){
                    while((Math.abs(temp_d[3][4])-Math.abs(temp_d[4][3]))<P){ // УСЛОВИЯ
                        temp_d[3][4] = ((temp_d[3][4]-1))%256;
                        temp_d[4][3] = ((temp_d[4][3]+3))%256;}
                }
                else
                if (bit_message[i]==1){
                    while((Math.abs(temp_d[3][4])-Math.abs(temp_d[4][3]))>(0-P)){ // УСЛОВИЯ
                        temp_d[3][4] = ((temp_d[3][4]+3))%256;
                        temp_d[4][3] = ((temp_d[4][3]-1))%256;}
                }

                System.out.println(temp_d[3][4]+" "+temp_d[4][3]);
            }

           // System.out.println(bit_message.length);
  /*   if ((bit_message.length != i) && (bit_message.length > i) ){
         if (bit_message[i] == 0) {
             temp_d[4][3] = 0;
             temp_d[3][4] = 15;
         } else if (bit_message[i] == 1) {
             temp_d[4][3] = 15;
             temp_d[3][4] = 0;
         }
     }*/
            double[][] temp_d2 = qr.idcp(temp_d);
            byte [][] temp2 = new byte[temp_d2.length][temp_d2[0].length];

            for (int m =0; m<temp2.length; m++){
                for (int t=0; t<temp2[0].length; t++){
                    temp2[m][t] = (byte)(temp_d2[m][t]);
                }
            }

            for (int j=lolo;j<lolo+8;j++) {
                for (int k = 0; k < 8; k++) {
                    conteyner [j][k] = temp2[j%8][k] ;
                }
            }
            lolo = lol+8;
            lol = lol+8;
        }

        return conteyner;
    }

    public static byte [] omega_out(byte conteyner[][], int aaa){
        DCP_and_iDCP qr = new DCP_and_iDCP();

        byte [][] omega = new byte [conteyner.length][conteyner[0].length];
        byte [] bit_message = new byte [aaa];

        int vsego_matrix = conteyner.length/8;
        int lol = 0;

        for (int i=0;i<vsego_matrix;i++){
            byte [][] temp = new byte [8][8];

            for (int j=lol;j<lol+8;j++) {
                for (int k = 0; k < 8; k++) {
                    temp[j%8][k] = conteyner [j][k];
                }
            }

            double [][] temp_d = qr.dcp(temp);

            // System.out.println(bit_message.length);
            if ((bit_message.length != i) && (bit_message.length > i) ){
               /* if (temp_d[4][3]-temp_d[3][4]<-10){bit_message[i]=0;}
                if (temp_d[4][3]-temp_d[3][4]>10){bit_message[i]=1;}*/

              /*  if (Math.abs(temp_d[4][3]) > Math.abs(temp_d[3][4])) {bit_message[i]=0;}
                else if (Math.abs(temp_d[4][3]) < Math.abs(temp_d[3][4])) {bit_message[i]=1;}*/


                if (Math.abs(temp_d[3][4])>Math.abs(temp_d[4][3])){bit_message[i]=0;}
                else
                if (Math.abs(temp_d[3][4])<Math.abs(temp_d[4][3])){bit_message[i]=1;}


            }

            lol = lol+8;
        }

        return bit_message;
    }




}
