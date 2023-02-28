package com.example.getapimytech.api;

import com.example.getapimytech.model.Category;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CategoryService {
    @GET("api/admin/list")
    Call<List<Category>> getCategory();
}
