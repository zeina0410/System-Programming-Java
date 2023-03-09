package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Handler extends Thread {

    public static Socket connection;
    public static PrintWriter out;
    public static Scanner x;

    public Handler(Socket c) {
        connection = c;
    }

    public void run() {
        try {
            out = new PrintWriter(connection.getOutputStream()); //استلام بيانات
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));// ادخال بيانات
            //--------------------------------------------------------
            String login = in.readLine();
            String accnumber = in.readLine();
            String pin = in.readLine();
            //--------------------------------------------------------
            FileReader fr = new FileReader("Accounts.txt");
            BufferedReader br = new BufferedReader(fr);
            //--------------------------------------------------------
            String Line = br.readLine();
            String filepath = "Accounts.txt";
            
            while (Line != null) {
                if (login.equals("login")) {
                    System.out.println("acc " + accnumber);
                    System.out.println("pin " + pin);
                    checklogin(filepath, accnumber, pin);
                    out.println("true");
                    out.flush();
                    out.println(accnumber);
                    out.flush();
                    out.println(pin);
                    out.flush();
                    fr.close();
                    br.close();
                }
                String req = in.readLine();
                if (req.equals("req")) {
                    FileReader fd = new FileReader("Accounts.txt");
                    BufferedReader br1 = new BufferedReader(fd);
                    String cLine;
                    String data[];
                    
                    while ((cLine = br1.readLine()) != null) {
                        data = cLine.split(",");
                        if (!(data[0].equalsIgnoreCase(accnumber))) {
                           System.out.println("Not here not there");
                        } 
                        else if (data[0].equalsIgnoreCase(accnumber)  &&  data[1].equalsIgnoreCase(pin)  ) {
                           System.out.println("balance1"+data[3]);
                            out.println(data[3]);
                            out.flush();
                            fd.close();
                            br1.close();
                            break;
                        }
                    }
                    fd.close();
                    br1.close();fr.close();br.close();in.close();
                }
                String fetch = in.readLine(); // هون جبنا رسالة من زر السحب باسم withdraw
                System.out.println("Fetching " + fetch);
                if (fetch.equals("fetch")) {
                    String accfwtd = in.readLine();// هون جبنا الرصيد الجديد بعد السحب
                    System.out.println("Acc from withdraw  " + accfwtd);
                    String accnum = "", pin1 = "", name1 = "", balance1 = "", date1 = "";
                    x = new Scanner(new File(filepath));
                    x.useDelimiter("[,\n]");
                    while (x.hasNext()) {
                        accnum = x.next();
                        pin1 = x.next();
                        name1 = x.next();
                        balance1 = x.next();
                        date1 = x.next();
                        if (accnum.equals(accnumber) && pin1.equals(pin)) {
                            out.println(balance1);
                            out.flush();
                            x.close();
                            break;
                        }
                    }
                    x.close();
                    System.out.println("Scanner closed");
                    fr.close();
                    br.close();
                    out.flush();
                }

                String wtdn = in.readLine();// هو جبنا ال رقم تبع ال دخول من زر السحب
                System.out.println("Withdrawing " + wtdn);
                fr.close();
                br.close();
                out.flush();
                File OldFile = new File("Accounts.txt");
                File NewFile = new File("temp.txt");

                if (wtdn.equals("withdraw")) {
                    String newbal = in.readLine();
                    System.out.println("new balance after withdraw  " + newbal);
                    String ACCwtd = in.readLine();
                    String money = in.readLine();
                    System.out.println("Username from Draw::" + ACCwtd);
                    System.out.println("Drawn money from Draw::" + money);
                    String DATE = in.readLine();
                    System.out.println("Drawn DATE" + DATE);
                    
                    FileWriter fs = new FileWriter("temp.txt", true);
                    FileWriter fs1 = new FileWriter("Transaction.txt", true);
                    BufferedWriter bw = new BufferedWriter(fs);
                    BufferedWriter bw1 = new BufferedWriter(fs1);
                    PrintWriter ps = new PrintWriter(bw);
                    PrintWriter ps1 = new PrintWriter(bw1);
                    FileReader fd = new FileReader("Accounts.txt");
                    BufferedReader br1 = new BufferedReader(fd);
                    String cLine;
                    String data[];
                    while ((cLine = br1.readLine()) != null) {
                        data = cLine.split(",");
                        if (!(data[0].equalsIgnoreCase(ACCwtd))) {
                            ps.println(cLine);
                        } 
                        else if (data[0].equalsIgnoreCase(ACCwtd)) {
                            ps.println(data[0] + "," + data[1] + "," + data[2] + "," + newbal + "," + data[4]);
                            ps1.println(data[0] + "," + data[1] + "," + data[2] + "," + money + "," + DATE);
                        }
                    }
                    ps.flush();
                    ps.close();
                    ps1.flush();
                    ps1.close();
                    bw.close();
                    bw1.close();
                    fs.close();
                    fs1.close();
                    fs.close();
                    fd.close();
                    br1.close();
                    fr.close();
                    br.close();
                    x.close();
                    out.flush();
                    
                    OldFile.delete();
                    File nfile = new File("Accounts.txt");
                    NewFile.renameTo(nfile);
                    System.out.println("Updated");
                }

                String state = in.readLine();
                if (state.equals("state")) {
                    System.out.println("State is here");
                    String ACC2 = in.readLine();
                    System.out.println("ACC from State" + ACC2);
                    FileReader st = new FileReader("Transaction.txt");
                    BufferedReader st1 = new BufferedReader(st);
                    String cLine;
                    String data[];
                    
                    while ((cLine = st1.readLine()) != null) {
                        data = cLine.split(",");
                        if (!(data[0].equalsIgnoreCase(ACC2))) {
                            System.out.println("Not this" + cLine);
                        } 
                        else if (data[0].equalsIgnoreCase(ACC2)) {
                            System.out.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4]);
                            out.println(data[0] + "," + data[1] + "," + data[2] + "," + data[3] + "," + data[4]);
                            out.flush();
                        }
                    }
                    
                    st.close();
                    st1.close();
                    fr.close();br.close();in.close();
                    out.println("finish");
                    out.flush();  
                }
            }
        } 
        catch (IOException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
    }

    public static void checklogin(String filepath, String accnumber, String pin) throws FileNotFoundException {

        String accnum = "", pin1 = "", name1 = "", balance1 = "", date1 = "";
        try {
            FileReader fr = new FileReader(filepath);////1
            BufferedReader br = new BufferedReader(fr);//////1
            x = new Scanner(new File(filepath));
            x.useDelimiter("[,\n]");
            while (x.hasNext()) {
                accnum = x.next();
                pin1 = x.next();
                name1 = x.next();
                balance1 = x.next();
                date1 = x.next();
                if (accnum.equals(accnumber) && pin1.equals(pin)) {
                    System.out.println("-------------------------------------------------------------------------------------------");
                    System.out.println("                 " + "Name   " + "Account number   " + "Pincode   " + "Balance   " + "OpenDate   ");
                    System.out.println("FoUND Match::    " + name1 + " ,     " + accnumber + "      , " + pin + " ,   " + balance1 + " ,   " + date1);
                    break;
                } 
                else {
                    System.out.println("NOT A MATCH::   " + "acc:  " + accnum + "   pin:  " + pin1 + "   name:  " + name1 + "   balance:  " + balance1 + "   date:  " + date1);
                }
            }
            System.out.println("-------------------------------------------------------------------------------------------");
            System.out.println("^_^Check login function Closed ^_^");
            x.close();
            br.close();
            fr.close();
        } 
        catch (IOException ex) {
            Logger.getLogger(Project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
