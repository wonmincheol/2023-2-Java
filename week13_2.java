import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

class clip extends JFrame {
    int clipx = 100;
    int clipy = 100;
    canvas cn = new canvas();

    public clip() {
        Container ct = getContentPane();
        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Open Challenge 12");
        ct.add(cn);
        this.addKeyListener(new keydown());

    }

    class canvas extends JPanel {
        ImageIcon icon = new ImageIcon("./bunny.jpg");
        Image img = icon.getImage();

        public void paint(Graphics g) {
            super.paint(g);
            g.setClip(clipx, clipy, 50, 50);
            g.drawImage(img, 0, 0, getWidth(), getHeight(), this);

        }
    }

    class keydown extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode();
            switch (keyCode) {
                case KeyEvent.VK_UP:
                    clipy -= 10;
                    break;
                case KeyEvent.VK_DOWN:
                    clipy += 10;
                    break;
                case KeyEvent.VK_LEFT:
                    clipx -= 10;
                    break;
                case KeyEvent.VK_RIGHT:
                    clipx += 10;
                    break;
            }
            System.out.println("in");
            cn.print(getGraphics());
        }
    }

}

public class week13_2 {
    public static void main(String args[]) {
        new clip();
    }
}
