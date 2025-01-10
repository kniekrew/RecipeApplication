package com.example.recipes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.InputDevice;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    public static RecipesDatabase db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = Room.databaseBuilder(getApplicationContext(),
                RecipesDatabase.class, "recipes-database").allowMainThreadQueries().build();

        //putting all the recipes into the database

        if(db.recipeDao().getAllDesserts().size() < 1) {
            InputStream peanut = getResources().openRawResource(R.raw.peanut);
            new readRecipesThread(peanut, "dessert", db).start();
            InputStream maple = getResources().openRawResource(R.raw.maple);
            new readRecipesThread(maple, "dessert", db).start();
            InputStream smores = getResources().openRawResource(R.raw.smores);
            new readRecipesThread(smores, "dessert", db).start();
            InputStream doodle = getResources().openRawResource(R.raw.doodle);
            new readRecipesThread(doodle, "dessert", db).start();
            InputStream bake = getResources().openRawResource(R.raw.nobake);
            new readRecipesThread(bake, "dessert", db).start();
            InputStream mint = getResources().openRawResource(R.raw.mints);
            new readRecipesThread(mint, "dessert", db).start();
            InputStream cream = getResources().openRawResource(R.raw.cream);
            new readRecipesThread(cream, "dessert", db).start();
        }
        if(db.recipeDao().getAllSoups().size() < 1){
            InputStream lentil = getResources().openRawResource(R.raw.lentil);
            new readRecipesThread(lentil, "soup", db).start();
            InputStream turkey = getResources().openRawResource(R.raw.turkey);
            new readRecipesThread(turkey, "soup", db).start();
            InputStream of = getResources().openRawResource(R.raw.of);
            new readRecipesThread(of, "soup", db).start();
            InputStream soup = getResources().openRawResource(R.raw.soup);
            new readRecipesThread(soup, "soup", db).start();
            InputStream dill = getResources().openRawResource(R.raw.dill);
            new readRecipesThread(dill, "soup", db).start();

        }
        if(db.recipeDao().getAllBreads().size() < 1){
            InputStream banana = getResources().openRawResource(R.raw.banana);
            new readRecipesThread(banana, "bread", db).start();
            InputStream biscuits = getResources().openRawResource(R.raw.biscutts);
            new readRecipesThread(biscuits, "bread", db).start();
            InputStream pumpkin = getResources().openRawResource(R.raw.pumpkin);
            new readRecipesThread(pumpkin, "bread", db).start();
            InputStream buns = getResources().openRawResource(R.raw.buns);
            new readRecipesThread(buns, "bread", db).start();
            InputStream pretzel = getResources().openRawResource(R.raw.pretzels);
            new readRecipesThread(pretzel, "bread", db).start();
            InputStream scones = getResources().openRawResource(R.raw.scones);
            new readRecipesThread(scones, "bread", db).start();
        }
        if(db.recipeDao().getAllFruits().size() < 1){
            InputStream pizza = getResources().openRawResource(R.raw.pizza);
            new readRecipesThread(pizza, "fruit", db).start();
            InputStream smoothie = getResources().openRawResource(R.raw.smoothie);
            new readRecipesThread(smoothie, "fruit", db).start();
            InputStream beans = getResources().openRawResource(R.raw.beans);
            new readRecipesThread(beans, "fruit", db).start();
            InputStream ban = getResources().openRawResource(R.raw.ban);
            new readRecipesThread(ban, "fruit", db).start();

            InputStream po = getResources().openRawResource(R.raw.potatos);
            new readRecipesThread(po, "fruit", db).start();
        }
        if(db.recipeDao().getAllMeats().size() < 1){
            InputStream bake = getResources().openRawResource(R.raw.bake);
            new readRecipesThread(bake, "meat", db).start();
            InputStream onion = getResources().openRawResource(R.raw.onion);
            new readRecipesThread(onion, "meat", db).start();
            InputStream parm = getResources().openRawResource(R.raw.parm);
            new readRecipesThread(parm, "meat", db).start();
            InputStream pork = getResources().openRawResource(R.raw.pork);
            new readRecipesThread(pork, "meat", db).start();
            InputStream hot = getResources().openRawResource(R.raw.hot);
            new readRecipesThread(hot, "meat", db).start();
            InputStream tenders = getResources().openRawResource(R.raw.tenders);
            new readRecipesThread(tenders, "meat", db).start();
        }
        if(db.recipeDao().getAllPies().size() < 1){
            InputStream ziti = getResources().openRawResource(R.raw.ziti);
            new readRecipesThread(ziti, "pie", db).start();
            InputStream mac = getResources().openRawResource(R.raw.mac);
            new readRecipesThread(mac, "pie", db).start();
            InputStream piz = getResources().openRawResource(R.raw.piz);
            new readRecipesThread(piz, "pie", db).start();
            InputStream garlic = getResources().openRawResource(R.raw.garlic);
            new readRecipesThread(garlic, "pie", db).start();
            InputStream butter = getResources().openRawResource(R.raw.buttered);
            new readRecipesThread(butter, "pie", db).start();
            InputStream quiche = getResources().openRawResource(R.raw.quiche);
            new readRecipesThread(quiche, "pie", db).start();
        }

        //done


        FirstFragment f = FirstFragment.newInstance();
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, f)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }

    public void meat(View v) {
        //makes InfoFragment
        SecondFragment f = SecondFragment.newInstance("Meat");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, f)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
    public void dessert(View v) {
        //makes InfoFragment
        SecondFragment f = SecondFragment.newInstance("Dessert");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, f)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
    public void bread(View v) {
        //makes InfoFragment
        SecondFragment f = SecondFragment.newInstance("Bread");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, f)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
    public void soup(View v) {
        //makes InfoFragment
        SecondFragment f = SecondFragment.newInstance("Soup");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, f)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
    public void fruit(View v) {
        //makes InfoFragment
        SecondFragment f = SecondFragment.newInstance("Fruit");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, f)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
    public void pasta(View v) {
        //makes InfoFragment
        SecondFragment f = SecondFragment.newInstance("Pasta");
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, f)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }
    public void makeThirdFragment(String name, String type){
        ThirdFragment f = ThirdFragment.newInstance(name, type);
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.main_fragment, f)
                .setReorderingAllowed(true)
                .addToBackStack(null)
                .commit();
    }


    //menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add:
                Intent jt = new Intent(this, AddActivity.class);
                startActivity(jt);
                break;
            case R.id.about:
                Intent jumpThere = new Intent(this, AboutActivity.class);
                startActivity(jumpThere);
                break;
            case R.id.delete:
                Intent jump = new Intent(this, DeleteActivity.class);
                startActivity(jump);
                break;
        }
        return super.onOptionsItemSelected(item);

    }
    public RecipesDatabase getDb(){
        return db;
    }
}