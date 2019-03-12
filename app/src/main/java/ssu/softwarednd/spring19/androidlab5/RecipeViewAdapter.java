package ssu.softwarednd.spring19.androidlab5;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import ssu.softwarednd.spring19.androidlab5.models.RecipeModel;


public class RecipeViewAdapter extends RecyclerView.Adapter<RecipeViewHolder> {
    private static final String TAG = "RecipeViewAdapter";

    private List<RecipeModel> recipeCollection;

    public RecipeViewAdapter(List<RecipeModel> collection) {
        recipeCollection = collection;
    }

    @NonNull
    @Override
    public RecipeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder");
        View inflatedView = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.recycler_list_recipe_item, parent, false);
        return new RecipeViewHolder(inflatedView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeViewHolder recipeViewHolder, int position) {
        Log.d(TAG, "onBindViewHolder");
        RecipeModel model = recipeCollection.get(position);
        recipeViewHolder.bindView(model);
    }

    @Override
    public int getItemCount() {
        return recipeCollection.size();
    }

}


