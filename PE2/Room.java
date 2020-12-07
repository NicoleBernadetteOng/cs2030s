import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.function.Function;
import java.util.Optional;

class Room {
    private final String name;
    private final List<ItemType> state;
    private final boolean swordHeld;
    private final Optional<Room> prevRoom;

    Room(String n) {
        this.name = n;
        this.state = new ArrayList<>();
        this.swordHeld = false;
        this.prevRoom = Optional.empty();
    }

    Room(String n, List<ItemType> i) {
        this.name = n;
        this.state = i;
        this.swordHeld = false;
        this.prevRoom = Optional.empty();
    }

    Room(String n, List<ItemType> i, boolean s, Optional<Room> p) {
        this.name = n;
        this.state = i;
        this.swordHeld = s;
        this.prevRoom = p;
    }

    String getName() {
        return name;
    }

    List<ItemType> getItems() {
        return state;
    }

    Optional<Room> getPrevRoom() {
        return prevRoom;
    }

    boolean swordHeld() {
        return swordHeld;
    }

    boolean swordAvailable() {
        return state.stream().anyMatch(x -> x instanceof Sword);
    }

    boolean haveTroll() {
        return state.stream().anyMatch(x -> x instanceof Troll);
    }

    Room removeTroll() {
        return new Room(name, state.stream().filter(x -> !(x instanceof Troll)).collect(Collectors.toList()), swordHeld, prevRoom);
    }

    // for removing from previous room when you leave with the sworld held
    Room removeSword() {
        return new Room(name, state.stream().filter(x -> !(x instanceof Sword)).collect(Collectors.toList()), swordHeld, prevRoom);
    }

    Room takeSword() {
        return new Room(name, state, true, prevRoom);
    }

    Room dropSword() {
        return new Room(name, state, false, prevRoom);
    }

    Room add(ItemType item) {
        List<ItemType> newList = new ArrayList<>(state);
        newList.add(item);
        return new Room(name, newList, swordHeld, prevRoom);   
    }

    Room insert(boolean f) {
        List<ItemType> i = new ArrayList<>(state);
        i.add(f ? 0 : i.size(), new Sword());
        return new Room(name, i, swordHeld, prevRoom);
    }

    Room tick() {
        List<ItemType> newList = new ArrayList<>();
        for (ItemType i : state) {
            newList.add(i.tick());
        }
        return new Room(name, newList, swordHeld(), getPrevRoom());
    }

    Room tick(Function<Room, Room> func) {
        // System.out.println(func.apply(this).tick().swordHeld());
        return func.apply(this).tick();
    }

    // - You removed sword from previous room when entering next room
    public Room go(Function<List<ItemType>, Room> func) {
        state.removeIf(x -> swordHeld && x instanceof Sword);
        Room n = func.apply(state);
        if (swordHeld) {
            n = n.takeSword().insert(true);
        }
        return new Room(n.name, n.state, n.swordHeld, Optional.of(this.tick()));
    }
    
    Room back() {
        // System.out.println("this.state: " + this.state);
        Room n = this.prevRoom.orElse(this);
        return swordHeld ? n.takeSword().insert(false) : n.dropSword().removeSword();
    }

    @Override 
    public String toString() {
        if (state.isEmpty()) {
            return "@" + this.name ;
        } else {
            return "@" + this.name + "\n" + 
                this.state.stream().map(x -> x.toString())
                .collect(Collectors.joining("\n")).trim();
        }   
    }
}

