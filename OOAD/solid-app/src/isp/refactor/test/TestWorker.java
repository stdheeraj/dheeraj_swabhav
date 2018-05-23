package isp.refactor.test;

import isp.refactor.IEatable;
import isp.refactor.IWorkable;
import isp.refactor.Manager;
import isp.refactor.Robot;

public class TestWorker {
	
	public static void main(String[] args) {
		atTheWorkStation(new Manager());
		atTheCafeteria(new Manager());
		
		System.out.println();
		atTheWorkStation(new Robot());

	}
	
	private static void atTheWorkStation(IWorkable w){
		System.out.println("At the work station ->");
		w.startWork();
		w.stopWork();
	}
	
	private static void atTheCafeteria(IEatable w){
		System.out.println("At the cafeteria ->");
		w.startEat();
		w.stopEat();
	}	

}
