Lazy<Integer> one, two, three
one = Lazy.of(1) 
two = Lazy.of(2)
three = Lazy.of(3)
two.compareTo(one)
one.compareTo(three)
three.compareTo(three)
two.compareTo(one).test(c -> c > 0).get()
one.compareTo(three).test(c -> c < 0).get()
three.compareTo(three).test(c -> c == 0).get()
/exit
