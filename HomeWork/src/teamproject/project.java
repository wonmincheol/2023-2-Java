import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.util.*;
import java.util.concurrent.Flow;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

//https://www.specialagentsqueaky.com/blog-post/mbu5p27a/2011-01-09-drag-and-dropping-files-to-java-desktop-application/

class locker extends JPanel {
    public JLabel file_addr;
}

class jp_lock extends locker {
    JPanel file_path = new JPanel();
    File selectFile;
    JProgressBar bar;

    // public JLabel file_addr;
    JTextField jtf;

    public jp_lock() {
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        // addr load button
        JButton file_load_Button = new JButton("load file(lock)");
        file_load_Button.addActionListener(new Load_File());

        // file addr print
        file_path.setLayout(new GridLayout(2, 1));
        file_addr = new JLabel();
        file_addr.setBackground(new Color(255, 255, 255));
        file_addr.setOpaque(true);
        jtf = new JTextField();
        file_path.add(file_addr);
        file_path.add(jtf);

        // run button
        JButton run_Button = new JButton("run(lock)");
        run_Button.addActionListener(new run());

        bar = new JProgressBar();
        bar.setValue(1);
        bar.setStringPainted(true);

        this.add(file_load_Button, BorderLayout.WEST);
        this.add(file_path, BorderLayout.CENTER);
        this.add(run_Button, BorderLayout.EAST);
        this.add(bar, BorderLayout.SOUTH);

    }

    private class Load_File implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // file load box
            JFrame window = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(window);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectFile = fileChooser.getSelectedFile();

                file_addr.setText(selectFile.toString());
            }
        }
    }

    private class run implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // System.out.println(selectFile.toString());
            bar_setValue(-1);
            System.out.println("key : " + getkey());
            try {
                // block
                /*
                 * Reader.block_key = new MiniBlock().code(file_addr.getText(),
                 * Reader.block_key);
                 * int[] Rsa_key = new RSA_Code().generate_RSA_Key();
                 * Reader.RSA_KEY = Rsa_key;
                 * Reader.block_key = new RSA_Code().RSA_Conversion(Reader.block_key,
                 * Rsa_key[1], Rsa_key[0]);
                 */
                Reader.block_key = new MiniBlock().code(file_addr.getText(), Reader.block_key);
                // xor
                // new XorC(file_addr.getText(), getkey());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public void bar_setValue(int v) {
        if (v == -1) {
            int val = bar.getValue();
            bar.setValue(++val);
        } else {
            bar.setValue(v);
        }
    }

    public String getkey() {
        String s;
        s = jtf.getText();
        return s;
    }
}

class jp_unlock extends locker {
    JLabel file_path = new JLabel();
    File selectFile;
    JProgressBar bar;

    // JLabel file_addr;
    JTextField jtf;

    public jp_unlock() {
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        // addr load button
        JButton file_load_Button = new JButton("load file(unlock)");
        file_load_Button.addActionListener(new Load_File());

        // file addr print
        file_path.setLayout(new GridLayout(2, 1));
        file_addr = new JLabel();
        file_addr.setBackground(new Color(255, 255, 255));
        file_addr.setOpaque(true);
        jtf = new JTextField();
        file_path.add(file_addr);
        file_path.add(jtf);

        // run button
        JButton run_Button = new JButton("run(unlock)");
        run_Button.addActionListener(new run());

        bar = new JProgressBar();
        bar.setValue(1);
        bar.setStringPainted(true);

        this.add(file_load_Button, BorderLayout.WEST);
        this.add(file_path, BorderLayout.CENTER);
        this.add(run_Button, BorderLayout.EAST);
        this.add(bar, BorderLayout.SOUTH);

    }

