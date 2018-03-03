package com.techlabs.annotation.test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import com.techlabs.annotations.Foo;

public class TestAnnotation {
	public static void main(String args[]) {

		Foo f = new Foo();
		Method[] methods = f.getClass().getDeclaredMethods();

		for (int m = 0; m < methods.length; m++) {
			Annotation[] annotations = methods[m].getAnnotations();
			for (int i = 0; i < annotations.length; i++)
				System.out.println("Annotation : " + annotations[i]);
		}
	}
}