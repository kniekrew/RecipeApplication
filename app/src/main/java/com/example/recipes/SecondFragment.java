package com.example.recipes;

import android.os.Bundle;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class SecondFragment extends Fragment {

    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";

    private String type;

    public SecondFragment() {
        // Required empty public constructor
    }

    /**
     * factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param typeOf the type of recipe
     * @return A new instance of fragment SecondFragment.
     */
    public static SecondFragment newInstance(String typeOf) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, typeOf);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            type = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        ConstraintLayout layout = view.findViewById(R.id.layout);
        MainActivity ma = (MainActivity) this.getActivity();



        List<String > titleList = new ArrayList<>();

        if(type.equals("Dessert")){
            List<Dessert> dessertList = ma.db.recipeDao().getAllDesserts();
            for(Dessert list : dessertList) {
                titleList.add(list.title);
            }

        }
        else if(type.equals("Pasta")){
            List<Pie> pieList = ma.db.recipeDao().getAllPies();
            for(Pie list : pieList){
                titleList.add(list.title);
            }
        }
        else if(type.equals("Bread")){
            List<Bread> breadList = ma.db.recipeDao().getAllBreads();
            for(Bread list : breadList){
                titleList.add(list.title);
            }
        }
        else if(type.equals("Meat")){
            List<Meat> meatList = ma.db.recipeDao().getAllMeats();
            for(Meat list : meatList){
                titleList.add(list.title);
            }
        }
        else if(type.equals("Fruit")){
            List<Fruit> fruitList = ma.db.recipeDao().getAllFruits();
            for(Fruit list : fruitList){
                titleList.add(list.title);
            }
        }
        else if(type.equals("Soup")){
            List<Soup> soupList = ma.db.recipeDao().getAllSoups();
            for(Soup list : soupList){
                titleList.add(list.title);
            }
        }
        ArrayAdapter adapter = new ArrayAdapter(ma.getApplicationContext(), R.layout.activity_listview, titleList);
        ListView listView = (ListView) view.findViewById(R.id.list);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView t = (TextView) view;
                String title = t.getText().toString();
                ma.makeThirdFragment(title, type);

            }
        });

        return view;

    }
}