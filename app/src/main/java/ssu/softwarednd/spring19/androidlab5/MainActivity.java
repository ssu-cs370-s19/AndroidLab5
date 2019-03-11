package ssu.softwarednd.spring19.androidlab5;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import ssu.softwarednd.spring19.androidlab5.models.RecipeModel;
import ssu.softwarednd.spring19.androidlab5.network.RecipeSearchAsyncTask;

public class MainActivity extends AppCompatActivity {

    private EditText searchEditText;
    private Button searchButton;

    private TextView recipeName;
    private TextView recipeRating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchEditText = findViewById(R.id.search_edit_text);
        searchButton = findViewById(R.id.recipe_search_button);

        recipeName = findViewById(R.id.recipe_name);
        recipeRating = findViewById(R.id.recipe_rating);


        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecipeSearchAsyncTask task = new RecipeSearchAsyncTask();
                task.setRecipeListener(new RecipeSearchAsyncTask.RecipeListener() {
                    @Override
                    public void onRecipeCallback(List<RecipeModel> models) {
                        RecipeModel first = models.get(0);
                        recipeName.setText(first.getRecipeName());
                        recipeRating.setText("Rating: " + first.getRating());
                    }
                });
                task.execute(searchEditText.getText().toString());
            }
        });
    }
}
