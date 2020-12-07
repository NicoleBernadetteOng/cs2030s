public class Instructor {
    private final String name;

    public Instructor(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    @Override 
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Instructor)) {
            return false;
        }
        
        Instructor instructorObj = (Instructor) object;
        return this.name.equals(instructorObj.name);
    }

    @Override 
    public String toString() {
        return this.name;
    }

}

