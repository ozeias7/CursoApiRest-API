package br.ce.ozeias.rest;

import static io.restassured.RestAssured.given;


import java.util.Arrays;

import org.hamcrest.Matchers;
import org.junit.Test;

public class UserJsonTestAvancadas {
	
	@Test
	public void deveVerificarListaRaizAvansadas() {
		given()
		.when()
		    .get("https://restapi.wcaquino.me/users")
		.then()
		     .statusCode(200)
		     .body("$", Matchers.hasSize(3))
		     .body("age.findAll{it <= 25}.size()", Matchers.is(2))
		     .body("age.findAll{it <= 25 && it >20}.size()", Matchers.is(1))
		     .body("findAll{it.age <= 25 && it.age >20}.name", Matchers.hasItem("Maria Joaquina"))
		     .body("findAll{it.age <= 25}[0].name", Matchers.is("Maria Joaquina"))
		     .body("findAll{it.age <= 25}[-1].name", Matchers.is("Ana Júlia"))
		     .body("find{it.age <= 25}.name", Matchers.is("Maria Joaquina"));
		   
		
	}

}
