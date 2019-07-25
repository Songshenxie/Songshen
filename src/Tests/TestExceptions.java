package Tests;

import Exceptions.InputNullException;
import Exceptions.NothingInFileException;
import org.junit.Test;
import ui.LockerGame;
import ui2.AbstractMode;
import ui2.EasyMode;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.fail;

public class TestExceptions {
    @Test
    public void TestTxtEmpty () {
        LockerGame play = new LockerGame();
        JTextField txt = new JTextField(40);
        JTextField txt2 = new JTextField(40);
        AbstractMode mode = new EasyMode();
        txt.setText("");
        try {
            play.GetDecipheredNumber(txt,txt2,mode);
        } catch (InputNullException e2) {
        }
    }
    @Test
    public void TestTxtNotEmpty () {
        LockerGame play = new LockerGame();
        JTextField txt = new JTextField(40);
        JTextField txt2 = new JTextField(40);
        AbstractMode mode = new EasyMode();
        txt.setText("702848363");
        try {
            play.GetDecipheredNumber(txt,txt2,mode);
        } catch (InputNullException e2) {
            fail("Here shouldn't happen!");
        }
    }
    @Test
    public void TestEmptyFile () {
        File file = new File("outputfile.txt");
        LockerGame play = new LockerGame();
        try {
            List<String> lines = Files.readAllLines(Paths.get(file.getName()));
            play.GetHistory(lines);
        } catch (NothingInFileException e3) {
            fail("Here shouldn't happen!");
        }
        catch (IOException e) {
            fail("Here shouldn't happen!");
        }
    }
    @Test
    public void TestNonEmptyFile () {
        File file = new File("anotheroutputfile.txt");
        LockerGame play = new LockerGame();
        try {
            List<String> lines = Files.readAllLines(Paths.get(file.getName()));
            play.GetHistory(lines);
            fail("I was not expecting nothing in the empty file!");
        } catch (NothingInFileException e3) {
        }
        catch (IOException e) {
            fail("Here shouldn't happen!");
        }
    }
    @Test
    public void TestNonExistenceFile () {
        File file = new File("Nooutputfile.txt");
        LockerGame play = new LockerGame();
        try {
            List<String> lines = Files.readAllLines(Paths.get(file.getName()));
            play.GetHistory(lines);
            fail("I was not expecting no file!");
        } catch (NothingInFileException e3) {
            fail("!");
        }
        catch (IOException e) {
        }
    }
}
