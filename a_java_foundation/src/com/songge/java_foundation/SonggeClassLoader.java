package com.songge.java_foundation;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Array;

/**  
* @ClassName: SonggeClassLoader  
* @Description: TODO(这里用一句话描述这个类的作用)  
* @author songge  
* @date 2018年1月31日  
*    
*/
public class SonggeClassLoader extends ClassLoader {

	public static void main(String arg[]) {
		ClassLoader loader = SonggeClassLoader.class.getClassLoader();
		System.out.println(loader.getClass().getName());
		System.out.println(loader.getParent().toString());
		System.out.println(loader.getParent().getParent());
		try {
			Object obj = (Class.forName("com.songge.java_foundation.ClassForNameTest")).newInstance();
			ClassForNameTest cfnt = (ClassForNameTest)obj;
			System.out.println(cfnt.value_test);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ClassLoader cl = new SonggeClassLoader();
		try {
			Class<?> test_c = cl.loadClass("com.songge.java_foundation.ClassForNameTest");
			Method method = test_c.getMethod("test_method", String.class);
			Field field = test_c.getField("value_test");
		
			
			Object obj = test_c.newInstance();
			System.out.println(method.invoke(obj, "input_info"));
			System.out.println(field.get(obj));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] a = {};
		
		System.out.println(a.getClass().getComponentType());
	}
}
