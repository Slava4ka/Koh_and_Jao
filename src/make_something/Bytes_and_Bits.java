package make_something;

/**
 * Created by Slavik on 25.05.2016.
 */
public class Bytes_and_Bits {
    public static byte[] ByteToBit(byte [] mass_byte) {
        byte [] bitMass = new byte [mass_byte.length*8];
        int mass_length = mass_byte.length;
        int bit_mass_length = mass_byte.length*8;

        int sdvig = 7;
        int scetchik = 0;

        for (int i = 0; i< mass_length; i++){
            byte uuu = (byte)mass_byte[i];

            for (int j = 0; j<8; j++){
                byte temp = (byte)(uuu&(1<<(sdvig-(j))));
                if (temp!=0){temp = 1;}
                bitMass[scetchik] = (byte)temp;
                scetchik++;
            }
        }
        return bitMass;
    }


    public static byte[] BitToByte(byte [] mass_bit) {
        byte [] bytMass = new byte [mass_bit.length/8];
        int mass_length = mass_bit.length;
        int byt_mass_length = mass_bit.length/8;

        int index = 0;
        int index_gran = 8;
        int indexForSdvig = 7;

        for (int i=0; i<mass_length;i++){
            byte temp = 0b00000000;
            for (int j=index; j<index_gran;j++){
                temp=(byte)(temp|(mass_bit[j]<<indexForSdvig));
                indexForSdvig--;
            }
            index = index + 8;
            bytMass[i]= (byte)temp;
            index_gran=index_gran+8;
            indexForSdvig=7;
            if(index_gran>mass_length){break;}
        }
        return bytMass;
    }
}
