package verification.experiment.autosar3;

/**
 * case 1: buildTask1 + buildRunnable2 + buildSchedule
 * case 2:
 * case 3:
 */
public class Experiment3_2 extends Experiment3 {

    @Override
    public String getStatement() {
        return "A[] buffer1.count <= buffer1.len";
    }
}
