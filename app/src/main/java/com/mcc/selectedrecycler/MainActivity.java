package com.mcc.selectedrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener, OnItemClickListener{


    ArrayList<ItemModel> dataList;
    SelectedAdapter selectedAdapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.rv_listings);
        dataList = new ArrayList<>();
        populateList();

        selectedAdapter = new SelectedAdapter(dataList, getApplicationContext());
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(selectedAdapter);
        selectedAdapter.setItemClickListener(this);
    }


    private void populateList() {
        dataList.add(new ItemModel(R.drawable.big_brands, R.drawable.big_brands_bw, "Big Brands", true));
        dataList.add(new ItemModel(R.drawable.education, R.drawable.education_bw, "Education", false));
        dataList.add(new ItemModel(R.drawable.entertainment, R.drawable.entertainment_bw, "Entertainment", false));
        dataList.add(new ItemModel(R.drawable.food, R.drawable.food_bw, "Big Brands", false));
        dataList.add(new ItemModel(R.drawable.grooming, R.drawable.grooming_bw, "Grooming", false));
        dataList.add(new ItemModel(R.drawable.hardware, R.drawable.hardware_bw, "Hardware", false));
        dataList.add(new ItemModel(R.drawable.money, R.drawable.money_bw, "Finance", false));
        dataList.add(new ItemModel(R.drawable.rent, R.drawable.rent_bw, "Rent", false));
        dataList.add(new ItemModel(R.drawable.shopping, R.drawable.shopping_bw, "Shopping", false));
        dataList.add(new ItemModel(R.drawable.sports, R.drawable.sports_bw, "Sports", false));
    }


    private int selectedCategory() {
        int position = -1;
        for (int i = 0; i < dataList.size(); i++) {
            if (dataList.get(i).isCategorySelected()) {
                position = i;
            }
        }
        return position;
    }

    @Override
    public void onItemClick(View view, int position) {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onItemSelect(int position) {
        int currentSelected = selectedCategory();
        ItemModel unselectCategory = dataList.get(currentSelected);
        unselectCategory.setCategorySelected(false);
        selectedAdapter.notifyItemChanged(currentSelected);

        ItemModel selectCategory = dataList.get(position);
        selectCategory.setCategorySelected(true);
        selectedAdapter.notifyItemChanged(position);
    }
}
