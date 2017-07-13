package traco.sampleappunittest.login;

import traco.sampleappunittest.BasePresenter;
import traco.sampleappunittest.BaseView;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public interface LoginContractor {
    interface View extends BaseView<LoginContractor.Presenter> {
        void onLoginSuccess();

        void onLogiFailure();

        void onShowProgressBar(boolean show);

        void onForgotPassWordSuccess();

        void onForgotPasswordFailure();

        void onErrorUsername();

        void onErrorPassword();
    }

    interface Presenter extends BasePresenter {
        void onLogin(String username, String password);

        void onForgotPassword(String username);
    }
}
