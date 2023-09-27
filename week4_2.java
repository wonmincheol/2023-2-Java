import java.awt.*;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

class pn extends JFrame{
    public pn(){
        Container ct = getContentPane();
        JPanel pt =new JPanel();
        
        pt.setLayout(new GridLayout(1,3,5,5));
        JPanel pt1 =new JPanel();
        pt1.setLayout(new GridLayout(3,1,5,5));
        pt1.add(new JCheckBox("Red"));
        pt1.add(new JCheckBox("Green"));
        pt1.add(new JCheckBox("Blue"));
        
        JPanel pt2 =new JPanel();
        pt2.setLayout(new GridLayout(3,1,5,5));

        pt2.add(new JRadioButton("A형"));
        pt2.add(new JRadioButton("B형"));
        pt2.add(new JRadioButton("O형"));
        
        JPanel pt3 =new JPanel();
        pt3.setLayout(new FlowLayout());
        pt3.add(new JButton("선 택"));
        pt3.add(new JButton("취 소"));
        
        pt.add(pt1);
        pt.add(pt2);
        pt.add(pt3);
        
        JPanel pb =new JPanel();
        JPanel pb1 = new JPanel();
        JPanel pb2 = new JPanel();
        pb1.add(new JTextArea("자료입력공간", 5,30));
        JComboBox jcb = new JComboBox();
        jcb.addItem("1구간 지역");
        jcb.addItem("2구간 지역");
        
        pb2.add(jcb);

        pb.setLayout(new GridLayout(1,2,5,5));
        pb.add(pb1);
        pb.add(pb2);
        ct.setLayout(new GridLayout(2, 1, 5, 5));
        ct.add(pt);
        ct.add(pb);
        setSize(800, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         setVisible(true);

    }
}

public class week4_2 {
    public static void main(String args[]){
        new pn();
    }
}
