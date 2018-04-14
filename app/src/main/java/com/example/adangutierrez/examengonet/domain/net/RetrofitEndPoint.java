package com.example.adangutierrez.examengonet.domain.net;


import com.example.adangutierrez.examengonet.data.request.login.RequestLogin;
import com.example.adangutierrez.examengonet.data.response.login.ResponseLogin;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.POST;

/**
 * Created by adan.gutierrez on 12/04/18.
 */

public interface RetrofitEndPoint {

    @POST("AgenteMovil.svc/agMov/login")
    Call<ResponseLogin> doLogin(@Header("SO") String so,
                                @Header("Version") String version,
                                @Body RequestLogin requestLogin);
}
