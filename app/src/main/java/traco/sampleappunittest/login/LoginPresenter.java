package traco.sampleappunittest.login;

import traco.sampleappunittest.data.DataSource;
import traco.sampleappunittest.data.api.LoginDetails;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class LoginPresenter implements LoginContractor.Presenter {
    private final LoginContractor.View view;
    private DataSource dataSource;
    private LoginContractor.View mLoginView;

    public LoginPresenter(LoginContractor.View view,DataSource dataSource) {

        this.view = view;
        this.dataSource = dataSource;
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }

    @Override
    public void onLogin(String username, String password) {
        if (username.equalsIgnoreCase(""))
            mLoginView.onErrorUsername();
        else if (password.equalsIgnoreCase(""))
            mLoginView.onErrorPassword();
        else {

                dataSource.getUserCredentials(username,password, new DataSource.CallbackResult<LoginDetails>() {
                    @Override
                    public void onSuccess(LoginDetails data) {

                    }

                    @Override
                    public void onFailure(Throwable t) {

                    }
                });
            }
    }

    @Override
    public void onForgotPassword(String username) {

    }
}
