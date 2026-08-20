# ДЗ. Java Core

Для каждой задачи из блоков 1–2 напиши вывод (или «не компилируется» / исключение) и одно предложение, почему.

Код из блоков 3–7 нужно написать, запустить и проверить. Для каждого метода — минимум 3 проверки, включая граничные случаи (`null`, пустой список, одинаковые значения).

---

## 1. Что выведет

### 1.1

```java
static void change(int n) {
    n = 100;
}

int x = 5;
change(x);
System.out.println(x);
```

### 1.2

```java
static void bump(int[] a) {
    a[0] = a[0] + 1;
}

int[] nums = {10, 20};
bump(nums);
System.out.println(Arrays.toString(nums));
```

### 1.3

```java
static void replace(int[] a) {
    a = new int[]{0, 0};
}

int[] nums = {10, 20};
replace(nums);
System.out.println(Arrays.toString(nums));
```

### 1.4

```java
static void both(int[] a) {
    a[1] = 99;
    a = new int[]{1, 2, 3};
    a[0] = 7;
}

int[] nums = {4, 5, 6};
both(nums);
System.out.println(Arrays.toString(nums));
```

### 1.5

```java
int[] arr = {1, 2, 3};
for (int x : arr) {
    x = x * 10;
}
System.out.println(Arrays.toString(arr));
```

### 1.6

```java
int[] arr = {1, 2, 3};
for (int i = 0; i < arr.length; i++) {
    arr[i] = arr[i] * 10;
}
System.out.println(Arrays.toString(arr));
```

### 1.7

```java
class Box {
    int value;
    Box(int value) { this.value = value; }
}

Box[] boxes = {new Box(1), new Box(2)};
for (Box b : boxes) {
    b.value = b.value * 10;
}
System.out.println(boxes[0].value + " " + boxes[1].value);
```

### 1.8

```java
class Box {
    int value;
    Box(int value) { this.value = value; }
}

Box[] boxes = {new Box(1), new Box(2)};
for (Box b : boxes) {
    b = new Box(0);
}
System.out.println(boxes[0].value + " " + boxes[1].value);
```

### 1.9

```java
static void upper(String s) {
    s = s.toUpperCase();
}

String name = "java";
upper(name);
System.out.println(name);
```

### 1.10

```java
static void addBang(StringBuilder sb) {
    sb.append("!");
}

StringBuilder name = new StringBuilder("java");
addBang(name);
System.out.println(name);
```

### 1.11

```java
static void replace(StringBuilder sb) {
    sb = new StringBuilder("kotlin");
}

StringBuilder name = new StringBuilder("java");
replace(name);
System.out.println(name);
```

### 1.12

```java
static void mix(StringBuilder sb) {
    sb.append("?");
    sb = new StringBuilder("no");
    sb.append("!");
}

StringBuilder name = new StringBuilder("java");
mix(name);
System.out.println(name);
```

### 1.13

```java
String a = "Java";
String b = "Java";
String c = new String("Java");
String d = c.intern();

System.out.println(a == b);
System.out.println(a == c);
System.out.println(a.equals(c));
System.out.println(a == d);
```

### 1.14

```java
String name = null;
System.out.println("admin".equals(name));
System.out.println(name.equals("admin"));
```

### 1.15

```java
Integer a = 100;
Integer b = 100;
Integer c = 200;
Integer d = 200;

System.out.println(a == b);
System.out.println(c == d);
System.out.println(a.equals(b));
System.out.println(c.equals(d));
```

### 1.16

```java
List<String> a = List.of("A", "B");
List<String> b = Arrays.asList("A", "B");
List<String> c = new ArrayList<>(List.of("A", "B"));

c.add("C");
b.set(0, "X");
a.add("C");
```

Напиши, какая строка упадёт первой и с каким исключением. Что будет в `b` и `c`, если убрать падающую строку?

### 1.17

```java
List<String> names = new ArrayList<>(List.of("Аня", "Алекс", "Боря", "Артём"));
for (String name : names) {
    if (name.startsWith("А")) {
        names.remove(name);
    }
}
System.out.println(names);
```

