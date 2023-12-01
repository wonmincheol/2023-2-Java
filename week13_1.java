import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class check extends JFrame {
    public TextArea ta;
    Scanner sc;
    FileReader fr;
    String before;

    public check() {
        Container ct = getContentPane();
        ta = new TextArea();

        ct.add(ta);

        setSize(500, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("���� ��ȸ");
        try {
            fr = new FileReader("./score.txt");
            sc = new Scanner(fr);
            ta.append("score.txt �б� �Ϸ�\n");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public String print_score(String s) throws FileNotFoundException {
        sc = new Scanner(new FileReader("./score.txt"));

        while (sc.hasNext()) {
            String st = sc.next();
            String grade = sc.next();
            if ((st.equals(before)) && s.equals(st)) {

                return grade;
            } else if (st.equals(s)) {
                before = st;
                ta.append(st + " " + grade + "\n");
                return grade;
            }
        }
        return "\0";

    }

}

class client extends JFrame {
    check server;
    JTextField jtf;
    JLabel jl;

    public client() {
        server = new check();

        setSize(500, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("����üũ Ŭ���̾�Ʈ");

        Container ct = getContentPane();
        ct.setLayout(new GridLayout(1, 4));
        ct.add(new JLabel("�̸� �Է�"));
        jtf = new JTextField();
        JLabel jtext = new JLabel("����");
        jl = new JLabel();
        ct.add(jtf);
        ct.add(jtext);
        ct.add(jl);
        new ch().run();
    }

    class ch extends Thread {
        public void run() {
            while (true) {
                String s = jtf.getText();
                try {
                    String gra = server.print_score(s);
                    jl.setText(gra);
                } catch (FileNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }
    }
}

public class week13_1 {
    public static void main(String args[]) {
        new client();
    }
}
