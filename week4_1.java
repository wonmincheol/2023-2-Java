import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.*;

class inter extends JFrame{
    public inter(){
        JLabel jl =new JLabel("testtes");
        String[] list = {"BackSpace","","","CE","C","7","8","9","/","sqrt","4","5","6","x","%","1","2","3","-","1/x","0","+.-",".","+","="};
        JPanel jp1 = new JPanel();
        jl.setSize(20, 20);
        jp1.add(jl);
        JPanel jp2 = new JPanel();
        jp2.setLayout(new GridLayout(5,5,5,5));
        for(int i=0;i<5;i++){
            for(int j=0;j<5;j++){
                JButton jb = new JButton(list[i*5+j]);
                jb.setBackground(Color.yellow);
                if(j>3){
                    jb.setForeground(Color.red);
                }
                else{
                    jb.setForeground(Color.blue);
                }
                jp2.add(jb);
            }
        }

        Container ct = getContentPane();
        ct.setLayout(new BorderLayout(10,10));
        ct.add(jp1,BorderLayout.NORTH);
        ct.add(jp2,BorderLayout.CENTER);
        setSize(800, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);
    }
}


public class week4_1 {
    public static void main(String args[]){
        new inter();
    }
}
