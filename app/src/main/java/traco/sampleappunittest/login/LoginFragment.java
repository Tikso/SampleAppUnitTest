package traco.sampleappunittest.login;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import traco.sampleappunittest.R;
import traco.sampleappunittest.data.DataInjection;
import traco.sampleappunittest.data.api.Api;
import traco.sampleappunittest.data.api.ApiManager;
import traco.sampleappunittest.data.api.LoginDetails;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class LoginFragment extends Fragment implements View.OnClickListener, LoginContractor.View {
    private Button mBtLogin;
    private EditText mEdtUsername;
    private EditText mEdtPassword;
    private WebView mWebView;
    private LoginDetails mLoginDetails;
    private Api apiService;
    private String mUsername;
    private String mPassword;
    public static final String USER_PREFERENCE = "UserPrefs";
    public static final String FULL_NAME = "nameKey";
    public static final String USER_ID = "userKey";
    public static final String MOBILE_NO = "phoneKey";
    public static final String EMAIL_ID = "emailKey";
    public static final String USER = "user";
    private SharedPreferences sharedpreferences;
    private TextView mtxtLoginTxt;
    private Intent mintent;
    private String userId;
    private LoginContractor.Presenter presenter;
    private String username;
    private String password;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View loginFragment = inflater.inflate(R.layout.fragment_login, container, false);
        mEdtPassword = (EditText) loginFragment.findViewById(R.id.edtPassword);
        mEdtUsername = (EditText) loginFragment.findViewById(R.id.edtUsername);
        mBtLogin = (Button) loginFragment.findViewById(R.id.btNext);
        sharedpreferences = getActivity().getSharedPreferences(USER_PREFERENCE, MODE_PRIVATE);
        userId = sharedpreferences.getString(USER_ID, "0");
        mtxtLoginTxt = (TextView) loginFragment.findViewById(R.id.txtLogin);
        Typeface face;
        face = Typeface.createFromAsset(getActivity().getAssets(), "sofia.otf");
        mtxtLoginTxt.setTypeface(face);
        mBtLogin.setOnClickListener(this);
        return loginFragment;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (presenter == null)
            presenter = new LoginPresenter(this, DataInjection.provideRepositiry());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btNext:
                password = mEdtPassword.getText().toString().trim();
                username = mEdtUsername.getText().toString().trim();
                presenter.onLogin(username, password);
                break;
        }
    }

    @Override
    public void setPresenter(LoginContractor.Presenter presenter) {
        this.presenter = presenter;

    }

    @Override
    public void makeToast(String message) {

    }

    @Override
    public void onLoginSuccess() {

    }

    @Override
    public void onLogiFailure() {

    }

    @Override
    public void onShowProgressBar(boolean show) {

    }

    @Override
    public void onForgotPassWordSuccess() {

    }

    @Override
    public void onForgotPasswordFailure() {

    }

    @Override
    public void onErrorUsername() {

    }

    @Override
    public void onErrorPassword() {

    }

//    private void loginApi() {
//        customProgressDialog = new CustomProgressDialog();
//        customProgressDialog.show(getFragmentManager(), "Progress");
//        apiService = ApiManager.getClient().create(Api.class);
//        Call<LoginDetails> call = apiService.loginApi(mUsername, mPassword);
//        call.enqueue(new Callback<LoginDetails>() {
//            @Override
//            public void onResponse(Call<LoginDetails> call, Response<LoginDetails> response) {
//                customProgressDialog.dismiss();
//                mLoginDetails = response.body();
//                Log.d("SG_LOGIN>>>", response.raw() + " " + response.message() + " " + response.isSuccessful() + "  " + mLoginDetails);
//                if (response.isSuccessful()) {
//                    if (mLoginDetails.getiStatusCode() == 1) {
//                        LoginDetails.LoginResult mResult = mLoginDetails.sResult;
//                        SharedPreferences.Editor editor = sharedpreferences.edit();
//                        editor.putString(FULL_NAME, mResult.getFullname());
//                        editor.putString(USER_ID, String.valueOf(mResult.getUserID()));
//                        editor.putString(EMAIL_ID, mResult.getEmailid());
//                        editor.putString(MOBILE_NO, mResult.getMobilenumber());
//                        editor.putBoolean(USER, mResult.getUserFlag());
//                        editor.commit();
//                        if (mResult.getUserFlag() == true)
//                            mintent = new Intent(getActivity(), DashBoardActivity.class);
//                        else
//                            mintent = new Intent(getActivity(), MainActivity.class);
//                        startActivity(mintent);
//                        getActivity().finish();
//                    } else if (mLoginDetails.getiStatusCode() == 0) {
//                        Toast.makeText(getActivity(), "Invalid username or password", Toast.LENGTH_SHORT).show();
//                    } else {
//                        Toast.makeText(getActivity(), "Error in connection", Toast.LENGTH_SHORT).show();
//                    }
//                } else {
//                    Toast.makeText(getActivity(), "Error in connection", Toast.LENGTH_SHORT).show();
//                }
//            }
//
//            @Override
//            public void onFailure(Call<LoginDetails> call, Throwable t) {
//                customProgressDialog.dismiss();
//                Toast.makeText(getActivity(), getResources().getString(R.string.failed_connect), Toast.LENGTH_SHORT).show();
//            }
//        });
//
    //   }
}
