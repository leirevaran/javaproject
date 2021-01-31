package fr.epita.services.test;

import org.junit.Assert;
import org.junit.Test;

import fr.epita.services.MathService;


public class MathServiceTest {
	
	
	@Test
	public void testFactorialWithPositiveInteger() {
		//given an integer i initialized to 5
		int i = 5;
		
		//when we execute factorial on i and store the result in res
		int res = MathService.factorial(i);
		
		//then we should expect 120 as a result
//		if (res != 100) {
//			throw new IllegalStateException("the returned result is not matching the requirements");
//		}else {
//			System.out.println("success : result = " +res );
//		}
		
		Assert.assertEquals(120, res);
		System.out.println("success : result = " +res );
		
	}

}
