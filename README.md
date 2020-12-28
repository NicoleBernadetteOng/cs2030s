# CS2030S Notes
Programming Methodology II in NUS during the Academic year 2020/21 Semester 1

# Introduction 
Hello all! I was wildly confused about these topics when they were first introduced. Here are some resources that have helped me and I hope that they will be useful to you as well! 

***

# Get Started with Vim
- The [Unix 101: NUS SoC Workshop](https://nus-unix-workshop.github.io/2021-s1/) is very helpful.

***

# [Immutable Objects in Java](https://www.baeldung.com/java-immutable-object)
An immutable object is an object whose internal state remains constant after it has been entirely created. This means that the public API of an immutable object guarantees us that it will behave in the same way during its lifetime. An example of mutability (can change) is:
```java
String name = "i love cs2030?";
String newName = name.replace("?", "!");
```
In immutability, we shouldn't be able to change (set) the internal state of the object, we should only have read-only (get) methods. 

There is a common misconception about the distinction between **immutable** and `final` in java, which is that just because an object's variables are all final does not mean it is immutable. `final` means that you can't modify the object's **reference** to point to another reference or object, but its state can still be changed via Setter methods (e.g. setAge()). Whereas for immutability, the **actual values** for variables/Objects should not change (but it's reference can be changed). In order to enforce immutability, we have to create a new Object every time we want to change its values.

```java
class Student {
    private final String name;
    private final int age;

    public int setAge(int newAge) {this.age = newAge;} // violates immutability
    // ...
}
```



***

# [OOP Principles](https://stackify.com/oops-concepts-in-java/) 
<details>
<summary>Abstraction</summary>

## What is it?
- Abstraction means using simple things to represent complexity. For example, we all know how to eat cordon bleu, but we don’t need to know how to cook it in order to enjoy it.
- In Java, abstraction means simple things like objects, classes, and variables represent more complex underlying code and data. This prevents the codes from repeating the same work multiple times. 

## How it works 
- Abstraction as an OOP concept in Java works by letting programmers create useful, reusable tools. 
- For instance, a class of variable might be a student. The class might specify that each student object shall have a name, faculty, year, and contact number. The objects, in this case, might be science students, art students, or computing students etc.

</details>


<details>
<summary>Encapsulation</summary>

## What is it?
This is the practice of keeping fields within a class private, then providing access to them via public methods. It’s a protective barrier that keeps the data and code safe within the class itself. This way, we can re-use objects like code components or variables without allowing open access to the data system-wide.

</details>


<details>
<summary>Inheritance</summary>

## What is it?
It lets programmers create new classes that share some of the attributes of existing classes. This lets us build on previous work without reinventing the wheel.

## How it works 
It works by letting a new class adopt the properties of another. We call the inheriting class a subclass or a child class. The original class is often called the parent. We use the keyword extends to define a new class that inherits properties from an old class.

</details>


<details>
<summary>Polymorphism</summary>

## What is it?
This Java OOP concept lets programmers use the same word to mean different things in different contexts. One form of polymorphism in Java is method overloading. That’s when different meanings are implied by the code itself. The other form is method overriding. That’s when the different meanings are implied by the values of the supplied variables. (More on overloading and overriding later)

</details>


***

# [SOLID Object-Oriented Design Principles](https://www.jrebel.com/blog/solid-principles-in-java)
<details>
<summary>Single Responsibility Principle</summary>
A class should have one, and only one, reason to change. This means that every class, or similar structure, should have only one job to do. Everything in the class should be related to that single purpose, not that your classes should only contain one method or property. 

</details>


<details>
<summary>Open Closed Principle</summary>
You should be able to extend a classes behavior, without modifying it. You should design your classes such that new functionalities can be added as new requirements are generated. Also, you shouldn't modify the developed classes except to correct bugs. 

Generally you achieve this by referring to abstractions for dependencies (i.e. abstract classes or interfaces) rather than concrete classes. Functionality can be added by creating new classes that implement the interfaces. 

</details>



<details>
<summary>Liskov Substitution Principle</summary>
All subclasses must, therefore, operate in the same manner as their base classes. The specific functionality of the subclass may be different but must conform to the expected behaviour of the base class. To be a true behavioural subtype, the subclass must not only implement the base class’s methods and properties, but also conform to its implied behaviour. In general, if a subtype of the supertype does something that the client of the supertype does not expect, then this is in violation of LSP. 

A typical example that violates LSP is a Square class that derives from a Rectangle class. The Square class always assumes that the width is equal with the height. If a Square object is used in a context where a Rectangle is expected, unexpected behaviour may occur because the dimensions of a Square cannot (or rather should not) be modified independently.

</details>



<details>
<summary>Interface Segregation Principle</summary>
Make fine grained interfaces that are client specific. The Interface Segregation Principle (ISP) states that clients should not be forced to depend upon interface members they do not use. 

</details>


