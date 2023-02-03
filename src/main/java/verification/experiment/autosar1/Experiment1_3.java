package verification.experiment.autosar1;

public class Experiment1_3 extends Experiment1 {

    @Override
    public String getStatement() {
        return "A[] not (runnable1.active1 and runnable2.implic_R)";
    }
}
