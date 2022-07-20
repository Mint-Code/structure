package structure;

/**
 * StructureArray - Structure版的ArrayList。
 * <p>您可以向这样创建一个StructureArray：</p>
 * <p>该函数会直接创建一个空的StructureArray。您还可以像如下这样创建StructureArray：</p>
 * <blockquote><pre>
new StructureArray<Integer>(); //创建一个空的StructureArray（即本构造函数）
new StructureArray<Integer>({1, 2, 3, 4, 5}); //[1, 2, 3, 4, 5]
new StructureArray<Integer>(1, 2, 3, 4, 5); //这行代码的效果和上面一样
 * </pre></blockquote>
 * <p>
 * 需要注意的是，如果您对性能的要求非常高，请不要使用StructureArray，因为该类实际上在每次增删改查操作时都会在内部创建一个新的数组并遍历原数组来完成对其的初始化。
 * 并且，由于使用了泛型，StructureArray也会拥有Java泛型擦除法带来的的共同缺陷，在使用时需要加倍注意。
 * </p>
 * <p>该类的大多数函数都与JVM内置的ArrayList相同，不过有一些例外。这些例外将在下面列出：</p>
 * <blockquote><pre>
new ArrayList(Collection<? extends E> c) //通过Collection对象创建一个ArrayList
new StructureArray(Object[] elementList) //通过一个数组创建StructureArray
ArrayList.add(int index, E element): void //ArrayList中的方法，此方法会在index处插入元素element
StructureArray.insert(E element, int index): void //来自StructureArray，也会在index处插入元素element
ArrayList.length(): int //通过索引获取元素
StructureArray.getLength(): int //作用和上面相同
 * </pre></blockquote>
 */
public class StructureArray<E> {
    
    private Object[] elementList = new Object[0];

    /**
     * 创建一个空的StructureArray。
     * <p>该函数会直接创建一个空的StructureArray。您还可以像如下这样创建StructureArray：</p>
     * <blockquote><pre>
new StructureArray<Integer>(); //创建一个空的StructureArray（即本构造函数）
new StructureArray<Integer>({1, 2, 3, 4, 5}); //[1, 2, 3, 4, 5]
new StructureArray<Integer>(1, 2, 3, 4, 5); //这行代码的效果和上面一样
     * </pre></blockquote>
     * <p>
     * 需要注意的是，如果您对性能的要求非常高，请不要使用StructureArray，因为该类实际上在每次增删改查操作时都会在内部创建一个新的数组并遍历原数组来完成对其的初始化。
     * 并且，由于使用了泛型，StructureArray也会拥有Java泛型擦除法带来的的共同缺陷，在使用时需要加倍注意。
     * </p>
     */
    public StructureArray() {
        super();
    }

    /**
     * 按照传入参数的顺序创建出一个StructureArray。
     * <p>该函数会根据传入的参数去构建一个StructureArray。您可以传入一个数组，或者也可以将参数用逗号分隔传入。您还可以这样创建StructureArray：</p>
     * <blockquote><pre>
new StructureArray<Integer>(); //创建一个空的StructureArray
new StructureArray<Integer>({1, 2, 3, 4, 5}); //[1, 2, 3, 4, 5]
new StructureArray<Integer>(1, 2, 3, 4, 5); //这行代码的效果和上面一样（即本构造函数）
     * </pre></blockquote>
     * <p>
     * 需要注意的是，如果您对性能的要求非常高，请不要使用StructureArray，因为该类实际上在每次增删改查操作时都会在内部创建一个新的数组并遍历原数组来完成对其的初始化。
     * 并且，由于使用了泛型，StructureArray也会拥有Java泛型擦除法带来的的共同缺陷，在使用时需要加倍注意。
     * </p>
     * @param elementList - 初始化StructureArray的值
     */
    @SuppressWarnings("unchecked")
    public StructureArray(E... elementList) {
        super();
        this.elementList = elementList;
    }

