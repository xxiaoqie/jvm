import java.util.HashSet;
import java.util.Set;


public class MetaSpace {
    /**
     * -XX:PermSize=6M -XX:MaxPermSize=6M
     * -XX:MaxMetaspaceSize=6m
     * -Xms6M(新生代+老年代) 用于表示堆区的起始内存 等价于-XX:InitialHeapSize=6m 默认单位为字节 大小为物理内存大小/64
     *      -X 是jvm的运行参数
     *      ms memory start
     * -Xmx2G(新生代+老年代) 用于表示堆区的最大内存 等价于-XX:MaxHeapSize=2g                 大小为物理内存大小/4
     *
     * @param args
     */
    //循环将一直进行下去，永不停歇[1]。出现这种变 化，是因为自JDK 7起，原本存放在永久代的字符串常量池被移至Java堆之中，
    // 所以在JDK 7及以上版 本，限制方法区的容量对该测试用例来说是毫无意义的。
    public static void main(String[] args) {
//        Set<String> set = new HashSet<>();
//        long i = 0;
//        while (true) {
//            set.add(String.valueOf(i++).intern());
//        }

        String str1 = new StringBuilder("计算机").append("软件").toString();
        System.out.println(str1.intern() == str1);  // true

        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2.intern() == str2);  // false
    }
}
