package traco.sampleappunittest.data;

import traco.sampleappunittest.data.api.LoginDetails;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class LocalDataSource implements DataSource {
    public static LocalDataSource localDataSource = null;

    private LocalDataSource() {

    }

    public static LocalDataSource getInstance() {

        if (localDataSource == null) localDataSource = new LocalDataSource();
        return localDataSource;
    }


    @Override
    public void getUserCredentials(String userName, String passWord, CallbackResult<LoginDetails> loginDetailsCallback) {
        LoginDetails loginDetails1 = null /*todo*/;
        loginDetailsCallback.onSuccess(loginDetails1);
    }
}
