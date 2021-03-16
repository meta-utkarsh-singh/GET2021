package com.get.zoomanagement;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestZoo {

	@Test
	public void testAddZoo() {
		Zoo zoo = new Zoo(4);
		Zone z1 = new Zone(1,1,"Mammal",true);
		Zone z2 = new Zone(1,2,"Bird",true);
		Zone z3 = new Zone(1,3,"Reptile",true);
		Cage c1 = new Cage (4, "Lion", "Mammal");
		Cage c2 = new Cage (4, "Sparrow", "Bird");
		Cage c3 = new Cage (4, "Snake", "Reptile");
		assertEquals(1, z1.addCage(c1));
		assertEquals(1, z2.addCage(c2));
		assertEquals(1, z3.addCage(c3));
		assertEquals(1,zoo.addZone(z1));
		assertEquals(1,zoo.addZone(z2));
		assertEquals(1,zoo.addZone(z3));
	}
	@Test
	public void testAddAnimal(){
		Zoo zoo = new Zoo(4);
		Zone z1 = new Zone(1,1,"Mammal",true);
		Zone z2 = new Zone(1,2,"Bird",true);
		Zone z3 = new Zone(1,3,"Reptile",true);
		Cage c1 = new Cage (4, "Lion", "Mammal");
		Cage c2 = new Cage (4, "Sparrow", "Bird");
		Cage c3 = new Cage (4, "Snake", "Reptile");
		z1.addCage(c1);
		z2.addCage(c2);
		z3.addCage(c3);
		zoo.addZone(z1);
		zoo.addZone(z2);
		zoo.addZone(z3);
		Lion l = new Lion("abc",5,60);
		assertEquals(1,zoo.addAnimal(l));
	}
	@Test
	public void testRemoveAnimal(){
		Zoo zoo = new Zoo(4);
		Zone z1 = new Zone(1,1,"Mammal",true);
		Zone z2 = new Zone(1,2,"Bird",true);
		Zone z3 = new Zone(1,3,"Reptile",true);
		Cage c1 = new Cage (4, "Lion", "Mammal");
		Cage c2 = new Cage (4, "Sparrow", "Bird");
		Cage c3 = new Cage (4, "Snake", "Reptile");
		z1.addCage(c1);
		z2.addCage(c2);
		z3.addCage(c3);
		zoo.addZone(z1);
		zoo.addZone(z2);
		zoo.addZone(z3);
		Lion l = new Lion("abc",5,60);
		Lion l2 = new Lion("def",5,60);
		zoo.addAnimal(l);
		zoo.addAnimal(l2);
		assertEquals(1,zoo.removeAnimal(2));
		
	}

}
