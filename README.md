# structure
一个轻量级的通用数据结构框架。
## 采用TDD进行开发，将bug数量降到最低！
该项目采用了当前流行的测试框架：JUnit4来进行测试。我们遵循：“代码未动，测试先行”这一条TDD开发的宗旨。
## 轻量级、快速、简洁，比JVM内置的util模块更轻！
我们去掉了任何对于一般项目用不到的功能，例如：
- 冗余而无用的接口和抽象类
- 复杂的各种相似的数据结构
- 一般项目中用不到的复杂函数
- ……
## 上手简单，开箱即用！
请看下面这个简短的例子：
```java
StructureArray<Integer> array = new StructureArray<Integer>(); //创建Array对象
array.add(1);
array.add(2);
array.add(3);
array.toArray(); // [1, 2, 3]
array.toString(); // "[1, 2, 3]"
array.remove(2); // 现在该对象变为：[1, 2]
array.get(0); // 1
```
与util模块中的方法高度相似，但**更精简**。
## 把Structure加入到你的项目中吧！
