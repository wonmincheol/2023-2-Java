import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class JPanell extends JFrame{
    JLabel jl;
    public JPanell(){
        Container ct = getContentPane();

        ct.setLayout(new FlowLayout());
        
        jl = new JLabel("1학년");

        JButton b1 = new JButton("1학년");
        JButton b2 = new JButton("2학년");
        JButton b3 = new JButton("3학년");
        JButton b4 = new JButton("4학년");

        b1.addActionListener(new Ep());
        b2.addActionListener(new Ep());
        b3.addActionListener(new Ep());
        b4.addActionListener(new Ep());

        ct.add(b1);
        ct.add(b2);
        ct.add(b3);
        ct.add(b4);
        ct.add(jl,BorderLayout.CENTER);
        
        setTitle("Event Test1");

        setSize(300, 200);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private class Ep implements ActionListener{
        public void actionPerformed(ActionEvent e){
            jl.setText(e.getActionCommand());
        }
    }
}


public class App {
    public static void main(String[] args) throws Exception {
        new JPanell();
 
    }
}
