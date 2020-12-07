Lazy<Integer> fifty = Lazy.of(50)
Lazy<Boolean> even = fifty.test(i -> i % 2 == 0)
even
even.get()
even
// equals
fifty.equals(Lazy.of(5).map(i -> i * 10))
fifty.equals(50)
even.equals(Lazy.of(true))
/exit
