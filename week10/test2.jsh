Supplier<String> s = () -> "123456" 
Lazy<String> lazy = Lazy.of(s)
lazy.map(str -> str.substring(0, 1))
lazy.get()
lazy = lazy.map(str -> str.substring(0, 3))
lazy.get()
Function<String,String> substr = str -> {
System.out.println("substring");
return str.substring(0, 1);
}
lazy = lazy.map(substr)
lazy.get()
lazy.get()
Lazy<Integer> lazy = Lazy.of(10)
lazy = lazy.map(i -> i + 1)
lazy = lazy.flatMap(j -> Lazy.of(j + 3))
lazy
lazy.get()
lazy
/exit
