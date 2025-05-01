package Capstone.RESTAssured;

import io.restassured.RestAssured;

import io.restassured.response.Response;

import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import Utils.ExcelUtility;

import static org.hamcrest.Matchers.equalTo;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

public class APITest{
	
	@DataProvider(name = "excelData")

	public Object[][] excelDataProvider() throws IOException {

		return ExcelUtility.excelData("C://Users//ravi//Desktop//TestData.xlsx", "Sheet1");

	}

@Test(dataProvider = "excelData")

	public void validateTitle(String translation) {

		RestAssured.baseURI = "https://restcountries.com";

		Response response = RestAssured.given().log().all()

				.pathParam("translation", translation)

				.when()

				.get("v3.1/translation/{translation}");
		
		response.then().log().all();

		// Validate the response
//		response.then().assertThat()
//
//		.statusCode(200)
//
//		.body("title", equalTo(expectedTitle));

	}


}