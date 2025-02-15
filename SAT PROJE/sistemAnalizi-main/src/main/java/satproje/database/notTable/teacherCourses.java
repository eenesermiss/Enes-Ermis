package satproje.database.notTable;

import static satproje.database.config.jdbcTemplate;

public class teacherCourses {
    public static void main() {
        String sql = "CREATE TABLE IF NOT EXISTS teacherCourses("
                + "id INT AUTO_INCREMENT PRIMARY KEY,"
                + "Teacher INT NOT NULL,"
                + "Code VARCHAR(15) NOT NULL,"
                + "Lesson INT NOT NULL,"
                + "FOREIGN KEY (Teacher) REFERENCES Teacher(id) ON DELETE CASCADE,"
                + "FOREIGN KEY (Lesson) REFERENCES Lesson(id) ON DELETE CASCADE,"
                + "UNIQUE (Teacher, Lesson)"
                + ")";
        jdbcTemplate.execute(sql);
    }
}
