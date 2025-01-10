package com.example.recipes;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface RecipeDao {
    @Insert
    void insertAllDesserts(Dessert...dessert);
    @Insert
    void insertAllBread(Bread...bread);
    @Insert
    void insertAllSoup(Soup...soup);
    @Insert
    void insertAllFruit(Fruit...fruit);
    @Insert
    void insertAllMeat(Meat...meat);
    @Insert
    void insertAllPie(Pie...pie);

    @Query("SELECT * FROM dessert")
    public List<Dessert> getAllDesserts();

    @Query("SELECT * FROM fruit")
    public List<Fruit> getAllFruits();

    @Query("SELECT * FROM bread")
    public List<Bread> getAllBreads();

    @Query("SELECT * FROM meat")
    public List<Meat> getAllMeats();

    @Query("SELECT * FROM pie")
    public List<Pie> getAllPies();

    @Query("SELECT * FROM soup")
    public List<Soup> getAllSoups();

    @Query("SELECT * FROM dessert WHERE title LIKE :name")
    public List<Dessert> findDessertWithName(String name);

    @Query("SELECT * FROM meat WHERE title LIKE :name")
    public List<Meat> findMeatWithName(String name);

    @Query("SELECT * FROM pie WHERE title LIKE :name")
    public List<Pie> findPieWithName(String name);

    @Query("SELECT * FROM bread WHERE title LIKE :name")
    public List<Bread> findBreadWithName(String name);

    @Query("SELECT * FROM soup WHERE title LIKE :name")
    public List<Soup> findSoupWithName(String name);

    @Query("SELECT * FROM fruit WHERE title LIKE :name")
    public List<Fruit> findFruitWithName(String name);

    @Query("DELETE FROM dessert WHERE title LIKE :name")
    void deleteDessertByName(String name);

    @Query("DELETE FROM pie WHERE title LIKE :name")
    void deletePieByName(String name);

    @Query("DELETE FROM meat WHERE title LIKE :name")
    void deleteMeatByName(String name);

    @Query("DELETE FROM soup WHERE title LIKE :name")
    void deleteSoupByName(String name);

    @Query("DELETE FROM fruit WHERE title LIKE :name")
    void deleteFruitByName(String name);

    @Query("DELETE FROM bread WHERE title LIKE :name")
    void deleteBreadByName(String name);
}
