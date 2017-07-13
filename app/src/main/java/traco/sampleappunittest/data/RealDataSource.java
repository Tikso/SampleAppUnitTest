package traco.sampleappunittest.data;

import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import traco.sampleappunittest.R;
import traco.sampleappunittest.data.api.Api;
import traco.sampleappunittest.data.api.ApiManager;
import traco.sampleappunittest.data.api.LoginDetails;

import static traco.sampleappunittest.login.LoginFragment.EMAIL_ID;
import static traco.sampleappunittest.login.LoginFragment.FULL_NAME;
import static traco.sampleappunittest.login.LoginFragment.USER_ID;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class RealDataSource implements DataSource {
    private static RealDataSource realDataSource;
    private LoginDetails mLoginDetails;
    private Api apiService;

    private RealDataSource() {

    }

    @Override
    public void getUserCredentials(String userName, String passWord, final CallbackResult<LoginDetails> loginDetails) {
        apiService = ApiManager.getClient().create(Api.class);
        Call<LoginDetails> call = apiService.loginApi(userName, passWord);
        call.enqueue(new Callback<LoginDetails>() {
            @Override
            public void onResponse(Call<LoginDetails> call, Response<LoginDetails> response) {
                mLoginDetails = response.body();
                loginDetails.onSuccess(mLoginDetails);
            }

            @Override
            public void onFailure(Call<LoginDetails> call, Throwable t) {
                loginDetails.onFailure(t);
            }
        });

    }



    public static RealDataSource getInstance() {
        if (realDataSource == null)
            realDataSource = new RealDataSource();
        return realDataSource;
    }

}
