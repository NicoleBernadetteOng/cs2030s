Function<Room, Room> takeSword = room -> {
    if (room.swordAvailable() && !room.swordHeld()) {
        System.out.println("--> You have taken sword.");
        return room.takeSword();
    } else if (room.swordHeld()) {
        System.out.println("--> You already have sword.");
    } else {
        System.out.println("--> There is no sword.");
    }
    return room;
}

Function<Room, Room> killTroll = room -> {
    if (!room.haveTroll()) {
        System.out.println("--> There is no troll");
    } else if (!room.swordHeld()) {
        System.out.println("--> You have no sword.");
    } else {
        System.out.println("--> Troll is killed.");
        return room.removeTroll();
    }
    return room;
}

Function<Room, Room> dropSword = room -> {
    System.out.println("--> You have dropped sword.");
    return new Room(room.getName(), room.getItems(), false, room.getPrevRoom());
}
