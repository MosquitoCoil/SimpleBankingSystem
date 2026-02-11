package model;

public class Account {
    private int id;
    private String name;
    private double balance;
    
    public Account(String name, double balance){
        this.name = name;
        this.balance = balance;
    }
    
    public Account(int id, double balance){
        this.id = id;
        this.balance = balance;
    }
 
    public Account(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public double getBalance(){
        return balance;
    }
}
