package satproje.controller.frame;

import satproje.controller.frame.config.getColumnList;
import satproje.controller.frame.config.tableComboBox;
import satproje.database.returnListe;

import java.util.ArrayList;
import java.util.Vector;

import static satproje.listener.veriables.*;

public class reloadTablo {
    /**
     * Yeniden yükleme işlemlerini gerçekleştiren bir yardımcı sınıf.
     */
    public static void reload(ArrayList fieldNames, String tabloSql) {

        // Sütun isimlerini al
        ArrayList columnList = getColumnList.main(fieldNames);
        // SQL tablosundan veri al
        ArrayList loadArryList = returnListe.main(tabloSql);
        // Tablo modelinin satır sayısını sıfırla
        tableModel.setRowCount(0);
        // Verileri tabloya ekle
        for (int i = 0; i < loadArryList.size(); i = i + columnList.size()) {
            Vector<Object> row = new Vector<>();
            for (int j = 0; j < columnList.size(); j++) {
                String field = (String) columnList.get(j);
                row.add(tableComboBox.main(field, loadArryList.get(j + i)));
            }
            tableModel.addRow(row);
        }
    }
}