    private class Load_File implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // file load box
            JFrame window = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(window);
            if (result == JFileChooser.APPROVE_OPTION) {
                selectFile = fileChooser.getSelectedFile();

                file_addr.setText(selectFile.toString());
            }
        }
    }

    private class run implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // System.out.println(selectFile.toString());
            bar_setValue(-1);
            System.out.println("key : " + getkey());

            try {
                // block
                /*
                 * Reader.block_key = new RSA_Code().RSA_Conversion(Reader.block_key,
                 * Reader.RSA_KEY[2],
                 * Reader.RSA_KEY[0]);
                 * Reader.block_key = new MiniBlock().code(file_addr.getText(),
                 * Reader.block_key);
                 */
                Reader.block_key = new MiniBlock().code(file_addr.getText(), Reader.block_key);

                // xor
                // new XorC(file_addr.getText(), getkey());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
    }

    public void bar_setValue(int v) {
        if (v == -1) {
            int val = bar.getValue();
            bar.setValue(++val);
        } else {
            bar.setValue(v);
        }
    }

    public String getkey() {
        String s;
        s = jtf.getText();
        return s;
    }
}

class GUI extends JFrame {

    Container ct_main = getContentPane();
    JRadioButton rb_lock = new JRadioButton("LOCK");
    JRadioButton rb_unlock = new JRadioButton("UNLOCK");
    ButtonGroup buttonGroup = new ButtonGroup();
    JPanel top_Panel;
    JPanel ct_unlock = new JPanel();

    locker now_Panel;

    FileIO fileio;

    /**
     * 
     */
    public GUI() {
        // radio button setting
        buttonGroup.add(rb_unlock);
        buttonGroup.add(rb_lock);
        rb_lock.setSelected(true);
        rb_unlock.addActionListener(new Rb_control());
        rb_lock.addActionListener(new Rb_control());

        // main
        ct_main.setLayout(new BorderLayout());

        top_Panel = new JPanel();
        top_Panel.setLayout(new GridLayout(1, 2));
        top_Panel.add(rb_lock);
        top_Panel.add(rb_unlock);

        setSize(700, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Encryption");

        change("lock");

        // communication thr part
        // new Read_GUI_SET().run();
        try {
            fileio = new FileIO();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        Read_GUI_SET rgs = new Read_GUI_SET();
        Thread thr = new Thread(rgs);
        thr.setDaemon(true);
        thr.start();

    }

    public void change(String str) {
        if (str.equals("lock")) {
            getContentPane().removeAll();
            setLayout(new BorderLayout());
            this.add(top_Panel, BorderLayout.NORTH);

            now_Panel = new jp_lock();
            getContentPane().add(now_Panel, BorderLayout.CENTER);

            revalidate();
            repaint();
        } else {
            getContentPane().removeAll();
            setLayout(new BorderLayout());
            this.add(top_Panel, BorderLayout.NORTH);

            now_Panel = new jp_unlock();
            getContentPane().add(now_Panel, BorderLayout.CENTER);
            revalidate();
            repaint();
        }
    }

    private class Rb_control implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (rb_lock.isSelected() == true) {

                change("lock");
                System.out.println("lock");
            } else {
                change("unlock");
                System.out.println("unlock");

            }

        }
    }

    class Read_GUI_SET implements Runnable {
        private boolean ISReadGUISET;

        public Read_GUI_SET() {
            ISReadGUISET = false;
        }

