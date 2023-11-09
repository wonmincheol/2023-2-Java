import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import java.awt.*;
import java.awt.event.ActionEvent;

class GridLayoutF extends JFrame {

    JLabel index = new JLabel("test");

    public GridLayoutF() {

        GridLayout gl = new GridLayout(5, 5, 5, 5);
        Container ct2 = getContentPane();
        ct2.add(new JLabel("test"), BorderLayout.NORTH);

        JPanel ct = new JPanel();
        ct2.add(ct, BorderLayout.SOUTH);
        ct.setLayout(gl);
        JButton BackSpace = new JButton("BackSpace");
        ct.add(BackSpace);

        ct.add(new Button());
        ct.add(new Button());
        // CE
        JButton CEs = new JButton("CE");
        ct.add(CEs);
        // C
        JButton C = new JButton("C");
        ct.add(C);
        ct.add(new JButton("7"));
        ct.add(new JButton("8"));
        ct.add(new JButton("9"));

        JButton dive = new JButton("/");
        ct.add(dive);
        // sqrt
        JButton SQRT = new JButton("SQRT");
        ct.add(SQRT);
        // 4
        ct.add(new JButton("4"));
        ct.add(new JButton("5"));
        ct.add(new JButton("6"));
        // x
        JButton X = new JButton("X");
        ct.add(X);
        // %
        JButton div = new JButton("%");
        ct.add(div);
        ct.add(new JButton("1"));
        ct.add(new JButton("2"));
        ct.add(new JButton("3"));
        JButton MIN = new JButton("-");
        ct.add(MIN);
        // -
        JButton flip = new JButton("1/x");
        ct.add(flip);
        // 1/x
        ct.add(new JButton("0"));
        // +/-
        ct.add(new JButton("+/-"));
        // .
        ct.add(new JButton("."));
        // +
        ct.add(new JButton("+"));
        ct.add(new JButton("="));

        // ct2.add(ct,BorderLayout.SOUTH);

        setSize(800, 400);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void actionPerformed(ActionEvent e) {
        index.setText("");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        // new First();
        new GridLayoutF();
    }
}
