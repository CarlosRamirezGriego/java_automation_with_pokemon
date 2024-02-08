package pokemonapi.businesslogic;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import pokemonapi.apiclients.PokemonAPIClient;
import pokemonclasses.Pokemon;
import pokemonclasses.PokemonType;
import pokemonclasses.PokemonTypeSettings;
import java.util.ArrayList;
import java.util.List;

public class PokemonAPILogic {

    private static Response pokemon_name(String namePokemon)
    {
        PokemonAPIClient apiClient = new PokemonAPIClient();
        Response response = apiClient.pokemon_name(namePokemon);
        return response;
    }


    private static Response pokemon_number(int pokemonNumber)
    {
        PokemonAPIClient apiClient = new PokemonAPIClient();
        Response response = apiClient.pokemon_number(pokemonNumber);
        return response;
    }



    public static boolean doesThisPokemonExists(String namePokemon)
    {
        Response response = PokemonAPILogic.pokemon_name(namePokemon.toLowerCase().trim());
        int statusCode = response.statusCode();
        boolean isPresent = statusCode == 200;
        return isPresent;
    }


    public static boolean doesThisPokemonExists(int pokemonNumber)
    {
        Response response = PokemonAPILogic.pokemon_number(pokemonNumber);
        int statusCode = response.statusCode();
        boolean isPresent = statusCode == 200;
        return isPresent;
    }


    public static Pokemon returnPokemonInformation(String pokemonName) {
        Pokemon targetPokemon = new Pokemon();
        if(doesThisPokemonExists(pokemonName))
        {

            Response response = pokemon_name(pokemonName);

            targetPokemon = response.jsonPath().getObject("", Pokemon.class);

            List<PokemonTypeSettings> pokemonTypes = getThisPokemonTypesFromAPIResponse(response);
            for(PokemonTypeSettings pokemonType : pokemonTypes)
            {
                targetPokemon.addType(pokemonType);
            }

        }
        else
        {
            System.out.println("The Pokemon ${pokemonName} doesnt Exist");
        }
        return targetPokemon;
    }


    public static String getThisPokemonNameFromAPIResponse(Response response)
    {
        JsonPath pokemonData = new JsonPath(response.getBody().asString());
        String name = pokemonData.getString("name");
        return name;
    }

    public static int getThisPokemonNumberFromAPIResponse(Response response)
    {
        JsonPath pokemonData = new JsonPath(response.getBody().asString());
        int id = pokemonData.getInt("id");
        return id;
    }


    public static List<PokemonTypeSettings> getThisPokemonTypesFromAPIResponse(Response response)
    {
        List<PokemonTypeSettings> pokemonTypesSettings = new ArrayList<>();
        List<PokemonType> pokemonTypes = response.jsonPath().getList("types.type", PokemonType.class);
        int index = 0;
        for(PokemonType pokemonType : pokemonTypes)
        {
            pokemonType.setIdFromDataEndpoint();
            String dynamicJsonPath = String.format("types[%d].slot", index);
            int slot = response.jsonPath().getInt(dynamicJsonPath);
            PokemonTypeSettings typeSettingsObject = new PokemonTypeSettings(pokemonType, slot);
            pokemonTypesSettings.add(typeSettingsObject);
            index++;
        }
        return pokemonTypesSettings;
    }
}
