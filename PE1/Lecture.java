import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class Lecture extends Lesson {
    public Lecture(String moduleCode, int classId, String venueId, 
            Instructor instructor, int startTime) {
        super(moduleCode, classId, venueId, instructor, startTime);
    }

    // =================================================================
    
    /*public String getModuleCod() {
        return this.getModuleCode();
    }

    public Instructor getInstructo() {
        return this.getInstructor();
    }

    public String getVenu() {
        return this.getVenue();
    }

    public int getStartTim() {
        return this.getStartTime();
    }


    public boolean hasSameModul(Lesson otherLecture) {
        if (this.getModuleCode() == otherLecture.getModuleCode()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean asSameModule(Lesson otherTutorial) {
        if (this.getModuleCode() == otherTutorial.getModuleCode()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasSameInstructo(Lesson otherLecture) {
        if (this.getInstructor().equals(otherLecture.getInstructor())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean asSameInstructor(Lesson otherTutorial) {
        if (this.getInstructor().equals(otherTutorial.getInstructor())) {
            return true;
        } else {
            return false;
        }

    }


    public boolean hasSameVenu(Lesson otherLecture) {
        if (this.getVenue() == otherLecture.getVenue()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean asSameVenue(Lesson otherTutorial) {
        if (this.getVenue() == otherTutorial.getVenue()) {
            return true;
        } else {
            return false;
        }
    }*/

    // public boolean clashWit(Lesson otherLecture) {
    //     int thisEndTime = this.getStartTime() + 2;
    //     int otherLectureStartTime = otherLecture.getStartTime();
    //     int otherLectureEndTime = otherLectureStartTime + 2;

    //     if (this.getStartTime() == otherLectureStartTime) {
    //         return true;
    //     } else if (thisEndTime <= otherLectureStartTime) {
    //         return false;
    //     } else if (this.getStartTime() >= otherLectureEndTime) {
    //         return false;
    //     } else {
    //         return true;
    //     }
    // }

    // public boolean lashWith(Lesson otherTutorial) {
    //     int thisEndTime = this.getStartTime() + 2;
    //     int otherTutorialStartTime = otherTutorial.getStartTime();
    //     int otherTutorialEndTime = otherTutorialStartTime +1;

    //     if (this.getStartTime() == otherTutorialStartTime) {
    //         return true;
    //     } else if (this.getStartTime() >=  otherTutorialEndTime) {
    //         return false;
    //     } else if (thisEndTime <= otherTutorialStartTime) {
    //         return false;
    //     } else {
    //         return true;
    //     }
    // }
    // =================================================================

    // CLASH WITH METHOD - takes in a lecture 
    public boolean clashWith(Lesson otherLesson) {
        int thisEndTime = this.getStartTime() + 2;

        if (otherLesson instanceof Lecture) {
            int otherLectureStartTime = otherLesson.getStartTime();
            int otherLectureEndTime = otherLectureStartTime + 2;

            if (this.getStartTime() == otherLectureStartTime) {
                // if same time, cannot same instructor
                // cannot same venue, cannot same module 
                if (this.hasSameInstructor(otherLesson)) {
                    return true;
                } else if (this.hasSameVenue(otherLesson)) {
                    return true; 
                } else if (this.hasSameModule(otherLesson)) {
                    return true;
                } else {
                    return false;
                }
            } else if (thisEndTime <= otherLectureStartTime) {
                return false;
            } else if (this.getStartTime() >= otherLectureEndTime) { 
                return false;
            } else {
                if (this.hasSameModule(otherLesson)) {
                    return true;
                } else {
                    return false;
                }
            }
        } else {
            int otherTutorialStartTime = otherLesson.getStartTime();
            int otherTutorialEndTime = otherTutorialStartTime +1;

            if (this.getStartTime() == otherTutorialStartTime) {
                if (this.hasSameInstructor(otherLesson)) {
                    return true;
                } else if (this.hasSameVenue(otherLesson)) {
                    return true;
                } else if (this.hasSameModule(otherLesson)) {
                    return true;
                } else {
                    return false; 
                }
            } else if (this.getStartTime() >=  otherTutorialEndTime) {
                return false;
            } else if (thisEndTime <= otherTutorialStartTime) {
                return false;
            } else {
                if (this.hasSameModule(otherLesson)) {
                    return true;
                } else {
                    return false;
                }
            }
        }

    }

    @Override 
    public String toString() {
        int endTime = this.getStartTime() + 2;

        return this.getModuleCode() + " L" + this.getClassId() + " @ " + this.getVenue() + " [" +
            this.getInstructor().getName() + "] " + this.getStartTime() + "--" + endTime;
    }

}
