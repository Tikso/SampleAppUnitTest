package traco.sampleappunittest.data.api;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by tikson.tom on 5/31/2017.
 */

public interface Api {
    @FormUrlEncoded
    @POST("Authentication")
    Call<Object> login(@Field("uname") String Username, @Field("pass") String password, @Field("key") String token);

    @POST("iLORRYLOGIn/checkusername")
    Call<LoginDetails> loginApi(@Query("sUserName") String Username, @Query("sPassword") String password);

}
