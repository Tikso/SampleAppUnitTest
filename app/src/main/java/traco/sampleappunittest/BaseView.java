package traco.sampleappunittest;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public interface BaseView<T> {
    void setPresenter(T presenter);

    void makeToast(String message);
}
