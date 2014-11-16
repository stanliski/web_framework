/**
 * 
 */
package com.jufengniao.framework.tools;

import java.lang.reflect.Field;


/**
 * @author clientE
 *
 */
public class CommonAssemble {
	
	public static void set(Object po,Object dto){
		if(dto != null){
			try {
				Field[] poFields = getAllField(po);
				for(Field f : getAllField(dto)){
					f.setAccessible(true);
					if(!f.getName().equals("serialVersionUID") && f.get(dto) != null){
						for(Field poField : poFields){
							poField.setAccessible(true);
							if(poField.getName().equals(f.getName())){
								poField.set(po, f.get(dto));
							}
						}
					}
					
				}
			} catch (SecurityException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static Field[] getAllField(Object object){
		Field[] superField = object.getClass().getSuperclass().getDeclaredFields();
		Field[] field = object.getClass().getDeclaredFields();
		Field[] all = new Field[superField.length + field.length];
		System.arraycopy(field, 0, all, 0, field.length);
		System.arraycopy(superField, 0, all, field.length, superField.length);
		return all;
	}
	
	public static void main(String[] s){
		System.out.println(Math.ceil(Float.valueOf(11)/2));
	}

}
