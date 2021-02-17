package Pkg;

import java.rmi.Remote;

public interface RemoteInterface extends Remote {
    public int getAcNo()throws Exception;    
    public String getName()throws Exception;
    public int getBal()throws Exception;
    public void Deposit(int amount)throws Exception;
    public void Withdraw(int amount)throws Exception;
}