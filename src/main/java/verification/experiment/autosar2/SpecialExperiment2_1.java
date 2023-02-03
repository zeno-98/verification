package verification.experiment.autosar2;

import verification.uppaal.model.Template;

import java.util.*;

public class SpecialExperiment2_1 extends Experiment2 {
    @Override
    public String getStatement() {
        // A[] (buffer1.count <= buffer1.len)
        // A[] (buffer2.count <= buffer2.len)
        return "A[] (buffer2.count >= 0)";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("read2", true);
        syncSendMap.put("runnable4_start", false);
        return syncSendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("runnable4_start");
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
        list.add(AutosarEx2Util.buildSchedule1());
        list.add(AutosarEx2Util.buildSchedule2());
        return list;
    }

    @Override
    public List<Template> getM2() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx2Util.buildRunnable4());
        return list;
    }
}
