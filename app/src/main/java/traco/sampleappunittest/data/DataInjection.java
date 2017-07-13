package traco.sampleappunittest.data;

/**
 * Created by tikson.tom on 7/10/2017.
 */

public class DataInjection {
    public static DataSource provideRepositiry() {
        return Repository.getInstance(RealDataSource.getInstance(), LocalDataSource.getInstance());
    }
}
