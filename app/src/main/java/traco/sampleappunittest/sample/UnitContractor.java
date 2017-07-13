package traco.sampleappunittest.sample;

import traco.sampleappunittest.BaseView;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public interface UnitContractor {
    interface View extends BaseView<UnitContractor.Presenter> {
        void setPresenter(UnitContractor.Presenter presenter);

        void setVal();

        void setSelection();

    }

    interface Presenter {
        void setBetAmount();
    }
}
