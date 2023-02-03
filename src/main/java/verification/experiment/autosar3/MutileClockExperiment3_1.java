package verification.experiment.autosar3;

import verification.uppaal.model.Declaration;
import verification.uppaal.model.Template;

import java.util.*;

public class MutileClockExperiment3_1 extends Experiment3 {
    @Override
    public String getStatement() {
        return "A[] buffer2.count >= 0";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("runnable1_start", true);
        syncSendMap.put("runnable5_start", true);
        syncSendMap.put("runnable6_start", true);
        syncSendMap.put("runnable3_start", false);
        syncSendMap.put("read2", true);
        syncSendMap.put("runnable4_start", true);
        return syncSendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("runnable1_start");
        set.add("runnable5_start");
        set.add("runnable3_start");
        return set;
    }

    @Override
    public List<Template> getM1() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx3Util.buildRunnable1());
        list.add(AutosarEx3Util.buildRunnable2());
        list.add(AutosarEx3Util.buildRunnable4());
        list.add(AutosarEx3Util.buildRunnable5());
        list.add(AutosarEx3Util.buildRunnable6());
        list.add(AutosarEx3Util.buildBuffer1());
        list.add(AutosarEx3Util.buildBuffer2());
        list.add(AutosarEx3Util.buildBuffer3());
        list.add(AutosarEx3Util.buildBuffer4());
        list.add(AutosarEx3Util.buildBuffer5());
        list.add(AutosarEx3Util.buildRTE());
        return list;
    }

    @Override
    public List<Template> getM2() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx3Util.buildTask());
        list.add(AutosarEx3Util.buildSchedule());
        list.add(AutosarEx3Util.buildRunnable3());
        return list;
    }

    @Override
    public String getNtaPath() {
        return ".\\src\\main\\resources\\verification\\autosar_ex3-source.xml";
    }

    @Override
    public Declaration getGlobalDeclaration() {
        return AutosarEx3Util.getGlobalDeclaration();
    }
}
