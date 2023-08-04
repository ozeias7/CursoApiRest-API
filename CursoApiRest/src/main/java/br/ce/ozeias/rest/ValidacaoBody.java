package br.ce.ozeias.rest;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.request;
import static org.junit.Assert.assertThat;

import org.apache.commons.lang3.ObjectUtils.Null;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class ValidacaoBody {

 
	
	@Test
	public void devoValidarBody() {
		given() //Pré condicoes  
    	.when() //Acao
    	    .get("http://restapi.wcaquino.me/ola")
    	.then() //Assertivas
    	     .statusCode(200)
    	     .body(Matchers.is("Ola Mundo!"))
    	     .body(Matchers.containsString("Mundo"))
    	     .body(Matchers.is(null));
		
    	    
	}

	
}
