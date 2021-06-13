public class EdenSurvivorTest {
    // 默认 -XX:NewRatio=2 表示新生代占1 老年代占2 新生代占整个堆的1/3
    // -XX:NewRatio=4 表示新生代占1 老年代占4 新生代占整个堆的1/5
    // 一般不调
    // 查看
    // jps
    // jinfo -flag NewRatio pid
    // jstat -gc pid

    // 默认 -XX:SurvivorRatio=8 表示 Eden : S0 : S1 = 8 : 1 : 1
    // -XX:-UseAdaptiveSizePolicy 关闭自适应内存分配策略（暂时用不到）
    // jinfo -flag Survivor pid

    // -Xmn 设置新生代的空间大小（一般不设置）

    // -XX:MaxTenuringThreshold=<N> 默认15
    public static void main(String[] args) {
        try {
            Thread.sleep(300000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
