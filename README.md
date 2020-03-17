# think-in-java
think-in-java practice


* src/main/java下面按照章节来进行包的划分
* src/main/java/xxx/exercise 是练习题的包
* src/main/java/xxx/diy为自己的一些理解代码，demo示例等
* src/main/java/xxx 目录下的`readme.md`，用来对某一章节做说明。

## 源码的格式说明
* `public class`，放在`.java`文件的最上方。这样写类的文档注释会直观很多。过一段时间后，打开类文件，看一下文档注释，就知道这段代码是为了说明什么问题而存在的。
* 源码运行的控制台复制文本，如下所示：
```
/* Output:
Rat, 1, 0; Manx, 2, 1; Cymric, 3, 2; Mutt, 4, 3; Pug, 5, 4; Cymric, 6, 5; Pug, 7, 6; Manx, 8, 7;
7 6 5 4 3 2 1 0
[Rat, Manx, Cymric, Mutt, Pug, Cymric, Pug, Manx]
[Rat, Manx, Cymric, Cymric, Rat, EgyptianMau, Hamster, EgyptianMau]
*///:~
```
* 在文档注释中，需要注明这段源码所属小节
如：
```
/**
 * 14.9 接口与类型信息
 * 这只是一个最简单的接口
 */
 typeinfo.interfacea.A
```
否则，再翻阅源码时，就不知道这段源码属于哪个小节了，条理的清晰度会大打折扣。

* 该源码格式约定，从第15章时开始