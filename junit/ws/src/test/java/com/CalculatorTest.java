package com;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.condition.EnabledForJreRange;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.JRE;
import org.junit.jupiter.api.condition.OS;

@TestInstance(TestInstance.Lifecycle.PER_CLASS) //default way to use a single object for all the test cases in asingle class .

@DisplayName("for calculations")
class CalculatorTest {
	
	 static Calculator c1; 
	 boolean flag=true;
	public CalculatorTest() {
		System.out.println("hi obj created");
	}
	
	@BeforeAll //runs before all tests
	public   void createCalc() //no need of static now as->(TestInstance.Lifecycle.PER_METHOD) 
	{
		c1 = new Calculator();
		System.out.println("*Started Testing*");
	}

	@AfterAll
	public   void removeCalc()  //no need of static now as->(TestInstance.Lifecycle.PER_METHOD) 
	{
		c1 = null;  //for dereferencing
		System.out.println("*Finished Testing*");
	}
	
	@BeforeEach //runs after every test
	public void createCalculator()
	{
		c1 = new Calculator();
		System.out.println("before each test case");
	}
	@AfterEach
	public void xyz() {
		System.out.println("after each test case");
	}

	@Test
	@Tag("Math")
	@DisplayName("Testing for Addition")  //give some meaningfull names
	void testAdd() {
		//Calculator c1 = new Calculator();(instead of creating objects every time we make it static and use it only once)
	    System.out.println("to add");
	    
		assertAll( //it will execute all the test cases even if some are wrong 
			()->assertEquals(30,c1.add(10,20)),
			()->assertEquals(40,c1.add(20,20)),
			()->assertEquals(120,c1.add(100,20)),
			()->assertEquals(-10,c1.add(10,-20))
			);	
	}

	
	@Test
	@Tag("Math")
	void testMul() {
		assumeTrue(flag);  //if true then this case will run else not
		//Calculator c1 = new Calculator();
		int actual = c1.mul(10, 20);
		int expected = 200;
		assertEquals(expected, actual,()->"multiply not working...");
		System.out.println("mult function");
	}
	
	@Test
	@Tag("Math")
	//@Disabled //you want a testcase but dont want to run
	void testSub() {
		//Calculator c1 = new Calculator();
		int actual=c1.sub(50,10);
	    int expected=40;		
		assertEquals(actual,expected,()->"sub not working");
		System.out.println("sub function1");
		
		assumeTrue(flag); //if flase below cases will not work
		
		assertEquals(10,c1.sub(20, 10),()->"sub not working");
		System.out.println("sub function2");
		assertEquals(10,c1.sub(20, 10),()->"sub not working");
		System.out.println("sub function3");
		}
	@Test
	@Tag("Math")
	public void testdiv(){
		int actual =c1.div(250, 5);
		int expected=50;
		assertEquals(expected,actual);
		assertThrows(ArithmeticException.class,()->c1.div(expected,0));
		System.out.println("div function");
	}
	
	@Test
	@Tag("Demo")
	void testdemo() 
	{   
		System.out.println("dummy test");
	}
	
	@Test
	@Tag("OS")
	@EnabledOnOs(OS.WINDOWS)
	public void testWindows() {
	System.out.println("");
	}
	
	@Test
	@Tag("OS")
	@EnabledOnOs(OS.LINUX)
	public void testLinux() {
	System.out.println("");
	}
	
	@Test
	@Tags(value= {@Tag("Demo"),@Tag("Java")})
	@EnabledForJreRange(min=JRE.JAVA_8 ,max=JRE.JAVA_11)
	public void testJava()
	{
	  System.out.println("For java only");
	}
	
	@Test
	@Tag("void")
	@DisplayName("Testing void function")
	public void testvoid(){
		c1.display();
		assertEquals(50,c1.getAns()); 
	}	
	@Test
	@Tag("invokeInterface")
	public void testinvoke() {
		
	}
		
	
	
}