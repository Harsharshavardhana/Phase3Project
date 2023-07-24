package simplilearn.com.Phase3Project;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class API_Test extends ReusableMethods{

	@Test
	public static void main(String[] args)  { 
		// TODO Auto-generated method stub
		
		Response response = getEmployee();
		// validating ResponseCode as 200
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(numberOfEmployees, 7);
		
		
		response = createNewEmployee("John", "Dae", "100000", "johnDae@gmail.com");
		// validating ResponseCode as 200
		Assert.assertEquals(response.statusCode(), 201);
		// Validating the name in the response is John
		Assert.assertEquals(numberOfEmployees, 7);
		
		response = updateEmployee("8");
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(employeeName, "Tom");
		Assert.assertNotEquals(response.jsonPath().getString("firstName"), "John");
		

		response = getEmployee("8");
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(employeeName, "Tom");
	
		response = deleteEmployee("8");
		Assert.assertEquals(response.statusCode(), 200);
		response=getEmployee("8");
		Assert.assertNotEquals(response.jsonPath().getString("firstName"), "Tom");
		Assert.assertEquals(numberOfEmployees, 7);

		response=getEmployee("9");
		Assert.assertEquals(response.statusCode(), 404);
		
		
		
		response = getEmployee();
		Assert.assertEquals(response.statusCode(), 200);
		Assert.assertEquals(numberOfEmployees, 7);
		

	}
	

}
