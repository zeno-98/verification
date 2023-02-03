package verification.experiment.autosar2;

import verification.experiment.Experiment;
import verification.plugins.SequenceChecker;
import verification.uppaal.model.Declaration;
import verification.uppaal.model.Template;

import java.util.*;

public abstract class Experiment2 extends Experiment {

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("runnable1_start", true);
        syncSendMap.put("runnable2_start", true);
        return syncSendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("runnable1_start");
        set.add("runnable2_start");
        return set;
    }

    @Override
    public List<Template> getM1() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx2Util.buildRunnable1());
        list.add(AutosarEx2Util.buildRunnable2());
        list.add(AutosarEx2Util.buildRunnable3());
        list.add(AutosarEx2Util.buildRunnable4());
        list.add(AutosarEx2Util.buildBuffer1());
        list.add(AutosarEx2Util.buildBuffer2());
        list.add(AutosarEx2Util.buildSchedule2());
        return list;
    }

    @Override
    public List<Template> getM2() {
        return Collections.singletonList(AutosarEx2Util.buildSchedule1());
    }

    @Override
    public String getNtaPath() {
        return ".\\src\\main\\resources\\verification\\autosar_ex2-source.xml";
    }

    @Override
    public Declaration getGlobalDeclaration() {
        return AutosarEx2Util.getGlobalDeclaration();
    }

    @Override
    public List<SequenceChecker> getSequenceChecker() {
        SequenceChecker plugin = new SequenceChecker(false);
        String s1 = "[startWith]:(runnable1_start,runnable1_start)";
        String s2 = "[startWith]:(runnable1_start,runnable1_start,runnable2_start)";
        String s3 = "[startWith]:(runnable1_start,runnable1_start,runnable1_start,runnable2_start)";
        String s4 = "[startWith]:(runnable1_start,runnable2_start)";
        plugin.add(s1);
        plugin.add(s2);
        plugin.add(s3);
        plugin.add(s4);
        return Collections.singletonList(plugin);
    }
}
