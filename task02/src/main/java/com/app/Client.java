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

            String  str = (String)objis.readUTF(); 
            System.out.println(str);

            objis.close();
            dout.flush();  
            dout.close();
            dis.close();
            s.close();  
            }
        catch(Exception e){System.out.println(e);}  
    }
}
