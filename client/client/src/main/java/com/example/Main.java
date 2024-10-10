package com.example;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws UnknownHostException, IOException{
        Socket s = new Socket("localhost",3000);

        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        DataOutputStream out = new DataOutputStream(s.getOutputStream());

        String tastiera = "";
        Scanner sc = new Scanner(System.in);

        do{
            System.out.println("client partito");
            tastiera = sc.nextLine();
            if(tastiera.equals("exit")){
                out.writeBytes("!" + '\n');
            }
            out.writeBytes(tastiera + '\n');
            String stringaMaiuscola= in.readLine();
            System.out.println(stringaMaiuscola);
        }while(!tastiera.equals("exit"));
        
            System.out.println("client Finito");        

        s.close();
    }
}