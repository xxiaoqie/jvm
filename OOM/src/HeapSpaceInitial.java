/**
 * -Xms6M(新生代+老年代) 用于表示堆区的起始内存 等价于-XX:InitialHeapSize=6m 默认单位为字节 大小为物理内存大小/64
 *      -X 是jvm的运行参数
 *      ms memory start
 * -Xmx2G(新生代+老年代) 用于表示堆区的最大内存 等价于-XX:MaxHeapSize=2g                 大小为物理内存大小/4
 */

public class HeapSpaceInitial {
    public static void main(String[] args) {
        // Java 虚拟机中堆内存总量
        long initialMemory = Runtime.getRuntime().totalMemory() / 1024 / 1024;
        // Java虚拟机试图使用的最大堆内存量
        long maxMemory = Runtime.getRuntime().maxMemory() / 1024 / 1024;
        // 大小为Eden + (S0|S1)区
        // cmd jps获取进程 -> jstat -gc pid 或者 -XX:+PrintGCDetails (执行完后显示)

        System.out.println("-Xms : " + initialMemory + "M");
        System.out.println("-Xmx : " + maxMemory + "M");

//        System.out.println("系统内存大小为: " + initialMemory * 64.0 / 1024 + "G");
//        System.out.println("系统内存大小为: " + maxMemory * 4.0 / 1024 + "G");

    }
}