        @Override
        public void run() {
            ISReadGUISET = true;
            while (ISReadGUISET) {
                // System.out.println((System.currentTimeMillis())
                // + " Reader state (true -> move data, false -> not move data): " +
                // Reader.isRead);
                if (Reader.isRead == true) {
                    // abj args
                    ajb_args(Reader.s);
                    // jta.append(Reader.s + "\n");
                    // System.out.println("is Read");
                    Reader.isRead = false;
                } else {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void stop() {
            ISReadGUISET = false;
        }
    }

    public void ajb_args(String s) {
        System.out.println("arg : " + Reader.s);
        now_Panel.file_addr.setText(Reader.s);

        if ((now_Panel.getClass().getName()).equals("jp_lock")) {
            System.out.println("now -> lock");
        } else {
            System.out.println("now -> unlock");
        }
    }

}

class GUI_Com extends JFrame {
    Container ct_main = getContentPane();

    JTextField jtf = new JTextField(20);
    JTextArea jta = new JTextArea(7, 20);
    FileIO fileIO;

    public GUI_Com() throws IOException {
        fileIO = new FileIO();

        setSize(250, 250);
        // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Communication");

        JPanel jp_jtf = new JPanel();
        JPanel jp_jta = new JPanel();

        ct_main.setLayout(new BorderLayout());

        jp_jta.add(jta);
        jp_jtf.add(jtf);

        ct_main.add(jp_jtf, BorderLayout.NORTH);
        ct_main.add(new JScrollPane(jp_jta), BorderLayout.CENTER);

        // new Read_GUI_SET().run();
        Read_GUI_SET rgs = new Read_GUI_SET();
        Thread thr = new Thread(rgs);
        thr.setDaemon(true);
        thr.start();

        jtf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField t = (JTextField) e.getSource();
                String s = t.getText();
                // jta.append(s + "\n");
                t.setText("");

                try {
                    fileIO.Java_to_Py(s + "\n");
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    jta.append(e1.getMessage() + "\n");
                    e1.printStackTrace();
                }
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("del" + Reader.deleteTxt());
                rgs.stop();
            }
        });
    }

    class Read_GUI_SET implements Runnable {
        private boolean ISReadGUISET;

        public Read_GUI_SET() {
            ISReadGUISET = false;
        }

        @Override
        public void run() {
            ISReadGUISET = true;
            while (ISReadGUISET) {
                // System.out.println((System.currentTimeMillis())
                // + " Reader state (true -> move data, false -> not move data): " +
                // Reader.isRead);
                if (Reader.isRead == true) {
                    jta.append(Reader.s + "\n");
                    // System.out.println("is Read");
                    Reader.isRead = false;
                } else {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public void stop() {
            ISReadGUISET = false;
        }
    }
}

class FileIO {
    FileWriter op;
    FileReader ip;

    public FileIO() throws IOException {
        Java_to_Py("Start Com");
        Py_to_Java();
        // ip = new FileReader("c:/test/commu.txt");
    }

    public boolean Java_to_Py(String s) throws IOException {
        // try {
        // op = new FileWriter(args, true);
        // } catch (Exception e) {
        // op = new FileWriter(args);
        // }

        // 통신 send감지 클래스

        Reader.deleteTxt();
        op = new FileWriter(Reader.args);
        boolean ret = false;
        op.write(s);
        op.close();
        Py_to_Java();
        return ret;

    }

    public boolean Py_to_Java() {
        boolean ret = false;

        // 통신 recv감지 클래스
        FileLineWatcher wat = new FileLineWatcher(new File(Reader.args));
        Thread thread = new Thread(wat);
        thread.setDaemon(true);
        thread.start();

        return ret;
    }

}

class Reader {
    static String s;
    static Boolean isRead;
    static String args = "./commu.txt";
    static int[] block_key;
    static int[] RSA_KEY;

    public static boolean deleteTxt() {
        return new File(args).delete();
    }
}

class FileLineWatcher implements Runnable {
    private static final int DELAY_MILLIS = 1000;
    private boolean isRun;
    private final File file;

    public FileLineWatcher(File file) {
        this.file = file;
        Reader.isRead = false;
    }

    @Override
    public void run() {
        System.out.println("Start to tail a file - " + file.getName());
        isRun = true;
        if (!file.exists()) {
            System.out.println("Failed to find a file - " + file.getPath());
        }

        // try 문에서 Stream을 열면 블럭이 끝났을 때 close를 해줌
        while (true) {
            while (Reader.isRead == false) {
                try {

                    while (isRun) {
                        BufferedReader br = new BufferedReader(
                                new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8));
                        // readLine(): 파일의 한 line을 읽어오는 메소드

                        if (Reader.isRead == false) {
                            final String le = br.readLine();
                            if (le != null && le != "\n" && le != "\0" && !le.equals("Start Com")
                                    && !le.equals(Reader.s)) {
                                Reader.isRead = true;
                                System.out.println("New line added - " + le);
                                Reader.s = le;
                                // br.close();

                            } else {
                                Thread.sleep(DELAY_MILLIS);
                            }
                        } else {
                            Thread.sleep(DELAY_MILLIS);
                        }
                    }

                } catch (Exception e) {
                    System.out.println(e.getMessage());
                    // System.out.println("Failed to tail a file - " + file.getPath());
                }
                // System.out.println("Stop to tail a file - " + file.getName());

            }
        }

    }

    public void stop() {
        isRun = false;
    }
}// 출처:https:// jinseongsoft.tistory.com/146 [진성 소프트:티스토리]

public class project {
    public static void main(String args[]) throws IOException {
        new GUI();
        // new GUI_Com();
    }
}

class XorC {
    public XorC(String args, String key) throws IOException {
        System.out.println(args + "\t : \t" + key);
        byte[] key_byte = key.getBytes();
        FileInputStream is;
        FileOutputStream os;
        String[] s = args.split("\\.");
        if (s[s.length - 1].equals("cry")) {
            is = new FileInputStream(args);
            os = new FileOutputStream(args.substring(0, args.length() - 4));
        } else {
            is = new FileInputStream(args);
            os = new FileOutputStream(args + ".cry");
        }
        byte[] data = new byte[1024];
        int read = is.read(data);
        int index = 0;
        while (read != -1) {
            for (int k = 0; k < read; k++) {
                data[k] ^= key_byte[index % key_byte.length];
                index++;
            }
            os.write(data, 0, read);
            read = is.read(data);

        }
        os.flush();
        os.close();
        is.close();
    }
}

class MiniBlock {
    private FileInputStream is;
    private FileOutputStream os;
    private Random rd = new Random();

