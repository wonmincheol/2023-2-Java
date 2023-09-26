import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
class Pn extends JFrame{
    public Pn(){
        Container ct = getContentPane();
        GridLayout go = new GridLayout(2,1,5,5);
        ct.setLayout(go);
        JPanel pt = new JPanel();
        ct.add(pt);
        GridLayout gl = new GridLayout(1,3,5,5);
        pt.setLayout(gl);
        JPanel pt2 = new JPanel();
        GridLayout pt2_lay = new GridLayout(3,1,5,5);
        pt2.setLayout(pt2_lay);
        JPanel test = new JPanel();
        test.add(new JRadioButton("red"));
        JPanel test2 = new JPanel();
        test2.add(new JRadioButton("grean"));
        JPanel test3 = new JPanel();
        test3.add(new JRadioButton("blue"));

        
        pt2.add(test);
        pt2.add(test2);
        pt2.add(test3);

        pt.add(pt2);
        
        JPanel pt3 = new JPanel();
        GridLayout pt3_lay = new GridLayout(3,1,5,5);
        pt3.setLayout(pt3_lay);
        JPanel test11 = new JPanel();
        test11.add(new JRadioButton("A형"));
        JPanel test22 = new JPanel();
        test22.add(new JRadioButton("B형"));
        JPanel test33 = new JPanel();
        test33.add(new JRadioButton("O형"));

         pt3.add(test11);
        pt3.add(test22);
        pt3.add(test33);

        pt.add(pt3);

        JPanel pb= new JPanel();
        ct.add(pb);
        GridLayout gl2 = new GridLayout(1,2,5,5);
        JPanel pt4 = new JPanel();
        JPanel pt5 = new JPanel();
        
        
        setSize(800, 300);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
}



public class APP2 {
    public static void main(String args[]){
        new Pn();
    }
}
