package week3.day1.InterfaceAndAbstractClass;

public class ConcreteClass implements DatabseConnection {

	@Override
	public void connect() {
		System.out.println("connect() - It is used to establish a db connection");
		
	}

	@Override
	public void disconnect() {
		System.out.println("disconnec() - tIt is used to terminate a db connection");
		
	}

	@Override
	public void executeUpdate() {
		System.out.println("executeUpdate() - It is used to execute a update command");
		
	}

	
	public static void main(String[] args) {
		
		ConcreteClass c = new ConcreteClass();
		c.connect();
		c.disconnect();
		c.executeUpdate();
	}
}
