package traco.sampleappunittest.data;

import android.provider.ContactsContract;

import traco.sampleappunittest.data.api.LoginDetails;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class Repository implements DataSource {
    private final DataSource mRemoteDataSource;
    private final DataSource mLocalDataSource;
    private static Repository INSTANCE;

    private Repository(DataSource mRemoteDataSource, DataSource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
        this.mRemoteDataSource = mRemoteDataSource;
    }

    public static Repository getInstance(DataSource remoteDataSource, DataSource locaDataSource) {

        if (INSTANCE == null) INSTANCE = new Repository(remoteDataSource, locaDataSource);
        return INSTANCE;
    }


    @Override
    public void getUserCredentials(final String userName, final String passWord, final CallbackResult<LoginDetails> loginDetails) {
        mLocalDataSource.getUserCredentials(userName, passWord, new CallbackResult<LoginDetails>() {
            @Override
            public void onSuccess(LoginDetails data) {
                if(loginDetails != null) {
                    loginDetails.onSuccess(data);
                } else {
                    mRemoteDataSource.getUserCredentials(userName, passWord, new CallbackResult<LoginDetails>() {
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
            public void onFailure(Throwable t) {

            }
        });
    }
}
