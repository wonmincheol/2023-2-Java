import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class server {
    public static void main(String args[]){
        ServerSocket listener = null;  
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        try{
            listener = new ServerSocket(9999);
            System.out.println("타임서버입니다.");
            socket = listener.accept();
            System.out.println("연결되었습니다.");
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("500ms마다 수를 보냅니다.");
            out.write("서버의 시간 : ");
            rep_time(out);
            System.out.println("종료합니다.");
            out.flush();
        }
        catch(IOException e){

        }
        finally{
            try{
                if(socket!=null) socket.close();
                if(listener != null) listener.close();
            }catch(Exception e){
                System.out.println("error");
            }
        }
    }
    static void rep_time(BufferedWriter out){
        try{
            for(int i=0;i<10;i++){
                out.write(i + " \n");
                out.flush();
                Thread.sleep(500);
            }
        out.write("exit");
        }catch(Exception e){
                
        }
        
        
    }   
}