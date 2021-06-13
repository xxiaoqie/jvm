import java.util.ArrayList;
import java.util.List;

public class HeapOOM {
    // Exception in thread "main" java.lang.OutOfMemoryError: Java heap space

    public static void heap() {
        List<int[]> list = new ArrayList<>();
        while(true) {
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(new int[1024*1024/4]);
        }
    }


    public static void main(String[] args) {
        heap();
    }
}
