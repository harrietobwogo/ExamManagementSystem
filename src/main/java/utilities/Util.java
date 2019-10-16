package utilities;

import com.google.gson.Gson;
import okhttp3.*;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Harriet on 10/8/2019.
 */
public class Util {

    private static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");

    /**
     * Acccess student resource to get student id to be used for assigning student exam results from a different module
     * @param registrationNumber
     * @param resourceurl
     * @return
     */
    public String getStudentByRegistrationNumber(String registrationNumber,String resourceurl){
        OkHttpClient client=new OkHttpClient();
        Map<String,String> map=new HashMap<>();
        map.put("registrationNumber", registrationNumber);
        RequestBody requestBody=RequestBody.create(JSON,new Gson().toJson(map));
        Request request=new Request.Builder()
                .url("http://192.168.10.60:8080/SchoolSystemApplication/" +resourceurl)
                .post(requestBody)
                .build();
        try {
            Response response=client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * access Unit resource to extract unit id to be used when assigning exam results from an external module
     * @param unitCode
     * @param resourceurl
     * @return
     */
    public String getUnitByUnitCode(String unitCode,String resourceurl){
        OkHttpClient client=new OkHttpClient();
        Map<String,String> map=new HashMap<>();
        map.put("unitCode", unitCode);
        RequestBody requestBody=RequestBody.create(JSON,new Gson().toJson(map));
        Request request=new Request.Builder()
                .url("http://192.168.10.60:8080/SchoolSystemApplication/" +resourceurl)
                .post(requestBody)
                .build();
        try {
            Response response=client.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            return null;
        }
    }
}