### 1.18

```java
List<Integer> nums = new ArrayList<>(List.of(1, 2, 3, 4, 5));
Iterator<Integer> it = nums.iterator();
while (it.hasNext()) {
    if (it.next() % 2 == 0) {
        it.remove();
    }
}
System.out.println(nums);
```

### 1.19

```java
class Point {
    int x;
    Point(int x) { this.x = x; }

    @Override
    public boolean equals(Object o) {
        return o instanceof Point p && p.x == x;
    }
}

Set<Point> set = new HashSet<>();
set.add(new Point(1));
System.out.println(set.contains(new Point(1)));
```

### 1.20

```java
class Point {
    int x;
    Point(int x) { this.x = x; }

    @Override
    public boolean equals(Object o) {
        return o instanceof Point p && p.x == x;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(x);
    }
}

Set<Point> set = new HashSet<>();
set.add(new Point(1));
System.out.println(set.contains(new Point(1)));
```

### 1.21

```java
class Key {
    int id;
    Key(int id) { this.id = id; }

    @Override
    public boolean equals(Object o) {
        return o instanceof Key k && k.id == id;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(id);
    }
}

Map<Key, String> map = new HashMap<>();
Key key = new Key(1);
map.put(key, "ok");
key.id = 2;
System.out.println(map.get(key));
System.out.println(map.get(new Key(1)));
System.out.println(map.get(new Key(2)));
System.out.println(map.size());
```

### 1.22

```java
class Animal {}
class Dog extends Animal {}
class Cat extends Animal {}

List<Dog> dogs = new ArrayList<>();
List<Animal> animals = dogs;
animals.add(new Cat());
Dog d = dogs.get(0);
```

### 1.23

```java
List<? extends Number> nums = new ArrayList<Integer>();
Number n = nums.get(0);
nums.add(1);
```

Какие строки компилируются?

### 1.24

```java
List<? super Integer> nums = new ArrayList<Number>();
nums.add(1);
Integer x = nums.get(0);
Object y = nums.get(0);
```

Какие строки компилируются?

### 1.25

```java
try {
    throw new IOException();
} catch (Exception e) {
    System.out.println("E");
} catch (IOException e) {
    System.out.println("IO");
}
```

### 1.26

```java
int[] a = {1, 2, 3};
int[] b = a;
b[0] = 9;
System.out.println(Arrays.toString(a));
b = new int[]{0};
System.out.println(Arrays.toString(a));
```

### 1.27

```java
String s = "ab";
s.concat("c");
System.out.println(s);
s = s.concat("c");
System.out.println(s);
```

### 1.28

```java
Map<String, Integer> map = new HashMap<>();
map.put("a", 1);
map.putIfAbsent("a", 5);
map.putIfAbsent("b", 5);
map.merge("a", 10, Integer::sum);
map.merge("c", 3, Integer::sum);
System.out.println(map);
```

### 1.29

```java
Set<Integer> tree = new TreeSet<>(List.of(30, 10, 20, 10));
Set<Integer> linked = new LinkedHashSet<>(List.of(30, 10, 20, 10));
Set<Integer> hash = new HashSet<>(List.of(30, 10, 20, 10));
System.out.println(tree);
System.out.println(linked);
System.out.println(hash.size());
```

### 1.30

```java
record Person(String name, int age) {}

Person p1 = new Person("Миша", 25);
Person p2 = new Person("Миша", 25);
System.out.println(p1.equals(p2));
System.out.println(p1 == p2);
System.out.println(p1);
```

---

## 2. Исправь код

Для каждой задачи:

```text
Ошибка:
Почему:
Исправленный код:
Как проверить:
```

### 2.1

```java
public static int max(int a, int b) {
    if (a > b) {
        return a;
    }
}
```

Проверка: `max(5, 5)` должен вернуть `5`.

### 2.2

