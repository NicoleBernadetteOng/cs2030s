UnaryOperator<Integer> op = x -> {
System.out.println("op called");
return x + 1;
}
LazyList<Integer> list = LazyList.generate(10000, 0, op)
list.get(0)
list.get(5)
list.indexOf(2)
list.indexOf(10)
list.get(7)
list.get(12)
/exit