<details>
<summary>Dependency Inversion Principle</summary>
Depend on abstractions, not on concretions. DIP also allows us to test things in isolation, details like database are plugins to our system. For example: 

```java
public interface Reader { 
    char getchar(); 
}

public interface Writer { 
    void putchar(char c);
}

class CharCopier {
    void copy(Reader reader, Writer writer) {
        // ...
    }
}

public Keyboard implements Reader { ... }
public Printer implements Writer { ... }
```

</details>

***


# [Overriding vs. Overloading in Java](https://www.programcreek.com/2009/02/overriding-and-overloading-in-java-with-examples/)
- Overloading occurs when two or more methods in **one class** have the same method but different parameters. 
- Overriding means having two methods with the same method name and parameters (i.e. method signature). One of the methods is in the **parent class** and the other is in the **child class**. Overriding allows a child class to have its own specific implementation of a method that is already provided in the parent class. (e.g. toString methods). 


***

# [Inheritance and Composition](https://www.tutorialspoint.com/difference-between-inheritance-and-composition-in-java)
- Inheritance is an "is-a" relationship while Composition is a "has-a". Relationship 

## Example of Inheritance

```java
class Animal {
    String name = "Peter";
}
class Cat extends Animal {
    String type = "Cat";
    // ...
}
```

## Example of Composition

```java
public class Student {
}
public class NUS {
    private final Student student;
    public NUS(Student student) {
        this.student = student;
    }
}
```

***

# [Access Modifiers](https://www.javatpoint.com/access-modifiers)
- **Private**: The access level of a private modifier is only within the class. It cannot be accessed from outside the class.
- **Default**: The access level of a default modifier is only within the package (and class). It cannot be accessed from outside the package. If you do not specify any access level, it will be the default.
- **Protected**: The access level of a protected modifier is within the package and outside the package through child class. If you do not make the child class, it cannot be accessed from outside the package.
- **Public**: The access level of a public modifier is everywhere. It can be accessed from within the class, outside the class, within the package and outside the package.

***

