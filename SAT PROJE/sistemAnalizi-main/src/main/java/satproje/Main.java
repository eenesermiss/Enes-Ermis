package satproje;

import satproje.controller.frame.createFrame;
import satproje.database.notExits;

import java.util.ArrayList;

    public class Main {
     public static void main(String[] args) {

         notExits.main();
            // Database bağlama menüsü açar.

            // Framename Menü adı
            // SizeX ve SizeY Menülerin boyutu
            // String dizisinin içinde oluşacak label ve fieldlar.
            // rows ise field alt alta kaçar sıralanacağı.
            // Process işlem kodu
            // FrameType buton ve işlem türü
            // TabloSql ise tabloda sql sorgusu


            ArrayList deneme = new ArrayList();

            deneme.add("Username");
            deneme.add("Password");


            createFrame.main("Kullanıcı giriş ekranı", 400 , 175, deneme,
                    3,
                    "login", " ");


        }
    }