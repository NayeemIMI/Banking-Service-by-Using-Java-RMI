package Beans;

import java.io.Serializable;

public class Account implements Serializable{
    int AcNo;
    String AcName;
    int Bal;
    
    public Account(int AcNo, String AcName, int Bal){
        this.AcName = AcName;
        this.AcNo = AcNo;
        this.Bal = Bal;
    }
    
    public int getAcNo()
    {
        return AcNo;
    }
    public String getName()
    {
        return AcName;
    }
    public int getBal()
    {
        return Bal;
    }
    public void Deposit(int Amount)
    {
        Bal = Bal + Amount;
    }
    public void Withdrow(int Amount)
    {
        Bal = Bal - Amount;
    }
}
