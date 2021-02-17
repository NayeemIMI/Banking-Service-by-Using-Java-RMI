package Pkg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import Beans.Account;

public class Server {
  public static void main(String args[]) {
    try {
        
      Account Ac = new Account(17511062, "Yeakub Ali", 500);
      FileOutputStream File = new FileOutputStream("D:\\Document\\Java\\Banking\\src\\Pkg\\DB.txt");
      ObjectOutputStream Obj = new ObjectOutputStream(File);
      Obj.writeObject(Ac);
      Obj.close();
      File.close();
      
      ServerImplements SrvImp = new ServerImplements();
      Registry Reg = LocateRegistry.createRegistry(5000);
      Naming.rebind("rmi://localhost:5000/Nayeem", SrvImp);
      System.out.println("Server is Online!!!");
      
    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }
}
