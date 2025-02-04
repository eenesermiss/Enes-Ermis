package satproje.controller.frame.button;

import satproje.listener.showMessage;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import static satproje.controller.frame.reloadTablo.reload;
import static satproje.database.config.jdbcTemplate;
import static satproje.listener.veriables.*;


public class removeButton {

    public static JButton removeButton(ArrayList fieldNames, String process, String tabloSql) {
        JButton button = new JButton("Veriyi Sil");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Sql Sorgumuz
                String sql = "DELETE FROM " + tabloName(process) + " WHERE id = ?";

                // Secilen stün alıyoruz
                int selectedRow = table.getSelectedRow();

                // Eğer Seçildiyse...
                if (selectedRow != -1) {
                    // Stün 0. indexi İd olduğu için 0. İndexi alıyoruz..
                    int id = Integer.parseInt(tableModel.getValueAt(selectedRow, 0).toString());
                    //Sql sorgumuzu çalıştırdık..
                    jdbcTemplate.update(sql, id);
                    showMessage.main("Veri tablodan silindi.");
                    reload(fieldNames, tabloSql);
                } else {
                    showMessage.main("Lütfen tablodan bir veri seçin.");
                }
            }
        });
        return button;
    }


    private static String tabloName(String Process) {

        if (Process.equals("academic_program_episode") || Process.equals("academic_program_teacher")) {
            Process = "academic_program";
        }
        return Process;
    }
}