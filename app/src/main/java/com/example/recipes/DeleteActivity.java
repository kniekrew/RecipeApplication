package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

public class DeleteActivity extends AppCompatActivity {
    private TextView tv;
    private EditText et;
    private RecipesDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);
        et = findViewById(R.id.textView12);
        tv = findViewById(R.id.textView13);
        db = Room.databaseBuilder(getApplicationContext(),
                RecipesDatabase.class, "recipes-database").allowMainThreadQueries().build();

    }
    public void onDelete(View view){
        String name = String.valueOf(et.getText()).trim();
        List<Meat> meat = MainActivity.db.recipeDao().findMeatWithName(name);
        List<Bread> bread = MainActivity.db.recipeDao().findBreadWithName(name);
        List<Pie> pie = MainActivity.db.recipeDao().findPieWithName(name);
        List<Soup> soup = MainActivity.db.recipeDao().findSoupWithName(name);
        List<Dessert> dessert = MainActivity.db.recipeDao().findDessertWithName(name);
        List<Fruit> fruit = MainActivity.db.recipeDao().findFruitWithName(name);
        if(meat.size() > 0){
            db.recipeDao().deleteMeatByName(name);
        }
        else if(bread.size() > 0) {
            db.recipeDao().deleteBreadByName(name);
        }
        else if(pie.size() > 0){
            db.recipeDao().deletePieByName(name);
        }
        else if(soup.size() > 0){
            db.recipeDao().deleteSoupByName(name);

        }
        else if(dessert.size() > 0){
            db.recipeDao().deleteDessertByName(name);

        }
        else if(fruit.size() > 0){
            db.recipeDao().deleteFruitByName(name);

        }
        else{
            tv.setText("\""+name+"\"\nwas not found on the app.\nMake sure the words are spelled right and capitalized correctly");
            return;
        }
        et.setText("");
        tv.setText("\""+name+"\"\nwas deleted from the app!\nWould you like to delete another?");
    }
}