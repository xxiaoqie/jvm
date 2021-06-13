import sun.misc.Launcher;

import java.net.URL;

/**
 * 四者之间为包含关系，不是上层下层，也不是父子类的继承关系
 * bootstrap -> extension -> system -> userdefined
 */

public class ClassLoaderTest {
    public static void main(String[] args) {
        //获取系统类加载器  AppClassLoader
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader); //sun.misc.Launcher$AppClassLoader@18b4aac2

        //上层：扩展类加载器 ExtClassLoader      //sun.misc.Launcher$ExtClassLoader@1b6d3586
        ClassLoader extClassLoader = systemClassLoader.getParent();
        System.out.println(extClassLoader);

        //上层：bootstrapClassLoader       //null
        // 1. 使用C/C++语言实现，嵌套在JVM内部
        // 2. 用来加载Java核心库(JAVA_HOME/jre/lib/rt(runtime).jar、resources.jar或sun.boot.class.path路径下的内容)
        // 3. 并不继承自 java.lang.ClassLoader，没有父加载器
        // 4. 加载扩展类和应用程序类加载器，并指定为他们的父类加载器
        // 5. 出于安全考虑，BootStrap启动类加载器只加载包名为java、javax、sun等开头的类
        ClassLoader bootstrapClassLoader = extClassLoader.getParent();
        System.out.println(bootstrapClassLoader);

        //用户自定义类来说默认使用系统类加载器     //sun.misc.Launcher$AppClassLoader@18b4aac2
        System.out.println(ClassLoaderTest.class.getClassLoader());

        //  JAVA核心类库 使用引导类加载器
        System.out.println(String.class.getClassLoader());  //null

        System.out.println("***********启动类加载器能够加载API的路径***********");
        URL[] urls = Launcher.getBootstrapClassPath().getURLs();
        for (URL url : urls) {
            System.out.println(url.toExternalForm());
        }


        System.out.println("***********扩展类加载器能够加载API的路径***********");
        String extDirs = System.getProperty("java.ext.dirs");
        for (String path : extDirs.split(";")) {
            System.out.println(path);
        }


    }
}
