class Account{
    private int total = 0;
    synchronized void deposit(){
        if(trg==false){
            total +=1000;
        }

    }
    private boolean trg =false;
    synchronized boolean tr(){
        return trg;
    }
    synchronized void set_tr(){
        trg=true;
    }
    int gettotal(){
        return total;
    }
}

class Customer extends Thread{
    Account same_a;
    
    Customer(Account a, String s){
        same_a = a;
        setName(s);
        
    }
    public void run(){
        for(int i=1;i<=200;i++){
            if((same_a.tr()==true)||(same_a.gettotal()>=500000)){
                same_a.set_tr();
                break;
            }
            else if(same_a.tr()==false){
                System.out.println(getName()+" : "+i+"번째");
                same_a.deposit();
            }
            
        }
    }
}
class runCus extends Customer implements Runnable{
    public runCus(Account a, String s){
        super(a, s);
    }

}
public class ans2_1 {
    public static void main(String args[]) throws InterruptedException{
        Account same_account = new Account();

        runCus dona1 = new runCus(same_account, "1번째 성금자");
        runCus dona2 = new runCus(same_account, "2번째 성금자");
        runCus dona3 = new runCus(same_account, "3번째 성금자");

        dona1.start();
        dona2.start();
        dona3.start();
        dona1.join();
        dona2.join();
        dona3.join();

        System.out.println("성금 총액은 : "+same_account.gettotal());
        
    }
}
