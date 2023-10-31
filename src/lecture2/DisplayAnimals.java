package lecture2;

import java.util.ArrayList;
import java.util.List;

public class DisplayAnimals {
	
	public static void getAnimalSound(List<Animal > animals) {
		for (Animal a : animals) {
			a.animalSound();
		} //Another method
	}
	

	public static void getAnimalSleep(List<Animal > animals) {
		for (Animal a : animals) {
			a.sleep();
		} //Another method faster and cleaner
	}
	
	
	

		public static void main(String[] args) {
			
			
			Pig myPig = new Pig();
			myPig.animalSound();
			myPig.sleep();

			Cow myCow = new Cow();
			myCow.animalSound();
			myCow.sleep();
			
			Dog bigDog = new Dog();
			bigDog.animalSound();
			bigDog.sleep();
			
			Pig myPig2 = new Pig();

			
			//Another method 
			
			List<Animal> animals = new ArrayList<>();//creates an array, List is a java interface
			animals.add(new Dog());
			animals.add(myPig2);
			animals.add(new Cow());
			DisplayAnimals.getAnimalSound(animals);
			DisplayAnimals.getAnimalSleep(animals);
			
			//using lamdba function
			Runnable lambdafxn = () -> {
				for (Animal a : animals) {
					a.animalSound(); 
					a.sleep();
					}
				};
			lambdafxn.run();

			
			
		}
	}

