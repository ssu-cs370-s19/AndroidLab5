package ssu.softwarednd.spring19.androidlab5.utility;

import com.google.gson.Gson;

import java.util.List;

import ssu.softwarednd.spring19.androidlab5.models.RecipeModel;
import ssu.softwarednd.spring19.androidlab5.models.RecipeResponse;

public class RecipeParser {

    // TAG is used in logging, to help trace where output comes from
    private static final String TAG = "RecipeParser";


    /**
     * Returns a list of RecipeModels, representing recipes in the json
     *
     * @param json String json representing the server's response
     * @return List of recipes (as RecipeModels)
     */
    public static List<RecipeModel> getMatches(String json) {

        // parse `json`, return a list of recipes

        //create an instance of Gson
        Gson gson = new Gson();

        //use Gson to inflate a RecipeResponse
        RecipeResponse response = gson.fromJson(json,RecipeResponse.class);

        //Get the list of recipes and return it
        return response.getRecipes();


    }

}
