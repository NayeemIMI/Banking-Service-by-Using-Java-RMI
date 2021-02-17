package Pkg;

import java.io.*;
import java.rmi.server.UnicastRemoteObject;
import Beans.Account;

public class ServerImplements extends UnicastRemoteObject implements RemoteInterface {
    public ServerImplements() throws Exception {
        super();
    }
    
    FileInputStream File = new FileInputStream("D:\\Document\\Java\\Banking\\src\\Pkg\\DB.txt");
    ObjectInputStream Obj = new ObjectInputStream(File);
    Account Acc = (Account) Obj.readObject();
    
    public int getAcNo(){
        return Acc.getAcNo();
    }
    public String getName(){
        return Acc.getName();
    }
    public int getBal(){
        return Acc.getBal();
    }
    public void Deposit(int amount){
        Acc.Deposit(amount);
    }
    public void Withdraw(int amount){
        Acc.Withdrow(amount);
    }
    
}