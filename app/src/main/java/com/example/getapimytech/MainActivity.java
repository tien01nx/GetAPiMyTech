package com.example.getapimytech;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.getapimytech.adapter.CategoryAdapter;
import com.example.getapimytech.api.CategoryService;
import com.example.getapimytech.model.Category;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Category> categoryList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        https://run.mocky.io/v3/81771c15-1dc6-4a9b-92fc-f991c48910dc
        recyclerView = findViewById(R.id.recyclerView);
        categoryList = new ArrayList<>();
        Retrofit retrofit = null;

        try {
            retrofit  = new Retrofit.Builder().baseUrl("http://192.168.0.101:8082/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        
        

        CategoryService categoryService = retrofit.create(CategoryService.class);

        Call<List<Category>> call = categoryService.getCategory();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                Log.d("hihi",response.body().toString());
                if (response.code()!=200){
                    return;
                }
                List<Category>movies=  response.body();
                for(Category movie: movies) categoryList.add(movie);

                PutDataIntoRecyclerView(categoryList);
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {

                Log.d("hihi",t.toString());

            }


        });

    }

    private void PutDataIntoRecyclerView(List<Category> movieList) {
        CategoryAdapter adapter = new CategoryAdapter(this,movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
}