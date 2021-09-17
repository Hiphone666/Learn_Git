import java.io.*;

public class MyClassLoader extends ClassLoader {
	
	@Override 
	protected Class<?> findClass(String name) throws ClassNotFoundException {

		try {
			
			FileInputStream fileInputStream = new FileInputStream("Hello.xlass");
			
			int len = fileInputStream.available();
			byte[] byteArray = new byte[len];
			
			fileInputStream.read(byteArray,0,len);
			
			fileInputStream.close();
			
			System.out.println("\n File's Length is :" + byteArray.length);
			
			if (byteArray.length == 0) {

				return null;
			}

			//decrypt, y = 255 - (255 - y)
			for (int i = 0; i < byteArray.length; i++ ) {
				
				byteArray[i] = (byte)( ((byte)255) - byteArray[i]);
			}

			for (byte b : byteArray) {
				
				System.out.print(b);
			}

			System.out.println("\n============\n");

			return defineClass(name, byteArray, 0, byteArray.length);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return null;
		} 
	}
}