```java
public boolean isAdmin(String name) {
    if (name == "admin") {
        return true;
    }
    return false;
}
```

Должно работать для `"admin"`, `new String("admin")`, `"user"` и `null`.

### 2.3

```java
List<String> names = new ArrayList<>(List.of("Аня", "Алекс", "Боря"));
for (String name : names) {
    if (name.startsWith("А")) {
        names.remove(name);
    }
}
```

Исходный список нужно изменить. Предпочтительный вариант — `removeIf`.

### 2.4

```java
try {
    loadData();
} catch (Exception e) {
    log(e);
} catch (IOException e) {
    log(e);
}
```

### 2.5

```java
public class Config {
    private int timeout = 30;

    public static void printTimeout() {
        System.out.println(timeout);
    }
}
```

### 2.6

```java
public class Task {
    private int priority;

    public Task(int priority) {
        this.priority = priority;
    }

    public Task() {
        System.out.println("Создаю задачу по умолчанию");
        this(1);
    }
}
```

### 2.7

```java
public String buildReport(List<String> rows) {
    String result = "";
    for (String row : rows) {
        result += row + "\n";
    }
    return result;
}
```

Список может содержать 100 000 строк.

### 2.8

```java
public List<String> readLines(String fileName) throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(fileName));
    List<String> lines = new ArrayList<>();
    String line;
    while ((line = reader.readLine()) != null) {
        lines.add(line);
    }
    return lines;
}
```

### 2.9

```java
class User {
    String email;

    User(String email) { this.email = email; }

    @Override
    public boolean equals(Object o) {
        return o instanceof User u && Objects.equals(email, u.email);
    }
}

Set<User> users = new HashSet<>();
users.add(new User("a@mail"));
System.out.println(users.contains(new User("a@mail"))); // должно быть true
```

### 2.10

```java
static void copy(List<Animal> from, List<Animal> to) {
    for (Animal a : from) {
        to.add(a);
    }
}

List<Dog> dogs = List.of(new Dog());
List<Animal> animals = new ArrayList<>();
copy(dogs, animals);
```

Нужно, чтобы метод принимал список собак как источник и список `Object` / `Animal` как назначение.

### 2.11

```java
List<String> names = List.of("A", "B");
names.add("C");
```

Нужен изменяемый список с элементами `"A"`, `"B"`, `"C"`.

### 2.12

```java
public static boolean same(String a, String b) {
    return a.equals(b);
}
```

Не должен падать, если `a` или `b` равны `null`. `"x"` и `"x"` — `true`, `null` и `null` — `true`.

### 2.13

```java
int[] data = {1, 2, 3};
for (int n : data) {
    n++;
}
// data должен стать {2, 3, 4}
```

### 2.14

```java
if (obj instanceof List<String>) {
    System.out.println("строки");
}
```

### 2.15

```java
void process(List<String> values) {}
void process(List<Integer> values) {}
```

---

## 3. Напиши метод

### 3.1

Удвой все элементы массива на месте:

```java
public static void doubleInPlace(int[] arr)
```

`null` и пустой массив не должны падать.

### 3.2

Верни новый массив с удвоенными элементами, исходный не меняй:

```java
public static int[] doubledCopy(int[] arr)
```

### 3.3

Поменяй местами первый и последний элементы массива на месте:

```java
public static void swapEnds(int[] arr)
```

Если элементов меньше двух — ничего не делать.

### 3.4

```java
public static boolean isAdmin(String name)
```

Сравнение без учёта регистра. `null` → `false`.

### 3.5

```java
public static String longest(String[] words)
```

Верни самое длинное слово. Если массив `null` или пустой — `null`. При равенстве длины — первое встреченное.

### 3.6

```java
public static int indexOf(int[] arr, int value)
```

Индекс первого вхождения или `-1`.

### 3.7

```java
public static int[] mergeSorted(int[] a, int[] b)
```

Слей два отсортированных по возрастанию массива в один отсортированный. Не используй `Arrays.sort` на результате.

### 3.8

```java
public static boolean hasDuplicate(int[] arr)
```

