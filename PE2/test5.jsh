new Room("dining").add(new Candle()).add(new Sword())
new Room("dining").add(new Candle()).add(new Sword()).go(x -> new Room("mystery", x))
new Room("dining").add(new Candle()).tick().add(new Sword()).go(x -> new Room("mystery", x))
new Room("foyer").add(new Sword()).tick(takeSword).go(x -> new Room("dining").add(new Candle()))
Room r1 = new Room("foyer").add(new Candle())
Room r2 = r1.go(x -> new Room("library").add(new Sword()))
Room r3 = r2.go(x -> new Room("dining").add(new Troll()))
r3.tick(killTroll)
r2.tick(takeSword).go(x -> new Room("dining").add(new Candle()).add(new Troll()))
r2.tick(takeSword).go(x -> new Room("dining").add(new Candle()).add(new Troll())).tick(killTroll)
r1.go(x -> new Room("library").
add(new Sword()).
tick(takeSword).
go(y -> new Room("dining").add(new Candle()).add(new Troll()))).tick(killTroll)
/exit

