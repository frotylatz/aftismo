package unpad.aftismo.retrofit;

import java.util.Date;
import java.util.List;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import unpad.aftismo.model.Artikel;
import unpad.aftismo.model.BookResult;
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

    @FormUrlEncoded
    @POST("update_user.php")
    Observable<String> updateUser(@Field("id") String id,
                                  @Field("Phone") String phone,
                                  @Field("Name") String name,
                                  @Field("Address") String address);

    @FormUrlEncoded
    @POST("submitorder.php")
    Call<BookResult> submitOrder(@Field("book_price") float book_price,
                                 @Field("book_tutor") String book_tutor,
                                 @Field("book_address") String book_address,
                                 @Field("book_by") String book_by,
                                 @Field("user_phone") String user_phone,
                                 @Field("book_date") String book_date,
                                 @Field("book_time") String book_time);

    @GET("tutor/getbook.php")
    Observable<List<BookResult>> getAllBook();

    @FormUrlEncoded
    @POST("updatetoken.php")
    Call<String> updateToken(@Field("phone") String phone,
                             @Field("token") String token,
                             @Field("isServerToken") String isServerToken);
}
