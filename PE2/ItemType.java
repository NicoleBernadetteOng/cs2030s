import java.util.List;

abstract class ItemType {
    private final List<String> item;

    ItemType(List<String> item) {
        this.item = item;
    }

    abstract ItemType tick();

    List<String> getItem() {
        return this.item;
    }

    List<String> changeState() {
        if (this.item.size() == 1) {
            return this.item;
        } 
        return this.item.subList(1, this.item.size());
    }

    @Override 
    public String toString() {
        return this.item.get(0);
    }
}
