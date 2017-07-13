package traco.sampleappunittest.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import traco.sampleappunittest.R;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class UnitTestActivity extends AppCompatActivity {
    private UnitFragment unitFragment;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        if (unitFragment == null) {
            unitFragment = new UnitFragment();
        }
        getSupportFragmentManager().beginTransaction().replace(R.id.cont_unit, unitFragment,
                "fragment_unit").commit();
    }
}
