package isp.refactor;


public class Manager implements IWorkableEatable {

	@Override
	public void startWork() {
		System.out.println("Manager start Working...");
	}

	@Override
	public void stopWork() {
		System.out.println("Manager stop Working...");
	}

	@Override
	public void startEat() {
		System.out.println("Manager start Eating...");
	}

	@Override
	public void stopEat() {
		System.out.println("Manager stop Eating...");
	}

}
