import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
  * VM Args：-Xmx20M -XX:MaxDirectMemorySize=10M
 *  -XX:MaxDirectMemorySize
  * @author zzm
  */
public class DirectMemoryOOM {
    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        int cnt = 0;
        try {
            while(true) {
                unsafe.allocateMemory(_1MB);
                cnt++;
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(cnt);
        }
    }
}