    private byte[] random_key(byte[] data) {// 랜덤키 만들기
        byte[] base = data;
        int random_p;
        boolean random_b;
        for (int i = 0; i < base.length; i++) {
            random_p = rd.nextInt(8);
            random_b = rd.nextBoolean();
            if (random_b) {
                base[i] = (byte) (base[i] << random_p);
            } else {
                base[i] = (byte) (base[i] >> random_p);
            }
        }
        byte[] output = new byte[2];
        int random_n = rd.nextInt(base.length) + 1;
        int index = 0;
        for (int i = 0; i < random_n; i++) {
            output[0] = (byte) (base[index % base.length]);
            index++;
        }
        random_n = rd.nextInt(base.length) + 1;
        index = 0;
        for (int i = 0; i < random_n; i++) {
            output[1] = (byte) (base[index % base.length]);
            index++;
        }
        return output;
    }

    private int byteToInt(byte input) {
        int output = input & 0xff;
        return output;
    }

    private int[] encode(String args) throws IOException {
        is = new FileInputStream(args);
        os = new FileOutputStream(args + ".cry");
        byte[] data = new byte[1024];
        int read = is.read(data);
        int index = 0;
        int r = rd.nextInt(1020);
        byte[] extra_int = new byte[] { data[r], data[r + 1], data[r + 2], data[r + 3] };
        byte[] En_key = random_key(extra_int);
        while (read != -1) {
            for (int k = 0; k < read; k++) {
                data[k] ^= En_key[index % En_key.length];
                index++;
            }
            os.write(data, 0, read);
            read = is.read(data);

        }
        os.flush();
        os.close();
        is.close();
        int[] En_key_int = new int[En_key.length];
        for (int i = 0; i < En_key.length; i++) {
            En_key_int[i] = byteToInt(En_key[i]);
        }
        return En_key_int;
    }

