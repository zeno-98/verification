package verification.experiment.autosar2;

public class Experiment2_5 extends Experiment2 {

    @Override
    public String getStatement() {
        return "A[] not (runnable1.s2 and runnable2.s2)";
    }
}
