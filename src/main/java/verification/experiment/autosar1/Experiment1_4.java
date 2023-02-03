package verification.experiment.autosar1;

public class Experiment1_4 extends Experiment1 {

    @Override
    public String getStatement() {
        return "A[] not (runnable1.active and runnable2.active)";
    }
}
