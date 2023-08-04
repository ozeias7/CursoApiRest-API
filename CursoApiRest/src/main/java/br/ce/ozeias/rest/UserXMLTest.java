package br.ce.ozeias.rest;

import static io.restassured.RestAssured.given;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.assertion.BodyMatcher;


public class UserXMLTest {
	
	@BeforeClass
	public static void setup() {
		  RestAssured.baseURI = "https://restapi.wcaquino.me";
//		  RestAssured.port = 80;
//		  RestAssured.basePath = "/v2";
		
	}
	
	@Test
	public void devoTrabaharComXML( ) {
		
		given()
		.log().all()
		.when()
		    .get("/usersXML/3")
		.then()
		.statusCode(200)
		.rootPath("user")
		.body("name", Matchers.is("Ana Julia"))
		.body("@id", Matchers.is("3"))
		.body("filhos.name[0]", Matchers.is("Zezinho"))
		.body("filhos.name", Matchers.hasItems("Luizinho", "Zezinho"))
		;
	}

	
	
	
	@Test
	public void devoTrabaharComXMLAvancado( ) {
		given()
		.when()
		    .get("/usersXML")
		.then()
		.statusCode(200)
		.body("users.user.size()", Matchers.is(3))
		.body("users.user.findAll{it.age.toInteger() <=25}.size()", Matchers.is(2))
		.body("users.user.find{it.age ==25}.name", Matchers.is("Maria Joaquina"));
	}



   @Test
   public void devoTrabaharComXMLL( ) {

	
	given()
	.log().all()
	.when()
	    .get("/usersXML/3")
	.then()
	.statusCode(200)
	.rootPath("user")
	.body("name", Matchers.is("Ana Julia"))
	.body("@id", Matchers.is("3"))
	.body("filhos.name[0]", Matchers.is("Zezinho"))
	.body("filhos.name", Matchers.hasItems("Luizinho", "Zezinho"));
  }

}









