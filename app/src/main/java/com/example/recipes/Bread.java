package com.example.recipes;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Bread {
    @PrimaryKey(autoGenerate = true)
    public int uid;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "ingredients")
    public String ingredients;

    @ColumnInfo(name = "instructions")
    public String instructions;

    public Bread(String title, String ingredients, String instructions){
        this.title = title;
        this.ingredients = ingredients;
        this.instructions = instructions;
    }
}
