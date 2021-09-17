import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;

public class TestClassLoader {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
			
			Object obj = new MyClassLoader().findClass("Hello").newInstance();
			Class<?> cls = obj.getClass();
			Method method = cls.getDeclaredMethod("hello");
			method.invoke(obj);
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
	}

}
