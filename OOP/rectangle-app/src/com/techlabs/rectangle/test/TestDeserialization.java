package com.techlabs.rectangle.test;


import java.io.FileInputStream;
import java.io.ObjectInputStream;

import com.techlabs.rectangle.Rectangle;

public class TestDeserialization
{
    public static void main(String[] args)
    {
    	
        try
        {
            FileInputStream fis = new FileInputStream("rectangle.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Rectangle rect = (Rectangle)ois.readObject();
            
            System.out.println(rect.getWidth());
            System.out. println(rect.getHieght());
            System.out.println(rect.calculateArea());
            
            ois.close();
        }
        catch (Exception e)
        {
            e.printStackTrace(); }
        }
}