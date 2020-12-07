Schedule s = new Schedule().
add(new Lecture("CS2030", 1, "LT19", new Instructor("hchia"), 10)).
add(new Tutorial("CS2030", 1, "SR7", new Instructor("tsim"), 12)).
add(new Lecture("CS2030", 2, "LT19", new Instructor("hchia"), 16)).
add(new Lecture("CS2040", 1, "I3-AUD", new Instructor("tanst"), 15)).
add(new Tutorial("CS2030", 4, "SR8", new Instructor("ehan"), 15)).
add(new Tutorial("CS2030", 3, "SR7", new Instructor("dlee"), 15)).
add(new Tutorial("CS2030", 2, "SR7", new Instructor("hchia"), 14))
System.out.println(s)
List<Constraint> constraints = List.of(new HchiaLunch(), new GapBetweenLectures());
List<Boolean> results = new ArrayList<>();
for (Constraint c : constraints) {
    results.add(c.test(s));
}
results
/exit
