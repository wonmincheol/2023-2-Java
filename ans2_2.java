class Bank{
    int money;
    public Bank(){
        money=0;
    }
    synchronized int inmoney(int m){
        money+=m;
        notifyAll();
        return money;
        
    }
    synchronized int outmoney(int m){
        try{
            while(money<m){
                wait();
            }
        }catch(InterruptedException e){}
        return money;
    }
    
}
class User extends Thread{
    
}

public class ans2_2 {
    
}
