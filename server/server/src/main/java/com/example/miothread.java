package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.Socket;

public class miothread extends Thread{
    Socket sThread;
    miothread(Socket sThread)
    {
        this.sThread = sThread;
    }
    
    public void run()
        {
            try{
                System.out.println("thread iniziato");

                BufferedReader in = new BufferedReader(new InputStreamReader(sThread.getInputStream()));
                DataOutputStream out = new DataOutputStream(sThread.getOutputStream());
                String stringaricevuta = "";
                do{
                    stringaricevuta = in.readLine();
                    System.out.println("La stringa ricevuta : " + stringaricevuta);
                    if(!stringaricevuta.equals("!"))
                    {
                         String stringaMaiuscola = stringaricevuta.toUpperCase(); 
                         out.writeBytes(stringaMaiuscola + '\n');
                    }
                }while(!stringaricevuta.equals("!"));
            
                System.out.println("thread Finito");
                  
            } catch (Exception e) {
                // TODO: handle exception
            }
     
        }
}
