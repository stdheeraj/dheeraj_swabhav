package com.techlabs.simuduck;

public abstract class Duck {

	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;

	public Duck() {

	}

	public void perfomFly() {
		flyBehavior.fly();
	}

	public void performQuack() {
		quackBehavior.quack();
	}

	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
	
	public abstract void display();

	public void setFlyBehavior(FlyBehavior fb) {
		flyBehavior = fb;
	}

	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}

}
