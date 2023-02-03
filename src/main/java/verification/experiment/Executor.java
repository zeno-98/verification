package verification.experiment;

import verification.experiment.autosar4.Experiment4_4;

import java.io.IOException;

public class Executor {
    public static void main(String[] args) throws IOException {
        Experiment e = new Experiment4_4();
        e.execute(true, true, true, 1);
    }
}
