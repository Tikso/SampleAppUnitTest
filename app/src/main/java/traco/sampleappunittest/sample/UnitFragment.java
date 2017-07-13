package traco.sampleappunittest.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import traco.sampleappunittest.R;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class UnitFragment extends Fragment implements UnitContractor.View {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View unitView = inflater.inflate(R.layout.fragment_unit, container, false);
        return unitView;
    }

    @Override
    public void makeToast(String message) {

    }

    @Override
    public void setPresenter(UnitContractor.Presenter presenter) {

    }

    @Override
    public void setVal() {

    }

    @Override
    public void setSelection() {

    }
}
