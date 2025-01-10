package com.example.recipes;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Dessert.class, Fruit.class, Pie.class, Soup.class, Meat.class, Bread.class}, version = 3)
public abstract class RecipesDatabase extends RoomDatabase {
    public abstract RecipeDao recipeDao();
}
