package br.ce.ozeias.rest;

import org.hamcrest.Matchers;
import org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

import java.util.Arrays;

public class UserJsonTest {

	
	@Test
	public void deveVerificarPrimeiroNivel() {
		given()
		.when()
		    .get("https://restapi.wcaquino.me/users/1")
		.then()
		     .statusCode(200)
		     .body("id", Matchers.is(1))
		     .body("name", Matchers.containsString("Silva"))
		     .body("age", Matchers.greaterThan(18));
	}
	
	
	@Test
	public void deveVerificarSegundoNivel() {
		given()
		.when()
		    .get("https://restapi.wcaquino.me/users/2")
		.then()
		     .statusCode(200)
		     .body("id", Matchers.is(2))
		     .body("name", Matchers.containsString("Maria Joaquina"))
		     .body("endereco.rua", Matchers.is("Rua dos bobos"));
	}
	
	
	@Test
	public void deveRetornarErroUsuarioInesistente() {
		given()
		.when()
		    .get("https://restapi.wcaquino.me/users/4")
		.then()
		     .statusCode(404)
		     .body("error", Matchers.is("Usuário inexistente"));
		   
		
	}
	
	@Test
	public void deveVerificarListaRaiz() {
		given()
		.when()
		    .get("https://restapi.wcaquino.me/users")
		.then()
		     .statusCode(200)
		     .body("$", Matchers.hasSize(3))
		     .body("name", Matchers.hasItems("João da Silva", "Maria Joaquina", "Ana Júlia"))
		     .body("age[1]", Matchers.is(25))
		     .body("filhos.name", Matchers.hasItem(Arrays.asList("Zezinho", "Luizinho")));
		     
		   
		
	}
	
}
