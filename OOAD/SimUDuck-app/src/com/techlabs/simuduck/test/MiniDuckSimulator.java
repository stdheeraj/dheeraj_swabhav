package com.techlabs.simuduck.test;

import com.techlabs.simuduck.Duck;
import com.techlabs.simuduck.FlyRocketPowered;
import com.techlabs.simuduck.MallardDuck;
import com.techlabs.simuduck.ModelDuck;

public class MiniDuckSimulator {

	public static void main(String[] args) {
		Duck mallard = new MallardDuck();
		mallard.display();
		mallard.performQuack();
		mallard.perfomFly();

		System.out.println();
		
		Duck model = new ModelDuck();
		model.display();
		model.perfomFly();
		model.setFlyBehavior(new FlyRocketPowered());
		model.perfomFly();

	}

}
