package unpad.aftismo.utils;

import unpad.aftismo.model.User;
import unpad.aftismo.retrofit.ApiClient;
import unpad.aftismo.retrofit.ApiInterface;

public class Common {
    private static final String BASE_URL = "http://coinbkt.com/aftismo/";

    public static User currentUser = null;

    public static ApiInterface getApi(){
        return ApiClient.getApiClient(BASE_URL).create(ApiInterface.class);
    }
}