Есть ли повторяющееся число. Сложность по времени лучше линейной, если получится через `Set`.

### 3.9

```java
public static int[] uniquePreserveOrder(int[] arr)
```

Убери дубликаты, порядок первых вхождений сохрани.

Пример: `{3, 1, 3, 2, 1}` → `{3, 1, 2}`.

### 3.10

```java
public static int[] rotateLeft(int[] arr, int k)
```

Сдвиг влево на `k`. `k` может быть больше длины и отрицательным (тогда сдвиг вправо). Исходный массив не меняй.

---

## 4. Коллекции

### 4.1

Удали из списка все чётные числа. Список уже есть, меняй его.

```java
public static void removeEven(List<Integer> nums)
```

### 4.2

Верни новый список без коротких слов, исходный не трогай:

```java
public static List<String> longerThan(List<String> words, int minLength)
```

### 4.3

```java
public static Map<String, Integer> wordCount(List<String> words)
```

Ключ — слово в нижнем регистре, значение — сколько раз встретилось. `null`-элементы пропускай. `null`-список → пустая карта.

### 4.4

```java
public static Map<Integer, List<String>> groupByLength(List<String> words)
```

Сгруппируй слова по длине.

### 4.5

```java
public static Set<String> intersection(Set<String> a, Set<String> b)
```

Не меняй исходные множества.

### 4.6

```java
public static List<String> firstUnique(List<String> names, int n)
```

Первые `n` уникальных имён в порядке появления.

`["Аня", "Боря", "Аня", "Вика", "Боря"]`, `n = 2` → `["Аня", "Боря"]`.

### 4.7

Есть журнал входов:

```java
record Login(String user, String ip)
```

```java
public static Map<String, Set<String>> ipsByUser(List<Login> logins)
```

Для каждого пользователя — множество его IP.

### 4.8

```java
public static String mostFrequent(List<String> words)
```

Самое частое слово. При ничьей — то, что встретилось раньше. Пустой список / `null` → `null`.

### 4.9

```java
public static <T> List<T> reverseCopy(List<T> list)
```

Новый список в обратном порядке. Исходный не меняй.

### 4.10

Выбери структуру и реализуй:

```java
public static boolean isValidBrackets(String s)
```

Проверь скобки `()`, `[]`, `{}`.

`"([])"` → `true`, `"([)]"` → `false`, `""` → `true`, `null` → `false`.

### 4.11

Напиши, какую реализацию `List` взять и почему, затем код:

- 100 000 раз `get(index)` в случайных местах;
- часто вставляешь в начало;
- нужен только обход с начала до конца и добавление в конец.

### 4.12

```java
List<String> a = List.of("A", "B");
List<String> b = Arrays.asList("A", "B");
List<String> c = new ArrayList<>(List.of("A", "B"));
```

Для каждого списка напиши, что будет при `add("C")` и при `set(0, "X")`.

---

## 5. equals, hashCode, ключи

### 5.1

Класс точки:

```java
class Point {
    final int x;
    final int y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
```

Допиши `equals` и `hashCode`, чтобы `Point(1, 2)` и `Point(1, 2)` находились в `HashSet` как один элемент.

Проверки:

- два одинаковых объекта равны;
- `equals` симметричен;
- `HashSet` размера 1 после добавления двух равных точек;
- `contains` находит новую точку с теми же координатами.

### 5.2

Сделай то же через `record Point(int x, int y)`. Сравни размер `HashSet` с двумя одинаковыми точками.

### 5.3

```java
class MutableKey {
    int id;
}
```

Покажи на работающем примере, что после `map.put(key, "v")` и смены `key.id` значение «теряется». Затем перепиши ключ как неизменяемый `record Key(int id)` и покажи, что поиск работает.

### 5.4

```java
class User {
    String name;
    int age;
}
```

Два пользователя равны, если равны имена без учёта регистра. Возраст в равенство не входит. Реализуй `equals`/`hashCode` согласованно.

