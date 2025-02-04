package satproje.database.notTable;

import static satproje.database.config.jdbcTemplate;

public class times {
    public static void main() {
        String sql = "CREATE TABLE IF NOT EXISTS Times (" +
                "    id INT AUTO_INCREMENT PRIMARY KEY," +
                "    Number VARCHAR(255) NOT NULL," +
                "    Type VARCHAR(255) NOT NULL," +
                "    Start VARCHAR(255) NOT NULL," +
                "    Finish VARCHAR(255) NOT NULL" +
                ");";
        jdbcTemplate.execute(sql);
    }
}