package test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

interface Vehicle{
	void start();
	void stop();
	
	default void moonRoof(){
		System.out.println("Vehicle requires wash .....!!!!");
	}
}

class Car implements Vehicle{

	public void start() {
		System.out.println("Car has started .....!!!!");
	}

	public void stop() {
		System.out.println("Car has stopped .....!!!!");
	}
	
	public void moonRoof(){
		System.out.println("Car requires wash .....!!!!");
	}
	
}

 class Truck implements Vehicle{

	public void start() {
		System.out.println("Truck has started .....!!!!");
	}

	public void stop() {
		System.out.println("Truck has stopped .....!!!!");
	}
	
}


public class TestInterface {
	
	public void testInterface(Vehicle v){
		v.start();
		v.stop();
		v.moonRoof();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Vehicle veh = new Truck();
		TestInterface testInterface = new TestInterface();
		testInterface.testInterface(veh);
		
		
		Collection<String> color = new ArrayList<>();
		color.add("red");
		color.add("blue");
		color.add("grey");
		System.out.println();
		for(String s:color){
			System.out.print(s+", ");
		}
		
		Map<String, Collection<String>> myMap = new HashMap<>();
		
		myMap.put("Honda", color);
		myMap.put("BMW", color);
		myMap.put("Ford", color);
		System.out.println("---------------");
		
		String c = "red";
		
		System.out.println(testInterface.checkColor(myMap, c));
		System.out.println(myMap.get("BMW")!=null?myMap.get("Ford").contains("grey"):false);
		
		
		
		
		//{"Honda", "red, blue, grey"}
		//{"BMW", "red, blue, grey"}
		
	}
	
	public boolean checkColor(Map<String, Collection<String>> myMap, String col)
	{
	for(Map.Entry<String, Collection<String>> m:myMap.entrySet()){
		if(m.getKey().equals("BMW")){
			for(String str:m.getValue()){
				if(str.equals(col)){
					return true;
				}
			}
		}
	}
	return false;
	}

}
