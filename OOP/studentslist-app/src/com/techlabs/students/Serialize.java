package com.techlabs.students;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Serialize {

	public void serializeStudentList(Students s) {
		try {
			FileOutputStream fos = new FileOutputStream("data/students.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(s);
			oos.close();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void deserializeStudentList() {
		try {
			FileInputStream fis = new FileInputStream("data/students.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Students sl = (Students) ois.readObject();

			System.out.println("List of Student :: ");
			for (String student : sl.sl)
				System.out.println(student + " ");

			ois.close();
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
