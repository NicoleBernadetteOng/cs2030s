import java.util.Arrays;
import java.util.List;

class Sword extends ItemType {
    Sword() {
        super(Arrays.asList("Sword is shimmering."));
    }

    Sword(List<String> item) {
        super(item);
    }

    Sword tick() {
        return new Sword(super.changeState());
    }

    @Override
    public String toString() {
        return getItem().get(0);
    }
}

