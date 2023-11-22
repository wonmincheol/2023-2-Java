import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class client{
    public static void main(String args[]){
        Socket socket = null;
        BufferedReader in = null;
        BufferedWriter out = null;
        try{
            socket = new Socket("localhost",9999);
            in = new BufferedReader(new InputStreamReader((socket.getInputStream())));
            out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("서버에 접속하였습니다.");
            while(true){
                String input = in.readLine();
                System.out.print(input);
                input.replace("\n", "");
                if(input.equals("exit")){
                    break;
                }
                
            }
        }catch(IOException e){

        }
    }
}