Проверь: `"Миша"` и `"миша"` — один элемент в `HashSet`.

### 5.5

Напиши метод:

```java
public static <K, V> Map<K, V> copyMap(Map<K, V> source)
```

Обычная поверхностная копия. Затем отдельно объясни в комментарии, почему копирование `Map<MutableKey, String>` не спасает, если потом меняют поля ключа.

### 5.6

Есть список заказов:

```java
record Order(String customer, String product, int qty)
```

```java
public static Map<String, Integer> totalQtyByCustomer(List<Order> orders)
```

Суммарное количество товаров по каждому клиенту.

---

## 6. Generics

### 6.1

Заполни пропуски:

```java
static void moveAnimals(
        List<________ Animal> source,
        List<________ Animal> destination
) {
    for (Animal animal : source) {
        destination.add(animal);
    }
}
```

Напиши 3 вызова, которые должны компилироваться, и 1, который не должен.

### 6.2

```java
public static <T> void copy(List<? extends T> src, List<? super T> dst)
```

Реализуй. Проверь:

- копирование `List<Integer>` в `List<Number>`;
- копирование `List<String>` в `List<Object>`;
- что исходный список не меняется.

### 6.3

```java
public static <T extends Comparable<T>> Optional<T> max(List<T> list)
```

Пустой или `null`-список → `Optional.empty()`. В комментарии — зачем `extends Comparable<T>`.

Проверки: числа, строки, пустой список, `null`, список из одного элемента.

### 6.4

```java
public static <T> Optional<T> first(List<T> list, Predicate<T> test)
```

Первый элемент, подходящий под условие. Нет такого / `null`-список → `Optional.empty()`.

### 6.5

```java
public static <T> List<T> filter(List<T> list, Predicate<T> test)
```

### 6.6

Почему не компилируется? Как исправить сигнатуру, не меняя тело логики «прочитать всех как Animal»?

```java
static void printAnimals(List<Animal> animals) {
    for (Animal a : animals) {
        System.out.println(a);
    }
}

List<Dog> dogs = List.of(new Dog());
printAnimals(dogs);
```

### 6.7

Почему нельзя сделать `new T()` внутри generic-метода? Напиши рабочий вариант фабрики через `Supplier<T>`:

```java
public static <T> List<T> nCopies(int n, Supplier<T> factory)
```

`nCopies(3, () -> new ArrayList<String>())` должен вернуть 3 разных списка, а не 3 ссылки на один объект.

### 6.8

Напиши метод, который принимает producer чисел и считает сумму:

```java
public static double sum(List<? extends Number> nums)
```

Проверь на `List<Integer>` и `List<Double>`.

---

## 7. Напиши класс / несколько методов

### 7.1 `Money`

```java
record Money(String currency, long cents)
```

- в компактном конструкторе: `currency` не `null` и не пустой (после `trim`), `cents >= 0`, иначе `IllegalArgumentException`;
- `Money plus(Money other)` — складывает, при разной валюте бросает `IllegalArgumentException`;
- `Money minus(Money other)` — вычитает, если результат отрицательный — `IllegalArgumentException`;
- статический метод `Money rubles(long cents)`.

Проверки: сложение рублей, разные валюты, `null` валюта, `minus` в минус, `rubles(0)`.

### 7.2 Стек на массиве

```java
class IntStack {
    void push(int value);
    int pop();          // пустой стек — IllegalStateException
    int peek();         // пустой стек — IllegalStateException
    boolean isEmpty();
    int size();
}
```

Внутри — массив, при переполнении увеличивай в 2 раза. Нельзя использовать `java.util.Stack` / `ArrayDeque`.

### 7.3 `UniqueQueue`

Очередь строк без дубликатов: если строка уже есть, `offer` её не добавляет повторно.

```java
boolean offer(String value); // false, если value == null или уже есть
String poll();               // null, если пусто
boolean contains(String value);
int size();
```

Порядок — FIFO для успешно добавленных.

### 7.4 Частотный словарь из текста

