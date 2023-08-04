package br.ce.ozeias.rest;

import static io.restassured.RestAssured.*;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.apache.groovy.json.internal.NumberValue;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.core.StringContains;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class OlaMundoTest {
	
	@Test
	public void testOlaMundo() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
    	System.out.println(response.getBody().asString().equals("Ola Mundo!"));
    	System.out.println(response.statusCode() ==200);
    	Assert.assertEquals(200,response.statusCode());
    	
    	ValidatableResponse validacao =  response.then();
    	validacao.statusCode(200);

	}
	
	@Test
	public void devoConhecerOutrasFormasTesAssure() {
		Response response = request(Method.GET, "http://restapi.wcaquino.me/ola");
        ValidatableResponse validacao =  response.then();
    	validacao.statusCode(200);
    	
    	get("http://restapi.wcaquino.me/ola").then().statusCode(200);
    	
    	given() //Pré condicoes  
    	.when() //Acao
    	    .get("http://restapi.wcaquino.me/ola")
    	.then() //Assertivas
    	     .statusCode(200);
	}
	
	@Test
	public void devoConhecerMatchersHamcrest() {
		Assert.assertThat("Maria", Matchers.is("Maria"));
		Assert.assertEquals("130d", Matchers.greaterThan(130d));
		Assert.assertEquals("120d", Matchers.lessThan(130d));
		
		assertThat("Maria", null);
	}
 
	
	@Test
	public void devoValidarBody() {
		given() //Pré condicoes  
    	.when() //Acao
    	    .get("http://restapi.wcaquino.me/ola")
    	.then() //Assertivas
    	     .statusCode(200)
    	     .body(Matchers.is("Ola Mundo!"))
    	     .body(Matchers.containsString("Mundo"));
    	     
		
	}


}
