package satproje.controller.program.data;

import satproje.controller.program.node.availablesEpisode;
import satproje.controller.program.node.availablesRoom;
import satproje.controller.program.node.availablesTeacher;

import java.util.ArrayList;

import static satproje.controller.program.node.availablesEpisode.FinishEpisodeNode;
import static satproje.controller.program.node.availablesRoom.FinishRoomNode;
import static satproje.controller.program.node.availablesTeacher.FinishTeacherNode;

public class dataGet {

    public static ArrayList getNodeTeacher(Object Teacher) {

        availablesTeacher active = FinishTeacherNode;

        while (!active.Teacher.equals(Teacher)) {
            active = active.last;
        }

        System.out.println("Active Teacher " + active.Teacher);

        return active.Days;
    }

    public static ArrayList getNodeEpisode(Object Episode) {
        availablesEpisode active = FinishEpisodeNode;
        while (!active.Episode.equals(Episode)) {
            active = active.last;
        }
        return active.Days;
    }

    public static ArrayList getNodeClassroom(int Classroom, int Type) {
        availablesRoom active = FinishRoomNode;

        while (!(active.Room.equals(Classroom) && active.Custom == Type)) {
            active = active.last;
        }
        System.out.println("Active Room " + active.Room + " Active Custom " + active.Custom);
        return active.Days;
    }


}
