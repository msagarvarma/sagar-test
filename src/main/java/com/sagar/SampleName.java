package com.sagar;

import java.lang.reflect.*;
import java.awt.*;

class SampleName {
	private double d;
	public static final int i = 37;
	private String s = "testing";
	private int x, y;

	public SampleName() {
		System.out.println("Constructor1");
	}

	public SampleName(int x) {
		this.x = x;
	}

	public SampleName(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public static void main(String[] args) {

		Button b = new Button();

		try {
			Class cls = Class.forName("SampleName");
			System.out.println("Finding Out About Class Fields");
			Field fieldlist[] = cls.getDeclaredFields();
			for (int i = 0; i < fieldlist.length; i++) {
				Field fld = fieldlist[i];
				System.out.println("name= " + fld.getName());
				System.out.println("decl class = " + fld.getDeclaringClass());
				System.out.println("type = " + fld.getType());
				int mod = fld.getModifiers();
				System.out.println("modifiers = " + Modifier.toString(mod));
				System.out.println("-----");
			}
			System.out.println("Invoking Methods by Name");
			Class partypes[] = new Class[2];
			partypes[0] = Integer.TYPE;
			partypes[1] = Integer.TYPE;
			Method meth = cls.getMethod("add", partypes);
			SampleName methobj = new SampleName();
			Object arglist[] = new Object[2];
			arglist[0] = new Integer(37);
			arglist[1] = new Integer(47);
			Object retobj = meth.invoke(methobj, arglist);
			Integer retval = (Integer) retobj;
			System.out.println(retval.intValue());

			System.out.println("Obtaining Information About Constructors");
			Constructor ctorlist[] = cls.getDeclaredConstructors();
			for (int i = 0; i < ctorlist.length; i++) {
				Constructor ct = ctorlist[i];
				System.out.println("name  = " + ct.getName());
				System.out.println("decl class = " + ct.getDeclaringClass());
				Class pvec[] = ct.getParameterTypes();
				for (int j = 0; j < pvec.length; j++)
					System.out.println("param #" + j + " " + pvec[j]);
				Class evec[] = ct.getExceptionTypes();
				for (int j = 0; j < evec.length; j++)
					System.out.println("exc #" + j + " " + evec[j]);
				System.out.println("-----");
			}
			System.out.println("Creating New Objects");

			Class partypes1[] = new Class[2];
			partypes1[0] = Integer.TYPE;
			partypes1[1] = Integer.TYPE;
			Constructor ct1 = cls.getConstructor(partypes1);
			Object arglist1[] = new Object[2];
			arglist1[0] = new Integer(37);
			arglist1[1] = new Integer(47);
			Object retobj1 = ct1.newInstance(arglist1);

			System.out.println("Using Arrays");
			Class cls1 = Class.forName("java.lang.String");
			Object arr = Array.newInstance(cls1, 10);
			Array.set(arr, 5, "this is a test");
			String s = (String) Array.get(arr, 5);
			System.out.println(s);

		} catch (Throwable e) {
			System.err.println(e);
		}
		System.out.println("Getting the Class Name");
		printName(b);// Getting the Class Name
		SampleName sName = new SampleName();
		System.out.println("Discovering Class Modifiers");
		printModifiers(sName.s);// Discovering Class Modifiers

	}

	public int add(int a, int b) {
		return a + b;
	}

	public static void printName(Object o) {
		Class c = o.getClass();// retrieving a class object
		String s = c.getName();// name of a Class object by
		// invoking the getName method

		System.out.println(s);
	}

	public static void printModifiers(Object o) {
		Class c = o.getClass();
		int m = c.getModifiers();
		if (Modifier.isPublic(m))
			System.out.println("public");
		if (Modifier.isAbstract(m))
			System.out.println("Abstract");
		if (Modifier.isFinal(m))
			System.out.println("final");
	}
}
