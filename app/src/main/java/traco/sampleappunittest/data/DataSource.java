package traco.sampleappunittest.data;

import traco.sampleappunittest.data.api.LoginDetails;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public interface DataSource {

    void getUserCredentials(String userName, String passWord, CallbackResult<LoginDetails> loginDetails);


    interface CallbackResult<T> {

        void onSuccess(T data);

        void onFailure(Throwable t);
    }
}
