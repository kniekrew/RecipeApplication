package com.example.recipes;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class readRecipesThread extends Thread{
    private final InputStream stream;
    private final BufferedReader reader;
    private final RecipesDatabase db;
    private final String type;
    readRecipesThread(InputStream i, String type, RecipesDatabase db){
        stream = i;
        reader = new BufferedReader(new InputStreamReader(i));
        this.db = db;
        this.type = type;
    }
    public void run(){

        String line = "";
        String title = "";
        String ingredients = "";
        String instructions = "";
        boolean ing = false;
        boolean inst = false;
        while(true){
            try{
                if((line = reader.readLine()) == null){
                    break;
                }
            }catch (IOException e){
                e.printStackTrace();
            }
            //do stuff with each line
            if(line.contains("title")){
                ing = false;
                inst = false;
                String[] parts = line.split(":");
                title += parts[1];
            }
            else if(line.contains("ingredients")){
                ing = true;
                inst = false;
                String[] parts = line.split(":");
                ingredients+= parts[1];
            }
            else if(line.contains("instructions")){
                ing = false;
                inst = true;
                String[] parts = line.split(":");
                instructions+=parts[1];
            }
            else if(ing){
                ingredients += line;
            }
            else if(inst){
                instructions += line;
            }

        }
        try{
            stream.close();

        }catch (IOException e) {
            e.printStackTrace();
        }
        switch (type) {
            case "dessert":
                Dessert d = new Dessert(title, ingredients, instructions);
                db.recipeDao().insertAllDesserts(d);
                break;
            case "bread":
                Bread b = new Bread(title, ingredients, instructions);
                db.recipeDao().insertAllBread(b);
                break;
            case "pie":
                Pie p = new Pie(title, ingredients, instructions);
                db.recipeDao().insertAllPie(p);
                break;
            case "meat":
                Meat m = new Meat(title, ingredients, instructions);
                db.recipeDao().insertAllMeat(m);
                break;
            case "fruit":
                Fruit f = new Fruit(title, ingredients, instructions);
                db.recipeDao().insertAllFruit(f);
                break;
            case "soup":
                Soup s = new Soup(title, ingredients, instructions);
                db.recipeDao().insertAllSoup(s);
                break;
        }
    }
}
