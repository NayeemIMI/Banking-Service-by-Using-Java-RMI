package Pkg;

import java.rmi.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Client extends javax.swing.JFrame {
    Label Lb = new Label("");
    Label Lb2 = new Label("");
    Label Lb3 = new Label("");
    Label Lb4 = new Label("Enter the amount to deposit: ");
    TextField Txt = new TextField(10);
    JButton B = new JButton("Deposit");
    
    Label Lb5 = new Label("Enter the amount to withdrow: ");
    TextField Txt2 = new TextField(10);
    JButton B2 = new JButton("Withdraw");
    
    Panel Pnl = new Panel(new GridLayout(3, 1, 1, 1));
    RemoteInterface RI;

    public Client() {
        super("Account Management");
        setSize(800, 300);
        getContentPane().setBackground(Color.green);
        setLocation(300, 200);
        getContentPane().add(Pnl, "North");
        Pnl.add(Lb);
        Pnl.add(Lb2);
        Pnl.add(Lb3);
        Pnl.add(Lb4);
        Pnl.add(Txt);
        Pnl.add(B);
        Pnl.add(Lb5);
        Pnl.add(Txt2);
        Pnl.add(B2);
        try {
            String IP = JOptionPane.showInputDialog("Please insert the IP Address!");
            int port =5000;
            String Address = "rmi://" + IP +":"+ port+ "/Nayeem";
            RI = (RemoteInterface) Naming.lookup(Address);
            int AcNo = RI.getAcNo();
            String Name = RI.getName();
            int Bal = RI.getBal();
            Lb.setText("Account Holder's Name: " + Name);            
            Lb2.setText("Account Number: " + AcNo);
            Lb3.setText("Account Balance: " + Bal+ " TK");


        } catch (Exception e) {
          JOptionPane.showMessageDialog(null, e.getMessage());
          
        }
        
        B.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent AE) {
                int Amount = Integer.parseInt(Txt.getText());
                try {
                    RI.Deposit(Amount);
                    int newBal = RI.getBal();
                    Lb3.setText("Account Balance: " + newBal+ " TK");
                } catch (Exception e) { e.printStackTrace();
                }
            }
        });
        
        B2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent AE) {
                int Amount = Integer.parseInt(Txt2.getText());
                try {
                    RI.Withdraw(Amount);
                    int newBal = RI.getBal();
                    Lb3.setText("Account Balance: " + newBal+ " TK");
                } catch (Exception e) { e.printStackTrace();
                }
            }
        });
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addContainerListener(new java.awt.event.ContainerAdapter() {
            public void componentRemoved(java.awt.event.ContainerEvent evt) {
                formComponentRemoved(evt);
            }
        });
        getContentPane().setLayout(null);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentRemoved(java.awt.event.ContainerEvent evt) {//GEN-FIRST:event_formComponentRemoved

    }//GEN-LAST:event_formComponentRemoved

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException e) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (InstantiationException e) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (IllegalAccessException e) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        } catch (javax.swing.UnsupportedLookAndFeelException e) {
            java.util.logging.Logger.getLogger(Client.class.getName()).log(java.util.logging.Level.SEVERE, null, e);
        }
        Client Cli = new Client();
        Cli.setDefaultCloseOperation(EXIT_ON_CLOSE);
        Cli.setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
