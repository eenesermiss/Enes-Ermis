package satproje.controller.frame.button;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static satproje.listener.veriables.frame;
import static satproje.view.opMenu.opPermission;

public class backButton {
    public static JButton backButton() {
        JButton button = new JButton("Geri Git");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Frameyi kapatıp...
                frame.dispose();
                // Yeni pencereyi açıyoruz..
                opPermission();
            }
        });
        return button;
    }
}
