package clientproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import clientproject.Login;
import static clientproject.Login.connection;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.io.RandomAccessFile;
import java.io.BufferedReader;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;

public class Menu extends javax.swing.JFrame {

    public int C;
    //public static  Login obj = new Login();
    String b;
    String ACC;
    String PIN;
    String balance;

    public Menu(String accn, String piin) {
        initComponents();
        ACC = accn;
        PIN = piin;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        reqbalance = new javax.swing.JButton();
        withdraw = new javax.swing.JButton();
        statment = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel2.setBackground(new java.awt.Color(74, 31, 61));

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 3, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Menu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 239, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );

        reqbalance.setBackground(new java.awt.Color(74, 31, 61));
        reqbalance.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        reqbalance.setForeground(new java.awt.Color(255, 255, 255));
        reqbalance.setText("Request Balance");
        reqbalance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                reqbalanceActionPerformed(evt);
            }
        });

        withdraw.setBackground(new java.awt.Color(74, 31, 61));
        withdraw.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        withdraw.setForeground(new java.awt.Color(255, 255, 255));
        withdraw.setText("Withdraw");
        withdraw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                withdrawActionPerformed(evt);
            }
        });

        statment.setBackground(new java.awt.Color(74, 31, 61));
        statment.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        statment.setForeground(new java.awt.Color(255, 255, 255));
        statment.setText("Short Statment");
        statment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                statmentActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 112, Short.MAX_VALUE)
                .addComponent(reqbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                .addComponent(statment, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(156, 156, 156))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(245, 245, 245)
                .addComponent(withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 72, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statment, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(reqbalance, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(81, 81, 81)
                .addComponent(withdraw, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void statmentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_statmentActionPerformed

        try {
            Socket connection = new Socket("127.0.0.1", 9320);
            PrintWriter out = new PrintWriter(connection.getOutputStream()); //استلام بيانات
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            out.println("forlogin");
            out.flush();
            out.println(ACC);
            out.flush();
            out.println(PIN);
            out.flush();
            out.println("forreq");
            out.flush();
            out.println("for fetch");
            out.flush();
            out.println("for withdraw");
            out.flush();
            out.println("state");
            out.flush();
            out.println(ACC);
            out.flush();
            String Line;
            System.out.println("AccNum, PIN, Name, DrawnMoney, DrawnDate");

            List<String> tmp = new ArrayList<String>();
            while ((Line = in.readLine()) != null) {
                tmp.add(Line);
            }
            in.close();
            Collections.reverse(tmp);
            if(tmp.size()>=3){
                for(int i=0; i<3; i++){
                    System.out.println(tmp.get(i));
                }
            }
            else if(tmp.size()== 2){
                for(int i=0; i<2; i++){
                    System.out.println(tmp.get(i));
                }
            }
            else if(tmp.size()== 1){
                System.out.println(tmp.get(0));
            }
            else {
                System.out.println("");
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_statmentActionPerformed

    private void withdrawActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_withdrawActionPerformed

        try {
            Socket connection = new Socket("127.0.0.1", 9320);
            PrintWriter out = new PrintWriter(connection.getOutputStream()); //استلام بيانات
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            out.println("withdraw");
            out.flush();
            out.println(ACC);
            out.flush();
            out.println(PIN);
            out.flush();
            out.println("withdraw");
            out.flush();
            out.println("fetch");
            out.flush();
            out.println(ACC);
            out.flush();
            String balancefromserver = in.readLine();
            System.out.println("balance from server   " + balancefromserver);

            withdraw info = new withdraw(balancefromserver, ACC, PIN);
            info.setVisible(true);
            System.out.println("You Have Requested Withdraw Service");
            out.flush();
        }
        catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_withdrawActionPerformed

    private void reqbalanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_reqbalanceActionPerformed
        System.out.println("-------------------------------------------------------------------------------------------");
        System.out.println("You have Requested Your Balance");

        try {
            Scanner input = new Scanner(System.in);
            connection = new Socket("127.0.0.1", 9320);
            PrintWriter out = new PrintWriter(connection.getOutputStream()); //اارسال  بيانات
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            out.println("req");
            out.flush();
            out.println(ACC);
            out.flush();
            out.println(PIN);
            out.flush();
            out.println("req");
            out.flush();
            String s = in.readLine();
            System.out.println("Your Balance ::     " + s);
            System.out.println("-------------------------------------------------------------------------------------------");
            input.close();
            out.flush();
            out.close();
            in.close();
        }
        catch (IOException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_reqbalanceActionPerformed

    public static void main(String args[]) throws IOException {

        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Menu.class.getName()).log(Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //    new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton reqbalance;
    private javax.swing.JButton statment;
    private javax.swing.JButton withdraw;
    // End of variables declaration//GEN-END:variables
}
