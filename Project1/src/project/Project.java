package project;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Project extends Thread {
    public static ServerSocket server;

    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        server = new ServerSocket(9320);
        Thread thread = new Project();
        thread.start();
        System.out.println("Server Is Currently Running");
        System.out.println("--------------------This is The Admin Panel--------------------" );
        System.out.println("     1) Admin Can Delete A Client" );
        System.out.println("                    By Account number and press Delete Button" );
        System.out.println("                    " );
        System.out.println("     2) Admin Can Update A Client Information" );
        System.out.println("                    By Filling the Blanks with The new Data and press Update" );
        System.out.println("      ((NOTE)): Admin Have to Fill all the blanks with New and Old Data            " );
        System.out.println("                    " );
        System.out.println("     3) Admin Can ADD A Client " );
        System.out.println("                    By Filling the Blanks and press ADD" );
        System.out.println("---------------------------------------------------------------" );
        System.out.println("---------------------------------------------------------------" );
        new Admin().setVisible(true);// هي مشان اظهر ادمن ليضيف ويحذف
    }

    @Override
    public void run() {
        while (true) {
            try {
                Socket c = server.accept();
                System.out.println("Client accept");//127.0.0.1:9092
                Handler h = new Handler(c);
                h.start();
            } 
            catch (IOException ex) {
                Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
