Lazy<Integer> eight = Lazy.of(8)
eight
eight.get()
eight
Supplier<String> s = () -> "hello"
Lazy<String> hello = Lazy.of(s)
hello
hello.get()
s = () -> { System.out.println("world!"); return "hello"; }
Lazy<String> hello = Lazy.of(s)
hello
hello.get()
// check that "world!" should not be printed again.
hello.get()
Random rng = new Random(1)
Supplier<Integer> r = () -> rng.nextInt()
Lazy<Integer> random = Lazy.of(r)
// check that random value should not be available
random
// check that random value is obtained only once
random.get().equals(random.get())
// exception thrown when passing a null to of()
Supplier<Integer> si = null
try { Lazy.of(si); } catch(Exception e) { System.out.println(e); }
// passing a supplier of null to of()
si = () -> null
Lazy<Integer> lazy = Lazy.of(si)
// exception thrown when get() is called
try { lazy.get(); } catch(Exception e) { System.out.println(e); }
/exit
