package br.ce.ozeias.rest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matchers;
import org.junit.Test;

public class devoUnirJsonPathComJAVA {
	
	@Test
	public void devoUnirJsonPathComJava() {
		given()
		.when()
		    .get("https://restapi.wcaquino.me/users")
		.then()
		     .statusCode(200)
		     .extract().path("")
		     ;
		
	}

}
