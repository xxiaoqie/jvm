import java.sql.DriverManager;

public class Test {
    public static void main(String[] args) {
        ClassLoaderTest classLoaderTest = new ClassLoaderTest();
        System.out.println(classLoaderTest.getClass());
        System.out.println(ClassLoaderTest.class);
        System.out.println(classLoaderTest.getClass() == ClassLoaderTest.class);
        try {
            //1.
            System.out.println(Class.forName("java.lang.String").getClassLoader());
            //2.
            System.out.println(Thread.currentThread().getContextClassLoader());
            //3.
            System.out.println(ClassLoader.getSystemClassLoader());
            //4.DriverManager
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String bb = new String();
        System.out.println(bb.getClass().getClassLoader());

    }
}
