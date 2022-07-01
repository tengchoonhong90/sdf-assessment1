package com.app;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class Client 
{
    public static void main( String[] args )
    {
        try{      
            Socket s = new Socket("68.183.239.26",80);  
            DataOutputStream dout = new DataOutputStream(s.getOutputStream());  
            DataInputStream dis = new DataInputStream(s.getInputStream());
            ObjectOutputStream objos = new ObjectOutputStream(dout);
            ObjectInputStream objis = new ObjectInputStream(dis);

            String str = (String)objis.readUTF(); 
            System.out.println(str);

            String[] responseArray = str.split(" ");
            String requestID = responseArray[0];
            String[] stringArrayHolder = responseArray[1].split(",");
            int[] integerArray = new int[stringArrayHolder.length];
            for(int n = 0; n < stringArrayHolder.length; n++) {
                integerArray[n] = Integer.parseInt(stringArrayHolder[n]);
            }

            int sumOfInteger = 0;
            for (int i=0; i<integerArray.length; i++) {
                sumOfInteger += integerArray[i];
            }
            float average = sumOfInteger / 2;

            String name = "TENG CHOON HONG(DING JUNFENG)";
            String email = "tengchoonhong_90@outlook.com";


            System.out.println(requestID);
            System.out.println(name);
            System.out.println(email);
            System.out.println(average);

            objos.writeUTF(requestID);
            objos.writeUTF(name);
            objos.writeUTF(email);
            objos.writeFloat(average);

            // readBoolean till the data available to read
            while( dis.available() > 0) {
                System.out.println(dis.readBoolean());
                String response = (String)dis.readUTF();  
                System.out.println(response);
            }

            objos.flush();
            objos.close();
            objis.close();
            dout.flush();  
            dout.close();
            dis.close();
            s.close();  
            }
        catch(Exception e){System.out.println(e);}  
    }
}