    /**
     * 将StructureArray对象转化为一个普通数组。
     * <p>该函数将会返回StructureArray内部的elementList来达到转化的效果。唯一需要注意的是返回的数组是一个E数组而不是一个Object数组。下面是一个简单的例子：</p>
     * <blockquote><pre>
StructureArray<String> structureArray = new StructureArray<String>("1", "2", "3", "4", "5");
String[] array = structureArray.toArray(); //{"1", "2", "3", "4", "5"}
     * </pre></blockquote>
     * @return 返回转化以后的数组
     */
    @SuppressWarnings("unchecked")
    public E[] toArray() {
        return (E[]) elementList;
    }

    /**
     * 将StructureArray对象转化为一个字符串。
     * <p>
     * 该函数返回的字符串格式为：<code>[</code> + 
     * <code>元素1转化为字符串后的内容</code> + 
     * <code>, </code> + 
     * <code>元素2转化为字符串后的内容</code> + 
     * <code>, </code> + …… +
     * <code>]</code>。例如：
     * </p>
     * <blockquote><pre>
StructureArray<String> structureArray = new StructureArray<String>("1", "2", "3", "4", "5");
String string = structureArray.toString() // [1, 2, 3, 4, 5]
     * </pre></blockquote>
     * <p>更复杂一些的例子：</p>
     * <blockquote><pre>
//file A
public class Cat extends Animal {
    public string toString() {
        return "cat";
    }
}

//file B
StructureArray<Animal> array = new StructureArray<Animal>(new Cat(), new Cat());
String string = array.toString() // [cat, cat]
     * </pre></blockquote>
     * @return 返回转化以后的字符串
     */
    public String toString() {
        String string = "[";
        for(Object element : elementList) {
            try {
                string += element.toString();
            } catch(Exception err) {
                string += "null";
            }
            string += ", ";
        }
        string = string.substring(0, string.length() - 2);
        string += "]";
        return string;
    }

    /**
     * 返回该StructureArray的长度。
     * <p>这个函数会返回StructureArray中含有的元素数量。需要注意的是，在使用ArrayList时，我们使用length函数来获取长度，但在StructureArray中，我们使用getLength方法。</p>
     * <blockquote><pre>
ArrayList.length(): int
StructureArray.getLength(): int //作用和上面相同
     * </pre></blockquote>
     * <p>该函数的命名是标准的getter命名。我们认为这个名字比ArrayList的length更好。</p>
     * @return 该StructureArray的长度（其内部含有元素的数量）
     */
    public int getLength() {
        return elementList.length;
    }

    /**
     * 通过索引获取指定的元素。
     * <p>
     * 和ArrayList的get方法相同，该方法使用0基索引获取指定的元素。
     * 不过，有一点与ArrayList不同，当所给的索引超出数组的范围时，不会报错，而是会返回空值。这一点需要注意，但这个特性在很多时候有用，例如：
     * </p>
     * <blockquote><pre>
StructureArray<int> array = new StructureArray<int>(1);
if(i > 2) {
    array.add(2);
}
// 其他无关StructureArray操作的代码
if(array.get(1) == null) {
    System.out.println("i < 2 : " + array.toString());
} else {
    System.out.println("i > 2 : " + array.toString());
}
     * </pre></blockquote>
     * @param index - 需要获取的元素的索引（0基）
     * @return 获取到的元素
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        try {
            return (E) (elementList[index]);
        } catch(Exception err) {
            return null;
        }
    }

    public void add(E element) {
        insert(element, elementList.length);
    }

    public void insert(E element, int index) {
        Object[] elementList = new Object[this.elementList.length + 1];
        int oldIndex = 0;
        for(int i = 0; i <= this.elementList.length; i++) {
            if(i != index) {
                elementList[i] = this.elementList[oldIndex];
                oldIndex += 1;
            } else {
                elementList[i] = element;
            }
        }
        this.elementList = elementList;
    }

    public void remove() {
        remove(elementList.length - 1);
    }

    public void remove(int index) {
        Object[] elementList = new Object[this.elementList.length - 1];
        int newIndex = 0;
        for(int i = 0; i < this.elementList.length; i++) {
            if(i != index) {
                elementList[newIndex] = this.elementList[i];
                newIndex += 1;
            }
        }
        this.elementList = elementList;
    }
}
