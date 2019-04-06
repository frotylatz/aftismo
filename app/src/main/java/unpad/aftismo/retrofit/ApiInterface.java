package unpad.aftismo.retrofit;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import unpad.aftismo.model.Artikel;
import unpad.aftismo.model.CheckUserResponse;
import unpad.aftismo.model.Tutor;
import unpad.aftismo.model.User;

public interface ApiInterface {
    @FormUrlEncoded
    @POST("checkuser.php")
    Call<CheckUserResponse> checkUserExists(@Field("phone") String phone);

    @FormUrlEncoded
    @POST("register.php")
    Call<User> registerNewUser(@Field("phone") String phone,
                               @Field("name") String name);

    @FormUrlEncoded
    @POST("getuser.php")
    Call<User> getUserInformation(@Field("phone") String phone);

    @GET("getalltutor.php")
    Observable<List<Tutor>> getAllTutor();

    @GET("getartikel.php")
    Observable<List<Artikel>> getArtikel();
}
