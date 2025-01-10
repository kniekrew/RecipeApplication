package com.example.recipes;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class ThirdFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String name;
    private String type;
    public ThirdFragment() {
        // Required empty public constructor
    }

    /**
     * factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param nameOf name of recipe
     * @param typeOf type of recipe
     * @return A new instance of fragment BlankFragment.
     */
    public static ThirdFragment newInstance(String nameOf, String typeOf) {
        ThirdFragment fragment = new ThirdFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, nameOf);
        args.putString(ARG_PARAM2, typeOf);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name = getArguments().getString(ARG_PARAM1);
            type = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third, container, false);

        TextView t = view.findViewById(R.id.title);
        TextView i = view.findViewById(R.id.ingredients);
        TextView d = view.findViewById(R.id.directions);
        switch (type) {
            case "Dessert": {
                List<Dessert> dessert = MainActivity.db.recipeDao().findDessertWithName(name);
                t.setText(name);
                String[] parts = dessert.get(0).ingredients.split("//");
                for (String part : parts) {
                    i.append(part + "\n\n");
                }
                String[] partsTwo = dessert.get(0).instructions.split("//");
                for (String s : partsTwo) {
                    d.append(s + "\n\n");
                }
                break;
            }
            case "Meat": {
                List<Meat> meat = MainActivity.db.recipeDao().findMeatWithName(name);
                t.setText(name);
                String[] parts = meat.get(0).ingredients.split("//");
                for (String part : parts) {
                    i.append(part + "\n\n");
                }
                String[] partsTwo = meat.get(0).instructions.split("//");
                for (String s : partsTwo) {
                    d.append(s + "\n\n");
                }
                break;
            }
            case "Pasta": {
                List<Pie> pie = MainActivity.db.recipeDao().findPieWithName(name);
                t.setText(name);
                String[] parts = pie.get(0).ingredients.split("//");
                for (String part : parts) {
                    i.append(part + "\n\n");
                }
                String[] partsTwo = pie.get(0).instructions.split("//");
                for (String s : partsTwo) {
                    d.append(s + "\n\n");
                }
                break;
            }
            case "Soup": {
                List<Soup> soup = MainActivity.db.recipeDao().findSoupWithName(name);
                t.setText(name);
                String[] parts = soup.get(0).ingredients.split("//");
                for (String part : parts) {
                    i.append(part + "\n\n");
                }
                String[] partsTwo = soup.get(0).instructions.split("//");
                for (String s : partsTwo) {
                    d.append(s + "\n\n");
                }
                break;
            }
            case "Bread": {
                List<Bread> bread = MainActivity.db.recipeDao().findBreadWithName(name);
                t.setText(name);
                String[] parts = bread.get(0).ingredients.split("//");
                for (String part : parts) {
                    i.append(part + "\n\n");
                }
                String[] partsTwo = bread.get(0).instructions.split("//");
                for (String s : partsTwo) {
                    d.append(s + "\n\n");
                }
                break;
            }
            case "Fruit": {
                List<Fruit> fruit = MainActivity.db.recipeDao().findFruitWithName(name);
                t.setText(name);
                String[] parts = fruit.get(0).ingredients.split("//");
                for (String part : parts) {
                    i.append(part + "\n\n");
                }
                String[] partsTwo = fruit.get(0).instructions.split("//");
                for (String s : partsTwo) {
                    d.append(s + "\n\n");
                }
                break;
            }
        }

        return view;
    }
}