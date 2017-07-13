package traco.sampleappunittest.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import traco.sampleappunittest.R;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class LoginActivity extends AppCompatActivity {
    private LoginFragment loginFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (loginFragment == null) {
            loginFragment = new LoginFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.cont_login, loginFragment, "fragment_login").commit();
    }
}
