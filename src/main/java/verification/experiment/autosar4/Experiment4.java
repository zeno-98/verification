package verification.experiment.autosar4;

import verification.experiment.Experiment;
import verification.plugins.SequenceChecker;
import verification.uppaal.model.Declaration;

import java.util.List;

public abstract class Experiment4 extends Experiment {
    public String getNtaPath() {
        return ".\\src\\main\\resources\\verification\\autosar_ex4-source.xml";
    }

    @Override
    public Declaration getGlobalDeclaration() {
        return AutosarEx4Util.buildGlobalDeclaration();
    }

    @Override
    public List<SequenceChecker> getSequenceChecker() {
        return null;
    }
}
