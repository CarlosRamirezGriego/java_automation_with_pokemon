package pokemonapi.apiclients;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PokemonAPIClient {

    public String baseUrl = "https://pokeapi.co/";

    public Response pokemon_name(String namePokemon)
    {
        RestAssured.baseURI = this.baseUrl + "api/v2/pokemon/" + namePokemon;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        return response;
    }


    public Response pokemon_number(int pokemonNumber)
    {
        RestAssured.baseURI = this.baseUrl + "api/v2/pokemon/" + pokemonNumber;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.get();
        return response;
    }

}