    private void decode(String args, int[] key_int) throws IOException {
        byte[] key = new byte[key_int.length];
        for (int i = 0; i < key_int.length; i++) {
            key[i] = (byte) key_int[i];
        }
        is = new FileInputStream(args);
        os = new FileOutputStream(args.substring(0, args.length() - 4));
        byte[] data = new byte[1024];
        int read = is.read(data);
        int index = 0;
        while (read != -1) {
            for (int k = 0; k < read; k++) {
                data[k] ^= key[index % key.length];
                index++;
            }
            os.write(data, 0, read);
            read = is.read(data);

        }
        os.flush();
        os.close();
        is.close();
    }

    public int[] code(String args, int[] key_int) throws IOException {
        String[] s = args.split("\\.");
        int[] return_key;
        if (s[s.length - 1].equals("cry")) {
            return_key = new RSA_Code().RSA_Conversion(key_int, Reader.RSA_KEY[2], Reader.RSA_KEY[0]);

            decode(args, return_key);
            return null;
        } else {
            return_key = encode(args);
            Reader.RSA_KEY = new RSA_Code().generate_RSA_Key();
            return_key = new RSA_Code().RSA_Conversion(return_key, Reader.RSA_KEY[1], Reader.RSA_KEY[0]);
            return return_key;
        }
    }
}

class RSA_Code {
    private int[] exgcd(int a, int b) { // 확장된 유클리드 알고리즘
        int arr[] = new int[10];
        arr[1] = a;
        arr[2] = b;
        arr[4] = 1;
        arr[5] = 0;
        arr[7] = 0;
        arr[8] = 1;
        do {
            if (arr[2] == 0) {
                break;
            } else {
                arr[0] = arr[1] / arr[2];
                for (int i = 3; i <= 9; i += 3) {
                    arr[i] = arr[i - 2] - (arr[0] * arr[i - 1]);
                }
                for (int i = 0; i < 9; i++) {
                    arr[i] = arr[i + 1];
                }
            }
        } while (true);
        if (arr[4] < 0) {
            arr[4] += arr[5];
        }
        int r_arr[] = { arr[1], arr[4], arr[7] };
        return r_arr;
    }

    private boolean check_Prime(int a) { // 소수인지 체크(p, q)
        boolean check = true;
        int num = (int) Math.sqrt(a);
        for (int i = 2; i <= num; i++) {
            if (a % i == 0) {
                check = false;
                break;
            }
        }
        return check;
    }

    private int random_Prime(int n) { // 랜덤 소수
        Random r = new Random();
        int i;
        do {
            i = r.nextInt(n) + 100;
        } while (!(check_Prime(i)));
        return i;
    }

    private boolean check_Coprime(int a, int v) { // 서로수인지 체크
        int check = exgcd(a, v)[0];
        if (check == 1) {
            return true;
        } else {
            return false;
        }
    }

    private int random_Coprime(int a, int b) { // e 생성
        a -= 1;
        b -= 1;
        int v;
        do {
            v = random_Prime(a * b);
        } while (!(check_Coprime(a, v)) || !(check_Coprime(b, v)));
        return v;
    }

    private int modular(int a, int b, int c) { // 모듈러 함수
        int res;
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return (a % c);
        }
        res = modular(a, b / 2, c);
        if (b % 2 == 0) {
            return ((res * res) % c);
        } else {
            return ((((res * res) % c) * (a % c)) % c);
        }
    }

    public int[] generate_RSA_Key() {// 0.n, 1.e, 2.d
        int r = new Random().nextInt(99) + 1;

        int a, b;
        do {
            a = random_Prime(r);
            b = random_Prime(r);
        } while (a == b);
        int n = a * b;
        int e = random_Coprime(a, b);
        int d = exgcd(e, (a - 1) * (b - 1))[1];
        int[] res = { n, e, d };
        return res;
    }

    public int code_RSA(int num, int key, int n) {// num이 n보다 크면 작동 안됨. n을 적당히 크게 잡을 것.
        int res = modular(num, key, n);
        return res;
    }

    public int[] RSA_Conversion(int[] input, int key, int n) {
        int[] ret = input;
        for (int i = 0; i < ret.length; i++) {
            ret[i] = code_RSA(ret[i], key, n);
        }
        return ret;
    }
}