import com.sun.xml.internal.ws.org.objectweb.asm.ClassWriter;
import com.sun.xml.internal.ws.org.objectweb.asm.Opcodes;


/**
 * -XX:MetaspaceSize=10m -XX:MaxMetaspaceSize=10m
 */
public class MetaSpaceOOM extends ClassLoader{
    public static void main(String[] args) {
        int j = 0;
        try {
            MetaSpaceOOM test = new MetaSpaceOOM();
            for (int i = 0; i < 10000; i++) {
                Thread.sleep(10);
                ClassWriter classWriter = new ClassWriter(0);
                classWriter.visit(Opcodes.V1_6,Opcodes.ACC_PUBLIC,"Class " + i,null,"java/lang/Object",null);
                byte[] code = classWriter.toByteArray();
                test.defineClass("Class " + i, code, 0, code.length);
                j++;
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            System.out.println(j);
        }
    }
}
