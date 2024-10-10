package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("server");
        ServerSocket ss = new ServerSocket(3000);
        Socket mioS = ss.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(mioS.getInputStream()));
        DataOutputStream out = new DataOutputStream(mioS.getOutputStream());
        String stringaricevuta = "";

        do{
            stringaricevuta = in.readLine();
            System.out.println("La stringa ricevuta : " + stringaricevuta);
            if(!stringaricevuta.equals("!"))
            {
                 String stringaMaiuscola = stringaricevuta.toUpperCase(); 
                 out.writeBytes(stringaMaiuscola + '\n');
            }
        }while (!stringaricevuta.equals("!"));
       

        System.out.println("server Finito");

        ss.close();
    }
}