package multithreading;

import java.util.concurrent.Callable;

public class TestCallable implements Callable<Boolean> {
    @Override
    public Boolean call() {

        return true;
    }
}
