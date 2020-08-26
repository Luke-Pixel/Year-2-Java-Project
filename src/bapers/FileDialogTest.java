package bapers;
import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

/** @see https://stackoverflow.com/questions/2914733 */
// testing code from source above mentioned in order to accesss files on comuter via java for backup and restoring the database
public class FileDialogTest {

    public static void main(String[] args) {
        final JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));
        frame.add(new JButton(new AbstractAction("Load") {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(frame, "Test", FileDialog.LOAD);
                fd.setFile("*.sql");
                fd.setVisible(true);
                File newFile = new File(fd.getFile());
                System.out.println(fd.getFile());
                System.out.println(newFile.getAbsolutePath());
            }
        }));
        frame.add(new JButton(new AbstractAction("Save") {

            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fd = new FileDialog(frame, "Test", FileDialog.SAVE);
                fd.setVisible(true);
                System.out.println(fd.getFile());
            }
        }));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}