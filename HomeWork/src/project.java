import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JRadioButton;

import java.util.*;
import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

//DnD방식 구현 코드 실패(데이터 변환시 발생하는 형변환 오류)
//https://www.specialagentsqueaky.com/blog-post/mbu5p27a/2011-01-09-drag-and-dropping-files-to-java-desktop-application/



class jp_lock extends JPanel{
    JLabel file_path = new JLabel();
    File selectFile;
    JProgressBar bar;
    public jp_lock(){
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        JButton file_load_Button = new JButton("load file(lock)");
        file_load_Button.addActionListener(new Load_File());
        
        file_path.setBackground(new Color(255,255,255));
        file_path.setOpaque(true);

        JButton run_Button = new JButton("run(lock)");
        run_Button.addActionListener(new run());
        
        bar = new JProgressBar();
        bar.setValue(1);
        bar.setStringPainted(true);


        this.add(file_load_Button,BorderLayout.WEST);
        this.add(file_path,BorderLayout.CENTER);
        this.add(run_Button,BorderLayout.EAST);
        this.add(bar,BorderLayout.SOUTH);

    }

    private class Load_File implements ActionListener{
        public void actionPerformed(ActionEvent e){
                //file load box
            JFrame window = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(window);
            if(result==JFileChooser.APPROVE_OPTION){
                selectFile = fileChooser.getSelectedFile();
                
                file_path.setText(selectFile.toString());
            }
        }
    }
    private class run implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //파일 경로@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            System.out.println(selectFile.toString());
            //진행상황 표시
            bar_setValue(-1);
        }
    }

    public void bar_setValue(int v){
        if(v==-1){
            int val=bar.getValue();
            bar.setValue(++val);
        }
        else{
            bar.setValue(v);
        }
    }
}

class jp_unlock extends JPanel{
    JLabel file_path = new JLabel();
    File selectFile;
    JProgressBar bar;

    public jp_unlock(){
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        JButton file_load_Button = new JButton("load file(unlock)");
        file_load_Button.addActionListener(new Load_File());
        
        file_path.setBackground(new Color(255,255,255));
        file_path.setOpaque(true);

        JButton run_Button = new JButton("run(unlock)");
        run_Button.addActionListener(new run());
        
        bar = new JProgressBar();
        bar.setValue(1);
        bar.setStringPainted(true);
        
        this.add(file_load_Button,BorderLayout.WEST);
        this.add(file_path,BorderLayout.CENTER);
        this.add(run_Button,BorderLayout.EAST);
        this.add(bar,BorderLayout.SOUTH);

    }

    private class Load_File implements ActionListener{
        public void actionPerformed(ActionEvent e){
                //file load box
            JFrame window = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(window);
            if(result==JFileChooser.APPROVE_OPTION){
                selectFile = fileChooser.getSelectedFile();
                
                file_path.setText(selectFile.toString());
            }
        }
    }
    private class run implements ActionListener{
        public void actionPerformed(ActionEvent e){
            //파일 경로@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
            System.out.println(selectFile.toString());
            //진행상황 표시
            bar_setValue(-1);
        }
    }
    public void bar_setValue(int v){
        if(v==-1){
            int val=bar.getValue();
            bar.setValue(++val);
        }
        else{
            bar.setValue(v);
        }
    }
}

class GUI extends JFrame{

    


    Container ct_main = getContentPane();
    JRadioButton rb_lock = new JRadioButton("LOCK");
    JRadioButton rb_unlock = new JRadioButton("UNLOCK");
    ButtonGroup buttonGroup = new ButtonGroup();
    JPanel top_Panel;
    JPanel ct_unlock = new JPanel();

    

    /**
     * 
     */
    public GUI(){
        //radio button setting
        buttonGroup.add(rb_unlock);
        buttonGroup.add(rb_lock);
        rb_lock.setSelected(true);
        rb_unlock.addActionListener(new Rb_control());
        rb_lock.addActionListener(new Rb_control());
        
        //main
        ct_main.setLayout(new BorderLayout());

        
        top_Panel = new JPanel();
        top_Panel.setLayout(new GridLayout(1,2));
        top_Panel.add(rb_lock);
        top_Panel.add(rb_unlock);
       
        setSize(700, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        setTitle("Encryption");
        
        change("lock");

    }


    public void change(String str){
        if(str.equals("lock")){
            getContentPane().removeAll();
            setLayout(new BorderLayout());
            this.add(top_Panel, BorderLayout.NORTH);
            getContentPane().add(new jp_lock(), BorderLayout.CENTER);
            revalidate();
            repaint();
        }
        else{
            getContentPane().removeAll();
            setLayout(new BorderLayout());
            this.add(top_Panel, BorderLayout.NORTH);

            getContentPane().add(new jp_unlock(), BorderLayout.CENTER);
            revalidate();
            repaint();
        }
    }


    private class Rb_control implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(rb_lock.isSelected()==true){
                
                change("lock");
                System.out.println("lock");
            }
            else{
                change("unlock");
                System.out.println("unlock");
                
            }
        }
    }

    
}





public class project {
    public static void main(String args[]){
        new GUI();
    }    
}