```java
public static Map<String, Long> countWords(String text)
```

Слова делятся пробелами. Регистр не учитывать. `null`/пустая строка/`"   "` → пустая карта. Stream API.

### 7.5 Сотрудники

```java
record Employee(String name, String department, double salary) {}

public static Map<String, Double> averageSalaryByDepartment(List<Employee> employees)
public static List<String> topThreeNames(List<Employee> employees)
```

Второй метод — имена трёх самых высокооплачиваемых по убыванию зарплаты. Если сотрудников меньше трёх — верни сколько есть.

### 7.6 Конфиг

Своё checked-исключение `ConfigException`.

```java
public static Map<String, String> loadConfig(Path path) throws ConfigException
```

Читай UTF-8 через try-with-resources. Формат `key=value`. Пустые строки и `#...` пропускай. `IOException` оберни в `ConfigException` с cause.

### 7.7 `enum Operation`

Четыре действия: `+ - * /`.

- у константы есть символ и `double apply(double a, double b)`;
- деление на 0 → `ArithmeticException`;
- `Operation fromSymbol(String symbol)` — неизвестный символ → `IllegalArgumentException`.

Напиши мини-калькулятор: `"3.5 * 2"` → `7.0`. Формат строго `число пробел знак пробел число`. Неверный формат → `IllegalArgumentException`.

### 7.8 Телефонная книга

```java
class PhoneBook {
    void add(String name, String phone);
    List<String> getPhones(String name);      // копия, изменение результата не портит книгу
    boolean removePhone(String name, String phone);
    Set<String> names();
}
```

Один человек — несколько телефонов, без дубликатов номера у одного имени.

### 7.9 Фильтр логов

```java
record LogLine(String level, String message, int ts)

public static List<String> errorMessages(List<LogLine> logs)
```

Верни `message` всех строк с `level` равным `"ERROR"` без учёта регистра, в исходном порядке.

### 7.10 Корзина

```java
record Item(String id, String title, int priceCents)

class Cart {
    void add(Item item, int qty);
    void remove(String itemId);
    int totalCents();
    Map<String, Integer> quantities(); // id -> qty, неизменяемая копия
}
```

`qty <= 0` → `IllegalArgumentException`. Повторный `add` того же `id` увеличивает количество.

---

## 8. Допиши по коду

Не эссе. 1–2 предложения на пункт.

### 8.1

```text
Java передаёт аргументы ...
Через скопированную ссылку можно ...
Переназначение параметра не меняет ...
for-each по int[] не меняет массив, потому что ...
for-each по объектам может менять объект, потому что ...
```

### 8.2

```text
Если equals вернул true, то hashCode ...
Одинаковый hashCode не означает ...
Ключ HashMap нельзя менять, потому что ...
List.of(...).add(...) компилируется, но падает, потому что ...
```

### 8.3

```text
Producer Extends — когда коллекция ...
Consumer Super — когда коллекция ...
Из ? extends безопасно ...
В ? super безопасно ...
List<Dog> нельзя присвоить в List<Animal>, потому что ...
```

---

## 9. Мини-проект на вечер

Собери консольную программу `GradeBook`.

Данные:

```java
record Student(String id, String name) {}
record Grade(String studentId, String course, int score) {} // score 0..100
```

Нужно уметь:

1. добавить студента; повторный `id` — ошибка;
2. поставить оценку; неизвестный студент — ошибка; `score` вне 0..100 — ошибка;
3. вывести средний балл студента по всем курсам;
4. вывести средний балл по курсу;
5. вывести топ-3 студентов по среднему баллу;
6. вывести все оценки студента, отсортированные по названию курса.

Хранение — `HashMap` / `ArrayList`, не БД. `equals`/`hashCode` у студента — по `id`.

В `main` зашитый сценарий: 4 студента, 8–10 оценок, печать всех пунктов 3–6.

---

Сдавать: один проект / папка с классами. К задачам 1–2 — текстовый файл с ответами. К задачам 3–7 и 9 — код, который запускается.
