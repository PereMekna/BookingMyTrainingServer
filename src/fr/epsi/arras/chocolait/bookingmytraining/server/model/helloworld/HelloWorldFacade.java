package fr.epsi.arras.chocolait.bookingmytraining.server.model.helloworld;

import java.util.ArrayList;
import java.util.List;

public class HelloWorldFacade {
	public HelloWorld getNewHelloWorld() {
		HelloWorld helloWorld = new HelloWorld();
		helloWorld.setHello("Hello");
		helloWorld.setWorld("world");
		return helloWorld;
	}
	
	public List<HelloWorld> getAllHelloWorld() {
		List<HelloWorld> listHelloWorld = new ArrayList<HelloWorld>();
		for (int i = 0; i < 10; i++) {
			HelloWorld helloWorld = new HelloWorld();
			helloWorld.setHello("Hello" + i);
			helloWorld.setWorld("world" + i);
			listHelloWorld.add(helloWorld);
		}
		return listHelloWorld;
	}
}
