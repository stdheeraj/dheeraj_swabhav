package com.techlabs.factory.method.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.techlabs.factory.method.IAutoFactory;
import com.techlabs.factory.method.IAutomobile;

public class TestAutomobile {

	public static void main(String[] args) {

		IAutoFactory f = createFactory();

		IAutomobile auto = f.make();
		auto.start();
		auto.stop();

	}

	private static IAutoFactory createFactory() {
		Properties prop = new Properties();
		InputStream input = null;
		IAutoFactory autofactory = null;

		try {

			input = new FileInputStream("H:/my/Techlabs/Cloud Repository/designPattern-workspace/factory-method-app/src/com/techlabs/factory/method/factory.properties");
			prop.load(input);
			String className = prop.getProperty("factoryToCreate");
			Class<IAutoFactory> tempfactory = (Class<IAutoFactory>) Class.forName(className);
			autofactory = tempfactory.newInstance();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return autofactory;
	}

}
