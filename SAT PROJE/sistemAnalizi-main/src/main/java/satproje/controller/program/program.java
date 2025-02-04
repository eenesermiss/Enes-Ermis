package satproje.controller.program;

import satproje.controller.program.node.availablesEpisode;
import satproje.controller.program.node.availablesRoom;
import satproje.controller.program.node.availablesTeacher;
import satproje.controller.program.node.nodeLesson;

import static satproje.controller.program.start.starlend;
import static satproje.database.config.jdbcTemplate;

public class program {
    public static void main(){
        // Academic programı sıfırlıyoruz
        String sql = "delete from academic_program";
        jdbcTemplate.execute(sql);
        // Öğretmen müsaitlikleri güncelle
        availablesTeacher teacher = new availablesTeacher();
        teacher.main();
        // Classroom'ları müsaitliği ekle
        availablesRoom room = new availablesRoom();
        room.main();
        // Bölümleri'lerin müsaitliğini ekle
        availablesEpisode episode = new availablesEpisode();
        episode.main();
        // Lesson bilgilerini al
        nodeLesson lesson = new nodeLesson();
        lesson.main();
        // Başlaa....
        starlend();
    }
}
