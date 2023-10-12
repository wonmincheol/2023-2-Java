import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

class jp_lock extends JPanel{
    JLabel file_path = new JLabel();

    public jp_lock(){
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        JButton file_load_Button = new JButton("load file(lock)");
        file_load_Button.addActionListener(new Load_File());
        
        this.add(file_load_Button,BorderLayout.WEST);
        this.add(file_path,BorderLayout.CENTER);
    }

    private class Load_File implements ActionListener{
        public void actionPerformed(ActionEvent e){
                //file load box
            JFrame window = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(window);
            if(result==JFileChooser.APPROVE_OPTION){
                File selectFile = fileChooser.getSelectedFile();
                
                //파일 경로@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                file_path.setText(selectFile.toString());
            }
        }
    }
}

class jp_unlock extends JPanel{
    JLabel file_path = new JLabel();

    public jp_unlock(){
        this.setVisible(true);
        this.setLayout(new BorderLayout());

        JButton file_load_Button = new JButton("load file(unlock)");
        file_load_Button.addActionListener(new Load_File());
        
        this.add(file_load_Button,BorderLayout.WEST);
        this.add(file_path,BorderLayout.CENTER);
    }

    private class Load_File implements ActionListener{
        public void actionPerformed(ActionEvent e){
                //file load box
            JFrame window = new JFrame();
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(window);
            if(result==JFileChooser.APPROVE_OPTION){
                File selectFile = fileChooser.getSelectedFile();
                
                //파일 경로@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                file_path.setText(selectFile.toString());
            }
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
       
        setSize(500, 150);
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


JTextArea myPanel = new JTextArea();
myPanel.setDropTarget(new DropTarget() {
    public synchronized void drop(DropTargetDropEvent evt) {
        try {
            evt.acceptDrop(DnDConstants.ACTION_COPY);
            List<File> droppedFiles = (List<File>)
                evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
            for (File file : droppedFiles) {
                // process files
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
});


public class project {
    public static void main(String args[]){
        new GUI();
    }    
}

