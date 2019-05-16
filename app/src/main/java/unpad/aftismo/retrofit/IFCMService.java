package unpad.aftismo.retrofit;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import unpad.aftismo.model.DataMessage;
import unpad.aftismo.model.MyResponse;

public interface IFCMService {
    @Headers(
            {
      "Content-Type:application/json",
      "Authorization:key=AAAAAPr0uzs:APA91bG9jw8SVn385AZXs3B5NGN1C1DdX1C-aCd0m419Dr20znRUuWpmgEe2XSoAivjAorESexj569_EI1yteNPrF7xnpA6YXiugEX7K88sWzvbDt_mLG1Ff5UR8_BEawJmwiRiDhNhB"
    }
    )
    @POST("fcm/send")
    Call<MyResponse> sendNotification(@Body DataMessage body);
}
