package com.example;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) throws IOException{
        System.out.println("server");
        ServerSocket ss = new ServerSocket(3000);
        while (true){
        Socket mioS = ss.accept();
        miothread m = new miothread(mioS);
        m.start();
        }
    }
}