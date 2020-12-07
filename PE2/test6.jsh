Room r1 = new Room("foyer").add(new Candle())
Room r2 = r1.go(x -> new Room("dining").add(new Troll()))
Room r3 = r2.go(x -> new Room("library").add(new Sword()))
r1
r2
r2.back()
r2.tick().tick().tick()
r2.tick().tick().tick().back()
r3
r3.back()
r3.back().back()
r3.tick(takeSword).back().tick(killTroll).back()
r3.tick(takeSword).back().tick(killTroll).tick(dropSword)
r3.tick(takeSword).back().tick(killTroll).tick(dropSword).back()
r1.go(x -> new Room("dining").add(new Troll())).
tick().
go(x -> new Room("library").add(new Sword())).
tick().
tick(takeSword).
back().
tick().
tick(killTroll)
/exit
