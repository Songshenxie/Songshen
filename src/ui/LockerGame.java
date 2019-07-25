package ui;

import Exceptions.InputNullException;
import Exceptions.NothingInFileException;
import ui2.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ui.SwingConsole.run;

public class LockerGame extends JFrame{
    private JButton b1 = new JButton("Easy");
    private JButton b2 = new JButton("Normal");
    private JButton b3 = new JButton("Hard");
    private JButton b4 = new JButton("I want to see the deciphered number!");
    private JButton b5 = new JButton("Take a look at the last number I tried!");
    private File file = new File("outputfile.txt");
    ModeController mode;
    ShowLevelAndResult ReallyCool;


    private JTextField txt = new JTextField(40);
    private JTextField txt2 = new JTextField(40);
    private JTextField txt3 = new JTextField(80);
    private ArrayList<String> lines = new ArrayList<String>();

    class ButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e){

            String Controller = ((JButton)e.getSource()).getText();
            if (!(Controller == "I want to see the deciphered number!") && !(Controller == "Take a look at the last number I tried!")) {
                try {
                    FileWriter writer = new FileWriter(file);
                    lines.add(txt.getText());
                    for (String String:lines
                         ) {
                        writer.write(String +"\n");
                    }
                    writer.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                } finally {
                    System.out.println("Successfully stored your series number: " +txt.getText());
                }
            SetText(Controller);
            }
            else if ((Controller == "I want to see the deciphered number!")){
                try {
                    GetDecipheredNumber(txt,txt2,mode);
                } catch (InputNullException e2) {
                    txt2.setText("No! You can't decipher before you have a series number!");
                }
            }
            else {
                try {
                    List<String> lines = Files.readAllLines(Paths.get(file.getName()));
                    GetHistory(lines);
                } catch (NothingInFileException e3) {
                    txt3.setText("Oops! It seems there is nothing in the file!");
                } catch (Exception e4) {
                    txt3.setText("You may not has a file called outputfile.txt! But don't worry, it is created now!");
                    try {
                        file.createNewFile();
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            }
        }
    }

    public void GetDecipheredNumber(JTextField TXT,JTextField TXT2,ModeController md) throws InputNullException {
        if (TXT.getText().equals("")) {
            throw new InputNullException();
        }
        else {TXT2.setText(md.DecipheredNumber());}
    }

    public void GetHistory(List<String> Lines) throws NothingInFileException {
        if (Lines.isEmpty()) {throw new NothingInFileException();}
        txt3.setText(Lines.get(Lines.size() - 1));//
    }

    private void SetText(String controller) {
        if (controller == "Easy") {
            mode = new EasyMode();
            ReallyCool = new EasyMode();
        }
        else if (controller == "Normal") {
            mode = new NormalMode();
            ReallyCool = new NormalMode();
        }
        else if (controller == "Hard") {
            mode = new HardMode();
            ReallyCool = new HardMode();
        }
        System.out.println(ReallyCool.PrintLevel());
        txt.setText(Integer.toString(mode.GenerateSeriesNumber()));
        txt.setEditable(false);
        txt2.setEditable(false);
        txt3.setEditable(false);
    }

    private ButtonListener bl = new ButtonListener();
    public LockerGame() {
        b1.addActionListener(bl);
        b2.addActionListener(bl);
        b3.addActionListener(bl);
        b4.addActionListener(bl);
        b5.addActionListener(bl);
        setLayout(new GridLayout(11,1));
        add(b1);
        add(b2);
        add(b3);
        add(txt);
        add(b4);
        add(txt2);
        add(b5);
        add(txt3);
    }
    public static void main(String[] args) {
        run(new LockerGame(),600,600);
    }
}
