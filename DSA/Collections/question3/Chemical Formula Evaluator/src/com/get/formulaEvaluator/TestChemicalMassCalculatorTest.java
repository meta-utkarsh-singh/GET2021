package com.get.formulaEvaluator;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestChemicalMassCalculatorTest {

	@Test
	public void testGetMass1() {
		String s = "CO(HCO)2";
		ChemicalMassCalculator cmc = new ChemicalMassCalculator();
		assertEquals(86, cmc.getMass(s));
	}
	@Test
	public void testGetMass2() {
		String s = "CO3";
		ChemicalMassCalculator cmc = new ChemicalMassCalculator();
		assertEquals(60, cmc.getMass(s));
	}
	@Test
	public void testGetMass3() {
		String s = "(CO3)2";
		ChemicalMassCalculator cmc = new ChemicalMassCalculator();
		assertEquals(120, cmc.getMass(s));
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testGetMassError1() {
		String s = "";
		ChemicalMassCalculator cmc = new ChemicalMassCalculator();
		assertEquals(120, cmc.getMass(s));
	}
	@org.junit.Test(expected = AssertionError.class)
	public void testGetMassError2() {
		String s = "(CON2)3";
		ChemicalMassCalculator cmc = new ChemicalMassCalculator();
		assertEquals(120, cmc.getMass(s));
	}
}
