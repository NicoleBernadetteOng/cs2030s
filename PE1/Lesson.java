public abstract class Lesson {
    private final String moduleCode;
    private final int classId;
    private final String venueId;
    // startTime cannot be before 8 or after 23
    private final int startTime;
    // private final int duration = 2; // Lecture is 2
    private final Instructor instructor;

    public Lesson(String moduleCode, int classId, String venueId,
            Instructor instructor, int startTime) {
        this.moduleCode = moduleCode;
        this.classId = classId;
        this.venueId = venueId;
        this.instructor = instructor;
        this.startTime = startTime;
    }

    public String getModuleCode() {
        return this.moduleCode;
    }

    public Instructor getInstructor() {
        return this.instructor;
    }

    public int getClassId() {
        return this.classId;
    }

    public String getVenue() {
        return this.venueId;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public boolean hasSameModule(Lesson otherLesson) {
        if (this.moduleCode == otherLesson.getModuleCode()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasSameInstructor(Lesson otherLesson) {
        if (this.instructor.equals(otherLesson.getInstructor())) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasSameVenue(Lesson otherLesson) {
        if (this.venueId == otherLesson.getVenue()) {
            return true;
        } else {
            return false;
        }
    }

    public abstract boolean clashWith(Lesson otherLesson);

}

