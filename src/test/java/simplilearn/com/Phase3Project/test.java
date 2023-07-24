package simplilearn.com.Phase3Project;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String jsonString = "{\"name\" : \"kanak\",\"password\" : \"kanak123\"}";

		RequestSpecification request = RestAssured.given();

		request.contentType(ContentType.JSON);

		request.baseUri("http://localhost:3000/employees");

		request.body(jsonString);

		Response response = request.post();

		System.out.println(response.asString());

		ValidatableResponse validatableResponse = response.then();

		validatableResponse.statusCode(201);

		System.out.println(response.getStatusCode());
		System.out.println(response.getTime());
	}
	}


