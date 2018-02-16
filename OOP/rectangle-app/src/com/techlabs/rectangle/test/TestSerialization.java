package com.techlabs.rectangle.test;

import com.techlabs.rectangle.Rectangle;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class TestSerialization
{
    public static void main(String[] args)
    {
        try
        {
        	Rectangle rect = new Rectangle();
            FileOutputStream fos = new FileOutputStream("rectangle.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(rect);
            oos.close();
            fos.close();
            System.out.println("Serialization of object is completed.");
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}