package satproje.controller.frame.button;

import org.springframework.dao.EmptyResultDataAccessException;
import satproje.controller.frame.createFrame;
import satproje.listener.showMessage;
import satproje.view.opMenu;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import static satproje.database.config.jdbcTemplate;
import static satproje.listener.TextFieldEntry.findTextFieldEntry;
import static satproje.listener.veriables.*;

public class loginButton {

    public static JButton loginButton() {

        JButton button = new JButton("Giriş Yap");

        // Login butonuna tıklama fonksiyonu ekliyoruz
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                login();
            }
        });

        // Kullanıcı adı ve şifre alanlarına Enter tuşu dinleyicisi ekliyoruz
        findTextFieldEntry("Username").getTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Eğer Enter tuşuna basarsa login() fonksiyonunu çalıştırır.
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });

        findTextFieldEntry("Password").getTextField().addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                // Eğer Enter tuşuna basarsa login() fonksiyonunu çalıştırır.
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    login();
                }
            }
        });

        return button;
    }

    private static void login() {
        // Field verilerdeki bilgileri alıyoruz
        String username = findTextFieldEntry("Username").getTextField().getText();
        String password = findTextFieldEntry("Password").getTextField().getText();

        // Boş değilse...
        if (!username.isEmpty() && !password.isEmpty()) {
            // Burada böyle username ve password varmı diye kontrol sağlıyoruz
            if (verify(username, password)) {
                frame.dispose();

                switch (getOpValueByUsername(username)) {
                    case 0:
                        // Öğretmen için pencere açıyoruz
                        String usernameSql = "SELECT id FROM Teacher Where username = ?";
                        int id = jdbcTemplate.queryForObject(usernameSql, Integer.class, username);
                        ArrayList fieldName = new ArrayList();
                        fieldName.add("jComboBoxEpisode");
                        fieldName.add("jComboBoxLessons");
                        fieldName.add("jComboBoxTeacher");
                        fieldName.add("jComboBoxDay");
                        fieldName.add("jComboBoxLessonTime");
                        fieldName.add("jComboBoxClassroom");
                        fieldName.add("Lesson_Code");
                        fieldName.add("Classroom_Number");

                        String tabloSql = "Select id, Episode, Lessons, Teacher, Day, LessonTime, Classroom, Lesson_Code, Classroom_Number" +
                                " from academic_program Where Teacher = '"+ id + "' ORDER BY Episode";
                        createFrame.main(username + " - Öğretmen Ders Programı", 1000, 600, fieldName, 4,
                                "loginUsername", tabloSql );
                        break;
                    case 1:
                        // Admin menüsüne yönlendiriyoruz
                        opMenu.opPermission();
                        break;
                }
            } else {
                showMessage.main("Kullanıcı adı veya şifreniz hatalı.");
            }
        } else {
            showMessage.main("Lütfen boş bırakmayın.");
        }
    }

    // Eğer username ve password 0 tane varsa haliyle kullanıcı yoktur.
    public static boolean verify(String username, String password) {
        String sql = "SELECT COUNT(*) FROM Teacher WHERE Username = ? AND Password = ?";
        return 0 != jdbcTemplate.queryForObject(sql, Integer.class, username, password);
    }

    // Kullanıcı türünü belirlemek için gerekli fonksiyon
    public static int getOpValueByUsername(String username) {
        String sql = "SELECT Op FROM Teacher WHERE Username = ?";
        try {
            return jdbcTemplate.queryForObject(sql, Integer.class, username);
        } catch (EmptyResultDataAccessException e) {
            return 0;
        }
    }
}

