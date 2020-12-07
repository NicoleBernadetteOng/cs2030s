/open Lazy.java
Lazy<Integer> five, ten, fifty, hundred
ten = Lazy.of(10)
five = Lazy.of(5)
// combine (same types)
BiFunction<Integer,Integer,Integer> add = (x, y) -> {
System.out.println("combine");
return x + y;
}
fifty = five.combine(ten, (x, y) -> x * y)
fifty
hundred = fifty.combine(fifty, add)
hundred
// combine (different types)
BiFunction<Integer,Double,String> f = (x, y) -> Integer.toString(x) + " " + Double.toString(y)
Lazy<String> s = Lazy.of(10).combine(Lazy.of(0.01), f)
s
s.get()
/exit
