package isp.violation.test;

import isp.violation.IWorker;
import isp.violation.Manager;
import isp.violation.Robot;

public class TestWorker {

	public static void main(String[] args) {
		atTheWorkStation(new Manager());
		atTheCafeteria(new Manager());
		
		System.out.println();
		atTheWorkStation(new Robot());
		atTheCafeteria(new Robot());

	}
	
	private static void atTheWorkStation(IWorker w){
		System.out.println("At the work station ->");
		w.startWork();
		w.stopWork();
	}
	
	private static void atTheCafeteria(IWorker w){
		System.out.println("At the cafeteria ->");
		w.startEat();
		w.stopEat();
	}

}
