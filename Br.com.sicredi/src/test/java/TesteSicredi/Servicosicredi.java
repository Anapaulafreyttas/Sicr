package TesteSicredi;
import static io.restassured.RestAssured.given;
import org.junit.Test;
import org.junit.runner.Request;
import org.hamcrest.*;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import junit.*;


public class Servicosicredi {
	
	private Response response;
	private Request request;
	
   
	public void consultaCpfGET() {
	   String get = "http://localhost:8080/api/v1/restricoes/97093236014";
	   response = RestAssured.request(Method.GET,get);
		System.out.println("Esse é o status code do servico" + response.statusCode());
		System.out.println(response.asString());
		System.out.println(response.statusCode() == 400);
	}
   
   public void criarRestricao() {
	   given().log().all().contentType("application/json")
	   .body("{\r\n"
	   		+ "  \"nome\": \"turma 13 api\",\r\n"
	   		+ "  \"cpf\": 52762989043,\r\n"
	   		+ "  \"email\": \"email@email.com\",\r\n"
	   		+ "  \"valor\": 1200,\r\n"
	   		+ "  \"parcelas\": 3,\r\n"
	   		+ "  \"seguro\": true\r\n"
	   		+ "}").when().post("http://localhost:8080/api/v1/simulacoes").then().log().all().statusCode(201);
   }
  
   public void editarCadastro() {
	   given().log().all().contentType("application/json")
	   .body("{\r\n"
	   		+ "  \"nome\": \"turma 13 api\",\r\n"
	   		+ "  \"cpf\": 52762989043,\r\n"
	   		+ "  \"email\": \"turma14email@email.com\",\r\n"
	   		+ "  \"valor\": 1200,\r\n"
	   		+ "  \"parcelas\": 3,\r\n"
	   		+ "  \"seguro\": true\r\n"
	   		+ "}").when().put("http://localhost:8080/api/v1/simulacoes/52762989043").then().log().all().statusCode(200);
   }
   @Test
   public void deletar() {
	   given().log().all().when().delete("http://localhost:8080/api/v1/simulacoes/16o")
	   .then().log().all().statusCode(200);
   }
}
