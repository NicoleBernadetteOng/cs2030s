import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Schedule {
    private final List<Lesson> lessonList;
    
    public Schedule() {
        lessonList = new ArrayList<>();
    }

    public Schedule(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public Schedule add(Lesson lesson) {
        //List<Lesson> newList = new ArrayList<>();

        for (Lesson l : this.lessonList) {
            //newList.add(l);

            if (l.clashWith(lesson)) {
                return this;
            } 
        }
        
        // new list 
        List<Lesson> newList = new ArrayList<Lesson>(this.lessonList);
        newList.add(lesson);
        return new Schedule(newList);
    }


    @Override 
    public String toString() {
        Collections.sort(this.lessonList, new Comparator<Lesson>() {
            @Override
            public int compare(Lesson lessonOne, Lesson lessonTwo) {
                if (((Integer)lessonOne.getStartTime()).equals(lessonTwo.getStartTime())) {
                    if (lessonOne.getModuleCode().equals(lessonTwo.getModuleCode())) {
                        return ((Integer)lessonOne.getClassId()).compareTo(lessonTwo.getClassId());
                    } else {
                        return ((String)lessonOne.getModuleCode()).compareTo(lessonTwo.getModuleCode());
                    }
                } else {
                    return ((Integer)lessonOne.getStartTime()).compareTo(lessonTwo.getStartTime());
                }
            }
        });
        
        String string = "";
        for (Lesson lesson : lessonList) {
            string += lesson.toString() + "\n"; 
        }
        return string;
    }

}

