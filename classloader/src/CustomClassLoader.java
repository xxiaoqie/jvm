import java.io.FileNotFoundException;
import java.net.URLClassLoader;

public class CustomClassLoader extends ClassLoader {

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try {
            byte[] result = getClassFromCustomPath(name);
            if(result == null) {
                throw new FileNotFoundException();
            } else {
                return defineClass(name,result,0,result.length);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return super.findClass(name);
    }

    private byte[] getClassFromCustomPath(String name) {
        return null;
    }

    public static void main(String[] args) {
        try {
            CustomClassLoader customClassLoader = new CustomClassLoader();
            Class<?> clazz = Class.forName("One", true, customClassLoader);
            Object obj = clazz.newInstance();
            System.out.println(obj.getClass().getClassLoader());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

    }
}
