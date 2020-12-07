import java.util.Arrays;
import java.util.List;

class Troll extends ItemType {
    Troll() {
        super(Arrays.asList("Troll lurks in the shadows.",
        "Troll is getting hungry.",
        "Troll is VERY hungry.",
        "Troll is SUPER HUNGRY and is about to ATTACK!",
        "Troll attacks!"));  
    }

    Troll(List<String> item) {
        super(item);
    }

    Troll tick() {
        return new Troll(super.changeState());
    }

    @Override 
    public String toString() {
        return getItem().get(0);
    }
}
    
