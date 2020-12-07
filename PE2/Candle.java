import java.util.Arrays;
import java.util.List;

class Candle extends ItemType {
    Candle() {
        super(Arrays.asList("Candle flickers.",
        "Candle is getting shorter.",
        "Candle is about to burn out.",
        "Candle has burned out."));   
    }

    Candle(List<String> item) {
        super(item);
    }

    Candle tick() {
        return new Candle(super.changeState());
    }

    @Override 
    public String toString() {
        return getItem().get(0);
    }
}
    
