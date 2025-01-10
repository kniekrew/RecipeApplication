package com.example.recipes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AddActivity extends AppCompatActivity {

    private String type;
    private Button dessert;
    private Button meat;
    private Button pasta;
    private Button fruit;
    private Button soup;
    private Button bread;
    private TextView t;

    private Button next;
    private Button done;
    private EditText et;

    private String stage;

    private String title;
    private String ingredients;
    private String steps;

    private RecipesDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        dessert = findViewById(R.id.dessert);
        meat = findViewById(R.id.meat);
        pasta = findViewById(R.id.pasta);
        fruit = findViewById(R.id.fruit);
        soup = findViewById(R.id.soup);
        bread = findViewById(R.id.bread);
        t = findViewById(R.id.textView10);

        next = findViewById(R.id.next);
        done = findViewById(R.id.done);
        et = findViewById(R.id.textView11);

        title = "";
        ingredients = "";
        steps = "";
        stage = "first";

        db = Room.databaseBuilder(getApplicationContext(),
                RecipesDatabase.class, "recipes-database").allowMainThreadQueries().build();

    }
    public void isDessert(View view){
        type = "dessert";
        readInRecipe();
    }
    public void isMeat(View view){
        type = "meat";
        readInRecipe();
    }
    public void isPasta(View view){
        type = "pasta";
        readInRecipe();
    }
    public void isFruit(View view){
        type = "fruit";
        readInRecipe();
    }
    public void isSoup(View view){
        type = "soup";
        readInRecipe();
    }
    public void isBread(View view){
        type = "bread";
        readInRecipe();
    }
    public void readInRecipe(){
        t.setText("What is the title?");
        dessert.setVisibility(View.INVISIBLE);
        meat.setVisibility(View.INVISIBLE);
        pasta.setVisibility(View.INVISIBLE);
        fruit.setVisibility(View.INVISIBLE);
        soup.setVisibility(View.INVISIBLE);
        bread.setVisibility(View.INVISIBLE);

        et.setVisibility(View.VISIBLE);
        done.setVisibility(View.VISIBLE);

    }
    public void done(View view){
        switch (stage) {
            case "first":
                stage = "second";
                title = String.valueOf(et.getText());
                et.setText("");
                et.setHint("Ingredient");
                t.setText("List the ingredients\none by one");
                next.setVisibility(View.VISIBLE);
                break;
            case "second":
                stage = "third";
                ingredients += String.valueOf(et.getText());
                et.setText("");
                et.setHint("Step");
                t.setText("List all of the steps\none by one");

                break;
            case "third":
                steps += String.valueOf(et.getText());
                t.setText("Your recipe has been\nadded to the app!");
                next.setVisibility(View.INVISIBLE);
                done.setVisibility(View.INVISIBLE);
                et.setVisibility(View.INVISIBLE);
                switch (type) {
                    case "dessert":
                        Dessert d = new Dessert(title, ingredients, steps);
                        db.recipeDao().insertAllDesserts(d);

                        break;
                    case "meat":
                        Meat m = new Meat(title, ingredients, steps);
                        db.recipeDao().insertAllMeat(m);
                        break;
                    case "pasta":
                        Pie p = new Pie(title, ingredients, steps);
                        db.recipeDao().insertAllPie(p);
                        break;
                    case "fruit":
                        Fruit f = new Fruit(title, ingredients, steps);
                        db.recipeDao().insertAllFruit(f);
                        break;
                    case "soup":
                        Soup s = new Soup(title, ingredients, steps);
                        db.recipeDao().insertAllSoup(s);
                        break;
                    case "bread":
                        Bread b = new Bread(title, ingredients, steps);
                        db.recipeDao().insertAllBread(b);
                        break;
                }
                break;
        }
    }
    public void next(View view){
        if(stage.equals("second")){
            ingredients += String.valueOf(et.getText());
            ingredients += "//";
            et.setText("");
        }
        else if(stage.equals("third")){
            steps += String.valueOf(et.getText());
            steps += "//";
            et.setText("");
        }
    }
}