import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class rl extends JFrame{
    
    public rl(){
        Container ct = getContentPane();
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        Dimension dim = new Dimension(300, 300);
        ct.setPreferredSize(dim);
        for(int i=0;i<20;i++){
            JLabel label = new JLabel(Integer.toString(i));
            ct.add(label);
            label.setOpaque(true);
            label.setBackground(Color.blue);
            label.setLocation((int)(Math.random()*200)+50, (int)(Math.random()*200)+50);
            label.setSize(10, 10);
            
        }
        
    }
        

}

public class week4_3 {
    public static void main(String args[]){
        new rl();
    }   
}
