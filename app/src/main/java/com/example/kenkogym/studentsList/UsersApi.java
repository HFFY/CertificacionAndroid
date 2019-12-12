package com.example.kenkogym.studentsList;

import com.example.kenkogym.utils.models.objects.User;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface UsersApi {
    /**
     * @param alt
     * @return
     */
    @GET("Api%2Fusers.json")
    Call<HashMap<String,Object>> getUsers(@Query("alt") String alt);

    //E.g. Create a user
    @POST("user")
    Call<List<User>> createUser(@Query("alt") String alt,
                                 @Header("Accept") String accept,
                                 @Body Object body);

    //E.g. Get a user by uuid
    @GET("users/{userUuid}")
    Call<User> getUserByUuid(@Path("userUuid") String routedId,
                               @Query("alt") String alt,
                               @Header("Accept") String accept);
}
