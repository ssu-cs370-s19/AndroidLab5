package ssu.softwarednd.spring19.androidlab5;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import ssu.softwarednd.spring19.androidlab5.models.RecipeModel;

public class RecipeViewHolder extends RecyclerView.ViewHolder {

    private TextView itemNameTextView;
    private TextView itemRatingTextView;

    public RecipeViewHolder(View itemView) {
        super(itemView);
        itemNameTextView = itemView.findViewById(R.id.recipe_name);
        itemRatingTextView = itemView.findViewById(R.id.recipe_rating);
    }

    public void bindView(RecipeModel model) {
        itemNameTextView.setText(model.getRecipeName());
        itemRatingTextView.setText(String.format("Rating: %d / 5", model.getRating()));



    }
}