# Concrete Classes, Abstract Classes, and Interfaces 
The article on the [Difference Between Interface and Abstract Class](https://javapapers.com/core-java/abstract-and-interface-core-java-2/difference-between-a-java-interface-and-a-java-abstract-class/) is very helpful. 
In summary, the main difference is methods of a Java interface are implicitly abstract and cannot have implementations. A Java abstract class can have instance methods that implement a default behaviour. Also, variables declared in a Java interface is by default final. An abstract class may contain non-final variables.

Java interface should be implemented using keyword “implements”; A Java abstract class should be extended using the keyword “extends”. An interface can extend another Java interface only, an abstract class can extend another Java class and implement multiple Java interfaces. A Java class can implement multiple interfaces but it can extend only one abstract class.

Example of an Interface
```java
interface Animal {
    public String animalSound();
    public void sleep();
}
```

***


# Generics & Collections 
A generic type is a type with formal type parameters. e.g. 
```java
interface Collection<E> {
    // ...
}
```
A parameterised type is an instantiation of a generic type with actual type arguments. e.g. 
```java
Collection<String> coll = new LinkedList<String>();
```


[Why do we need generics?](https://www.baeldung.com/java-generics) Take these lines of codes for example: 
```java
List list = new LinkedList();    
list.add(new Integer(1)); 
Integer i = list.iterator().next();
```
The compiler will have an issue with the last line because it doesn't know what data type is returned. The compiler will require an explicit casting:
```java
Integer i = (Integer) list.iterator().next();
```
While the code above isn't wrong, the casting can be cumbersome because we already know that the data type in the list is an Integer. It would be a lot more efficient if programmers could express their intention of using specific types and the compiler can just handle checking the correctness of the type. This is where generics come into play. 
We can change the first line in the code above by adding a `<>` containing the type:
```java
List<Integer> list = new LinkedList<>();
```
Put simply, generics force type safety in Java. Without generics, various bugs may only be revealed in runtime. With generics, the compiler highlights issues in compile time itself, making your code more robust and easier to debug and test. In summary, [generics add stability to your code by making more of your bugs detectable at compile time](https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/). 

<details>
<summary>Generic Classes or Interfaces</summary>

## What is it?

For example: 
```java
public class Entry<K, V> { 
    private K key;  
    private V value; 
 
    public Entry(K k, V v) {
        value = v;
        key = k;        
    }     
} 
```
To invoke the general class, we can do this for example: 
```java
Entry<Integer, String> myEntry = new Entry<Integer, String>(2, "two");
```
When harnessing the power of Java generics, you let the compiler do the checking work for you. for example: 
```java
List<String> names = new ArrayList<String>();
names.add("Megan");
names.add("Amy");
names.add(Boolean.FALSE); // compilation error!
```


</details>


<details>
<summary>Generic Methods</summary>

## What is it?
Generic methods are methods that can be called with arguments of different types. The compiler will ensure the correctness of whichever type is used. For example: 
```java
public <T> List<T> fromArrayToList(T[] a) {   
    return Arrays.stream(a).collect(Collectors.toList());
}
```



</details>


<details>
<summary>Generic Type Arrays</summary>
In Java, pushing any incompatible type in an array on runtime will throw `ArrayStoreException`. Java does not permit the instantiation of generic arrays. E.g. `public T[] array = new T[5];` causes a compiler error. 

Another reason why arrays do not support generics is that arrays are _covariant_. In Java, arrays are covariant (more on this later) which implies that an array of type T[] may contain elements of type T and its subtypes. It also implies that an array of type S[] is a subtype of T[] if S is a subtype of T.


</details>


<details>
<summary>Wildcards</summary>
In generic code, the question mark (?), called the wildcard, represented an unknown type. The wildcard can be used as the type of a parameter, field, or local variable and sometimes as a return type. Here are some examples: 

```java
Collection<?> coll = new ArrayList<String>(); 
List<? extends Number> list = new ArrayList<Long>(); 
Pair<String,?> pair = new Pair<String,Integer>();
```

Here are some invalid examples of the use of wildcard that will raise an error: 
```java
List<? extends Number> list = new ArrayList<String>();  // String is not subclass of Number
Comparator<? super String> comparator = new RuleBasedCollator(new Integer(10)); // Integer is not superclass of String
```

## Upper bounded wildcards 
Type parameters can be bounded, meaning "restricted". We can restrict types that can be accepted by the method. For example, say you want to write a method that works on List<String>, List<Integer>, and List<double> you can achieve this by using an upper bounded wildcard e.g. you would specify `List<? extends Number>`. Here Integer, Double are subtypes of Number class. In layman’s terms, if you want the generic expression to accept all subclasses of a particular type, you will use upper bound wildcard using **'extends'** keyword. Example:
```java
private Number sum(List<? extends Number> numbers){
      double s = 0.0;
      for (Number n : numbers)
         s += n.doubleValue();
      return s;
}
```

## Lower bounded wildcards
Let's say there are three classes: `SuperClass`, `ChildClass` and `GrandChildClass`. GrandChildClass is subtype of ChildClass and SuperClass as well. So any generic list of SuperClasses and ChildClasses is capable of holding GrandChildClasses as well. We can use lower bound wildcard using **'super'** keyword. Example:
```java
public static void addGrandChildren(List<? super GrandChildClass> grandChildren) {
    grandChildren.add(new GrandChildClass());
}
```

</details>


***

# Covariance and Contravariance
Is a List < Cat > a List < Animal > ? The answer is no, and here's why:
```java
List<Cat> cats = new List<Cat>();
List<Animal> animals = cats;
animals.add(new Dog());
Cat cat = cats.get(0); // Does not make sense
```
It's important to note that generics are invariant. With generic types, Java has no way of knowing at runtime the type information of the type parameters, due to type erasure.

To enforce covariance, we can make use of wildcards: 
```java
List<?> covList = new ArrayList<Animal>();
List<? extends Animal> covList = new ArrayList<Animal>(); // this means a List of objects that are instances of subclasses of Animal (e.g. Cat, Dog)
List<? super Animal> covList = new ArrayList<Animal>(); // this means the list is typed to either the Animal class or a superclass of Animal 
```
The third line above is not suitable for this example above but added here for completeness.


***

# Java's null value 
[Null Pointer References: The Billion Dollar Mistake]( https://medium.com/@hinchman_amanda/null-pointer-references-the-billion-dollar-mistake-1e616534d485) is a really interesting article regarding Java's null.


***

# [Reflection](https://www.geeksforgeeks.org/reflection-in-java/)
A Reflection (API) in Java allows us to get information about a class (could be an unknown object). Through reflection, we can also access the private variables and methods of a class with the help of its class object.
Some methods for reflection include: 
- `getClass()` method is used to get the name of the class to which an object belongs.
- `getConstructors()` method is used to get the public constructors of the class to which an object belongs.
- `getMethods()` method is used to get the public methods of the class to which an object belongs.

While reflection allows extensibility of features, it may cause an exposure to internals.
[Another useful link on Java Method Reflection.](https://www.baeldung.com/java-method-reflection)


***

# [Lambda Expressions](https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html)
```java
// Syntax 
// parameters -> statement-body
(x, y) -> x - y
(Integer x, Integer y) -> {return x - y;}

// single parameter 
x -> x * x

// no parameter
() -> System.out.println("Coding is rewarding!");
```

***

# Method Reference 
[Method References in Java 8](https://stackabuse.com/method-references-in-java-8/) is a helpful link. But in a nutshell, this is the syntax:

```java
// class-name::method-name 
top3("mod1", "mod2", "mod3", (x, y) -> x.compareTo(y));
// is equivalent to  
top3("mod1", "mod2", "mod3", String::compareTo);
```

***

# [Exception Handling](https://www.javatpoint.com/exception-handling-in-java)
- [Java NullPointerException – How to effectively handle null pointer in Java](https://howtodoinjava.com/java/exception-handling/how-to-effectively-handle-nullpointerexception-in-java/)
- [How to Specify and Handle Exceptions in Java](https://stackify.com/specify-handle-exceptions-java/)


***

# [HashMap](https://howtodoinjava.com/java-hashmap/)
HashMap allows us to store a key-value pair and lookup a value with the key.

If you thought that HashMap and ArrayList have similarities, and you'd like to know the differences, [Difference between ArrayList and HashMap in Java](https://www.java67.com/2012/08/difference-between-hashmap-and-ArrayList-in-Java.html) was pretty helpful.

In summary, here are just some of the key differences:
* ArrayList implements the List interface while HashMap implements the Map interface in Java. To understand the differences between Set, List, and Map, [this](https://www.java67.com/2013/01/difference-between-set-list-and-map-in-java.html) was useful.
* Another difference is that ArrayList only stores one object (per index) while HashMap stores two objects: a key and value pair. 
* ArrayList allows duplicates but HashMap doesn't allow duplicate keys, but allows duplicate values. 

```java
// PUT 
HashMap<Integer, String> hashMap = new HashMap<>();
hashMap.put(1, "A");
hashMap.put(2, "B");
hashMap.put(3, "C");

// GET
String value = hashMap.get(2);

// REMOVE
hashMap.remove(3);
```

## [HashSet](https://www.javatpoint.com/java-hashset) 
- HashSet stores the elements by using a mechanism called hashing. 
- HashSet contains unique elements only, no duplicates allowed.
- HashSet allows null value. 
- HashSet doesn't maintain the insertion order. 
- HashSet has been said to be one of the best approaches for search operations. 

```java
import java.util.HashSet;
HashSet<String> modules = new HashSet<String>();
modules.add("CS2030S");

// Check if an item exists 
modules.contains("CS2030S");

// To remove all items 
// modules.remove("CS2030S"); // to remove specific item
modules.clear();
```


## [hashCode()](https://www.baeldung.com/java-hashcode)
Another important part of HashMap is hashCode(). Multiple keys are allowed to have the same hashCode. 

Basically, hashCode() returns an integer value, generated by a hashing algorithm. Objects that are equal (according to equals()) must return the same hash code. 


***

# [Pre-defined Functional Interfaces](https://nus-cs2030.github.io/1718-s2/lec07/index.html)

<details>
<summary>Function</summary>

### Pure and Non-pure functions 

```java
// example of pure function - does not cause any side effect
int add(int i, int j) {
    return i + j;
}

// example of non-pure function 
void increaseCount(int i) {
    this.count += i; // does not return a value, has side effects on count
}
```


### Function Interface

```java
// a class that implements Function 
class Square implements Function<Integer, Integer> {
    public Integer apply(Integer x) {
        return x * x;
    }
}

int x = new Square().apply(4);

// another example 
List<Integer> applyList(List<Integer> list, Function<Integer,Integer> f) {
    List<Integer> newList = new ArrayList<Integer>();
    for (Integer i: list) {
        newList.add(f.apply(i));
    }
    return newList;
}

// with Lambda Expression 
Function<Integer, Integer> square = x -> x * x;

applyList(list, (Integer x) -> { return x * x; });
applyList(list, x -> { return x * x; });
applyList(list, x -> x * x);

// andThen

// compose

```

</details> 


<details>
<summary>BiFunction</summary>
A function that accepts two arguments and produces a result.

```java
// takes two Integers and return an Integer
BiFunction<Integer, Integer, Integer> func = (x1, x2) -> x1 + x2;
```

</details> 


<details>
<summary>Predicate</summary>
A function that returns true or false. 

```java
Predicate<Integer> isEven = x -> (x % 2) == 0; 
```

</details> 


<details>
<summary>Supplier</summary>
Supplier is a function that does not take in any argument but produces a value of the type that is specified.

```java
Random rng = new Random(1);
Supplier<Integer> randomInteger = () -> rng.nextInt();
```

</details>


<details>
<summary>Consumer</summary>
Consumer is a function that accepts a single input argument and returns no result.

```java
Consumer<Boolean> printer = System.out::println;

// another Consumer example
Consumer<List<Integer>> dispList = list -> list
    .stream()
    .forEach(a -> System.out.print(a + " "));

// Implement dispList using accept() 
dispList.accept(list); 
```

</details> 


<details>
<summary>Skeleton codes</summary>

```java
public static <T> LambdaList<T> of(T... varargs) {
    List<T> list = new ArrayList<>();
    for (T e : varargs) {
        list.add(e);
    }
    return new LambdaList<T>(list);
} 

public static <T> LambdaList<T> generate(int count, Supplier<T> s) {
    // TODO
    return null;
}

public <V> LambdaList<V> map(Function<? super T, ? extends V> f) {
    List<V> newList = new ArrayList<V>();
    for (T i: list) {
        newList.add(f.apply(i));
    }
    return new LambdaList<V>(newList);
}

public <U> U reduce(U identity, BiFunction<? super U, ? super T, ? extends U> accumulator) {
    // TODO
    return null;
}

public LambdaList<T> filter(Predicate<? super T> predicate) {
    // TODO
    return null;
}

public void forEach(Consumer<? super T> action) {
    // TODO
}
```

</details>  


***

# Curried Functions

```java
int add(int x, int y) {
    return x + y;
}
// is the same as 
Function<Integer, Function<Integer, Integer>> add = x -> y -> (x + y);

// calling the function 
add.apply(1).apply(1);

```

***

# Functors & Monads

<details>
<summary>Functor</summary>

## What is it?
A functor is a typed data structure that encapsulates some value(s). Functors allow us to operate on values inside containers without having to know any of the implementation details of the containers themselves. Or we can also think of functors as something that takes in a function and returns another functor. A functor can be any class that implements the interface below, or matches the interface below: 

```java
interface Functor<T> {
    public <R> Functor<R> f(Function<T, R> func);
}
```

However, matching the pattern syntactically alone is not enough to make something a functor. A functor has to obey these laws: 
- if func is an identity function x -> x, then it should not change the functor. 
- if func is a composition of two functions (e.g. g and h), then the resulting functor should be the same as calling f with h and then with g. 

The only operation that functor provides is map() that takes a function f. This function receives whatever is inside a box, transforms it and wraps the result as-is into a second functor. 

Functor<T> is always an immutable container, thus map never mutates the original object it was executed on. Instead, it returns the result wrapped in a brand new functor. 

</details>


<details>
<summary>Monad</summary>

## What is it?
"Imagine a monad as a container that wraps a value and provides us with a set of transformations over this value and the ability to get this value back with all the transformations applied." - Matt Fowler 

Monads are an abstraction that allows you to build chains of sequential operations. 

## How it works 
Example of monad:

```java
List<String> sortedOrderList = Arrays
    .asList(“1”, “5”, “hello”, “23”)
    .stream()
    .map(String::toUpperCase)
    .sorted()
    .collect(Collectors.toList());
```

</details>


***

# Optional 

</details>

<details>
<summary>Creating Optionals</summary>

## of()
The first approach to creating Optionals is using the .of() method, passing a reference to a non-null object. For example: 

```java
Module cs2030 = new Module();
Optional<Module> optionalModule = Optional.of(cs2030);
```

If the cs2030 was null, the method .of() would throw a NullPointerException. Without Optional, trying to access any of the fields or methods of cs2030 (assuming it's null), without performing a null-check would result in a crash of the program. 

With Optional, the .of() method notices the null value and throws the NullPointerException immediately - potentially also crashing the program. 

WAIT A MINUTE, if the program crashes in both instances, why bother even using Optional?

The program wouldn't crash somewhere deeper in the code (when accessing cs2030) but at the very first use (initialization) of a null object, minimising potential damage. 


## ofNullable()
If cs2030 is allowed to be a null, we can use .ofNullable() instead of .of(). They perform the same if the value is non-null. The difference is obvious when the reference points to null in which case - the .ofNullable() method is perfectly fine with this piece of code: 

```java
Module cs2030 = null;
Optional<Module> optionalModule = Optional.ofNullable(cs2030);
```


## empty()
Instead of wrapping an existing reference variable (null or non-null), we can create a null value in the context of an Optional. It's like an empty container which returns an empty instance of Optional. 

```java
Optional<Module> emptyModule = Optional.empty();
```

</details>


<details>
<summary>Cheking for Values</summary>

## isPresent() 
To check if the value is present inside an Optional, we use the .isPresent() method. This is essentially a replacement for the null-check. 

```java
// Without Optional 
Module module = student.getModule();
if (module != null) {
    System.out.println(module.get());
} else {
    System.out.println("You don't have this module!");
}

// With Optional 
Optional<Module> optionalModule = Optional.ofNullable(student.getModule());
if (optionalModule.isPresent()) {
    System.out.println(module.get());
} else {
    System.out.println("You don't have this module!");
}
```

## ifPresent() 

```java
Optional<Module> optionalModule = Optional.ofNullable(student.getModule());
optionalModule.ifPresent(System.out::println);
```

## isEmpty() 
Another way to check for a value is to use .isEmpty(). Essentially, calling Optional.isEmpty() is the same as calling !Optional.isPresent(). 

## get() 
Simply used yo return a value from the Optional object. If the value is not present, then it throws the exception NoSuchElementException. It is recommended that we check if the value is present before using get().

```java
if (optionalModule.isPresent()) {
    Module module = optionalModule.get();
}
```

## orElse() and orElseGet()

```java
// orElse()
Module cs2030 = maybeCs2030.orElse(new Module());

// orElseGet()
Module cs2030 = maybeCs2030.orElseGet(() -> new Module());
```

If maybeCs2030 doesn't contain a value, both methods will return a new Module. 

In orElse(), the new Module object will not be returned but it will be created. This happens regardless of whether or not the value exists. In orElseGet(), the new Module will be created only if maybeCs2030 doesn't contain a value. 

## orElseThrow() 

```java=
Module cs2030 = maybeCs2030.orElseThrow(NoModuleException::new);
```

</details>


<details>
<summary>flatMap()</summary>

## flatMap()
When doing nested null-checks, it can get confusing: 
```java
if (module != null) {
    Assessment assessment = module.getAssessment();
    if (assessment != null) {
        Grade grade = assessment.getGrade();
        if (grade != null) {
            Feedback feedback = grade.getFeedback();
            System.out.println(feedback);
        }
    }
}
```

An alternative using Optional would be: 
```java
Feedback feedback = module 
    .flatMap(Module::getModule) 
    .flatMap(Assessment::getGrade)
    .map(Grade::getFeedback);
```

</details>

Here are some helpful links regarding Optional: 
- [26 Reasons Why Using Optional Correctly Is Not Optional](https://dzone.com/articles/using-optional-correctly-is-not-optional)
- [Guide to Using Optional in Java 8](https://stackabuse.com/guide-to-optional-in-java-8/)


***

# Lazy Evaluation 

<details>
<summary>LazyList</summary>

</details> 


<details>
<summary>Infinite LazyList</summary>

</details>


***

# Memoization 
Memoization ensures that a method doesn't run for the same inputs more than once. This is done by keeping a record of the results for the given inputs (usually in a hashmap). This is a popular example demonstrating a simple recursive method for computing the nth Fibonacci number:
```java
// Fibonacci without Memoization
// In the code below without memoization, we are calculating fibonacci number for 2 and 3 more than once. 
// To prevent duplication, we can cache the results (i.e. memoization).
public int fibonacci(int n){
    if(n == 0) return 0;
    if(n == 1) return 1;
    System.out.println("Calculating fibonacci number for: "+n);
    return (fibonacci(n-1) + fibonacci(n-2));	
}

private Map<Integer, Integer> memoizeTable = new HashMap<>(); 

// Fibonacci with Memoization
public int fibonacciMemoize(int n) {
    if(n == 0) return 0;
    if(n == 1) return 1;
    if(this.memoizeTable.containsKey(n)) {
        System.out.println("Getting value from computed result for "+n);
	return this.memoizeTable.get(n);
    }
    int result = fibonacciMemoize(n-1)+ fibonacciMemoize(n-2);
    System.out.println("Putting result in cache for "+n);
    this.memoizeTable.put(n, result);
    return result;
}
```

***

# Streams
Having a good understanding of streams can be very useful when dealing with LazyList.
Streams are evaluated sequentially. Some things are better done using Streams, other things are better done using Lists. 

<details>
<summary>Lecture 11</summary>

From sequential to parallel programming. Streams can replace loops. No more loops from this point onwards. 

## Stream concepts:
- Stream elements and pipelines 
- A stream pipeline starts with a data source

```java
IntStream.range(1, 9); // ends before 9
IntStream.rangeClosed(1, 9); // ends at 9

IntStream.range(1, 10).forEach(System.out::println);
IntStream.range(1, 10).sum(); // sum only works with IntStream, not regular streams

// PIPELINE (end with the dot because of jshell) 
IntStream.rangeClosed(1, 10).
    filter(x -> x % 2 ==0).
    map(x -> x * 2). 
    sum();

// flatMap() 
Stream<Integer> stream = Stream.of(8, 4, 2, 2);
stream.flatMap((x) -> Stream.of(x));
``` 

## Intermediate and terminal operations 
- Intermediate operations - every intermediate operation will give you a stream.
- Terminal operations - ends a stream (e.g. sum()) but it is the terminal that initiates the stream. Without a terminal, no element would be generated - nothing will be streamed. (Demonstration in the lecture recording)
- In other words, intermediate Operations are lazy. They're only evaluated upon a terminal operation. Nothing in streams should be evaluated until you call a terminal operator. 

### Terminal Operations 
- e.g. forEach, reduce, sum

```java
stream.forEach(x -> System.out.println(x));
=> 1
=> 2
=> 3
```

### Source Operations (all these methods are static) 
- e.g. of, generate, iterate 

```java
import java.util.stream.Stream;

// of()
Stream<Integer> stream = Stream.of(1, 2, 3, 4);

// generate()
Stream<Integer> stream = Stream.generate(() -> 1).limit(3).forEach(System.out::println);

// iterate()
Stream<Integer> stream = Stream.iterate(1, x -> x + 1);

// Any collection that you have, can .stream()
List.of(3, 6, 4, 10).stream.limit(3).forEach(System.out::println);
```

## Stateless vs stateful operations 
- Intermediate stream operations like filter and map are stateless (processing one stream element does not depend on other stream elements). 
- Mapping and filtering don't change the state of the stream - stateless. 
- Stateful intermediate operations that depend on the current state include sorted, limit, distinct, etc.
- For example, if you want to sort, do it at the top first - sequence matters for stateful operations! 


## Parallel streams: 
- Parallel streams use a common ForkJoinPool via the static ForkJoinPool.commonPool() method
- Try to avoid stateful operations 

```java
ForkJoinPool.commonPool().getParallelism();

// Level of parallelism can be controlled by setting the system property during program run
System.setProperty("java.util.concurrent.ForkJoinPool.common.parallelism", "4");
```

## Debugging parallel streams 
- To debug and manage each execution thread: Thread.currentThread() or Thread.currentThread.getName()

```java
IntStream.of(1, 2, 3, 4, 5). 
    parallel().
    filter(x -> {
        System.out.println("filter: " + x + " " + 
        Thread.currentThread().getName());
        return x % 2 == 1;
    }).
    map(x -> {
        System.out.println("map: " + x + " " + 
        Thread.currentThread().getName());
        return x; 
    }).
    reduce(0, (x, y) -> {
        System.out.println("reduce: " + x + " + " + y + " " + 
        Thread.currentThread().getName()); 
        return x + y;
    });
```


## Reduce operator 

```java
// In terms of sum, can use reduction too
IntStream.rangeClosed(1, 10).
    filter(x -> x % 2 ==0).
    map(x -> x * 2). 
    reduce(1, (x, y) -> x * y); 
// for multiplication, start with 1 which is the starting element to multiply because 1 * x = x
// for addition, start with 0 because 0 + x = x

// Can also do reduce without identifier 
IntStream.rangeClosed(1, 10).
    filter(x -> x % 2 ==0).
    map(x -> x * 2). 
    reduce((x, y) -> x * y); // returns an OptionalInt[122880]

IntStream.rangeClosed(1, 1).
    filter(x -> x % 2 ==0).
    map(x -> x * 2). 
    reduce((x, y) -> x * y); // returns an OptionalInt.empty

// reduce() 
// - Goes from left to right and reduces the stream into 1 value. e.g. a stream of 8, 4, 2, 1 would result in 1. 
// - It is wrapped in an optional but you can avoid this by feeding it a value. 
stream.reduce((x, y) -> x / y);
```


## Accumulator and Combiner 
Accumulator takes in U and T to give out U while Combiner takes in U and U to give out U. There are a lot of possibilities so rules need to be followed to achieve desired output: 
- combiner.apply(identity, i) must be equal to i
– combiner and accumulator must be associative, i.e. order of application does not matter
– combiner and accumulator must be compatible, i.e. combiner.apply(u, accumulator.apply(identity, t)) must be equal to accumulator.apply(u, t)

```java
Stream.of(1, 2, 3, 4, 5).
    parallel().
    filter(x -> {
        // System.out.println("filter: " + x + " " + 
        // Thread.currentThread().getName()); 
        return x % 2 == 1;
    }).
    boxed().
    reduce(0, (x, y) -> {
        System.out.println("accumulate: " + x + " " + y + " " + 
        Thread.currentThread().getName()); 
        return x + y;
    }, (x, y) -> {
        System.out.println("combine: " + x + " " + y + " " + 
        Thread.currentThread().getName());
        return x + y;
    } 
);

// Collector 
// boxed() is an intermediate operator that converts IntStream to Stream<Integer>
IntStream.range(1, 100).parallel().boxed().collect(Collectors.toList()).size();

// forEachOrdered()

// CopyOnWriteArrayList
```

</details>


***

# Asynchronous Programming 

<details>
<summary>Sychronous vs Asynchronous programming</summary>

```java
// Synchronous 
public static void main(String[] args) {
    System.out.println("Before calling compute()");
    new UnitTask(Integer.valueOf(args[0])).compute(); 
    System.out.println("After calling compute()");
}

// Asynchronous - create a thread that runs the compute method 
// We can create a new thread to perform any operation asynchronously. 
public static void main(String[] args) {
    Systenm.out.println("Before calling compute()");
    Thread t = new Thread( 
        () -> new UnitTask(Integer.valueOf(args[0])).compute();
    t.start();
    System.out.println("after calling compute()");
}

// another example: 
int num = 5; 
Thread newThread = new Thread(() -> { 
    System.out.println("Factorial of " + number + " is: " + factorial(num));
});
newThread.start();
```

## Asynchronous programming
Besides thread creation shown in the code above:
### Busy waiting 
A busy-waiting loop can be used to wait for a thread to complete. 


### Thread completion 
#### `join` method 
The join method is similar to the get method, but it throws an unchecked exception in case the thread is not complete. 

</details>

<details>
<summary>Callback</summary>
The conventional way of creating a listener is via an interface 
Motivated by Observer pattern which addresses the issue of tight coupling using Inversion of Control 
- Listener(s) (or observers) are included in the thread 
- Thread notifies the listener(s) when execution completes 
- Tasks dependent on the completion of execution of the thread can be initiated as part of the notification 

### Callback via Listener 
```java
// Example given in Lecture 12 slides 
class Async<T> { 
    Thread thread;
    Listener listener;
    Async<T> doThis(Runnable r) {
        thread = new Thread(() -> r.run()); 
        thread.start();
        return this;
    }
    Async<T> thenDoThis(Listener listener) { 
        this.listener = listener;
        return this;
    }
    void join() { 
        try {
            this.thread.join();
        } catch (InterruptedException e) { } 
        this.listener.notifyListener();
    }
} 
```

### Callback via Function 
While the thread is executing, client proceeds to execute independent tasks. 
Async class is a promise that a value will be returned so that a value can be obtained, or callback can be executed. 

```java
// Example given in Lecture 12 slides 
class Async<T> { 
    Thread thread;
    T value; 
    Function<T,T> listener; // Function instead of Listener 
    Async<T> doThis(Supplier<T> s) { // Supplier instead of Runnable 
        thread = new Thread(() -> {
            this.value = s.get(); 
        });
        this.thread.start();
        return this;
    }
    Async<T> thenDoThis(Function<T,T> listener) { 
        this.listener = listener;
        return this;
    }
    T join() { // returns T instead of void
        try {
            this.thread.join();
            this.value = this.listener.apply(this.value);
        } catch (InterruptedException e) { } 
        return value;
    }
}
```

### Callbacks via Chaining `CompletionStages` 
CompletableFuture provides the static CompletableFuture constructors (supplyAsync and runAsync), CompletionStage provides other callback methods: 
- thenAccept(Consumer<? super T>) action
- thenApply(Function<? super T, ? extends U> func
- thenCombine(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> func) 
- thenCompose(Function<? super T, ? extends CompletableStage<U> > func)

</details>


<details>
<summary>CompletableFuture</summary>
CompletableFuture is a Functor as well as a Monad. 
CompletableFuture provides various methods like supplyAsync, runAsync, and thenApplyAsync for asynchronous programming. 
Instead of using threads which has a join method to combine threads, CompletableFuture can execute a method in a different thread than the main thread. 

Instead of copying various examples and explanations, [this](https://www.baeldung.com/java-completablefuture) is a helpful link on CompletableFuture.
</details>


<details>
<summary>Converting Synchronous to Asynchronous</summary>

```java
int y = bar(x);
int z = foo(y);

// can be simplified to: 
int z = bar(foo(y));

// bar is defined as: 
int bar(int x) {
    return x;
}

// asynchronous version: 
int z = fooAsync(5).thenApply(i -> bar(i)).join();

// suppose bar is asynchronous as well: 
CompletableFuture<Integer> barAsync(int x) {
    return CompletableFuture.completedFuture.completedFuture(x);
}

// asynchronous version:
/* use thenCompose so that the CompletableFuture result is 'flattened'. 
thenApply is to thenCompose like map is to flatMap in Optional and Stream 
thenApply would return a nested promise i.e. <CompletableFuture<CompletableFuture></code>
thenCompose would return the 'flattened' result */ 
int z = barAsync(5).thenCompose(y -> fooAsync(y)).join();
```

</details>


***


# Other useful resources 
- [Understanding classes and objects](https://www.ncl.ucar.edu/Document/HLUs/User_Guide/classes/classoview.shtml)
- [How to access methods from another class](https://stackoverflow.com/questions/6576855/java-how-to-access-methods-from-another-class)
- [Difference between List and ArrayList in Java](https://www.geeksforgeeks.org/difference-between-list-and-arraylist-in-java/)
- [Java Generics Tutorial](https://howtodoinjava.com/java/generics/complete-java-generics-tutorial/)
- [Core Java Lang Syntax on GitHub](https://github.com/eugenp/tutorials/tree/master/core-java-modules/core-java-lang-syntax)
- [Generic And Parameterized Types](http://www.angelikalanger.com/GenericsFAQ/FAQSections/ParameterizedTypes.html)
- [Why are arrays covariant but generics are invariant?](https://stackoverflow.com/questions/18666710/why-are-arrays-covariant-but-generics-are-invariant)
- [Java Interface](https://www.w3schools.com/java/java_interface.asp)
- [Java HashMap Tutorial with Examples](https://www.callicoder.com/java-hashmap)
- [Lecture 7: Functions](https://nus-cs2030.github.io/1718-s2/lec07/index.html)
- [Consumer](https://www.geeksforgeeks.org/java-8-consumer-interface-in-java-with-examples/)
- [Java 8 BiFunction Examples](https://mkyong.com/java8/java-8-bifunction-examples/)
- [Memoization example in java](https://java2blog.com/memoization-example-java/)
- [Guide to Java's Future and CompletableFuture](https://thepracticaldeveloper.com/differences-between-completablefuture-future-and-streams/)
