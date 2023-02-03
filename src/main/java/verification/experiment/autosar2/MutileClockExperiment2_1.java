package verification.experiment.autosar2;

import verification.plugins.SequenceChecker;
import verification.uppaal.model.Template;

import java.util.*;

public class MutileClockExperiment2_1 extends Experiment2 {
    @Override
    public String getStatement() {
//        return "A[] (buffer1.count <= buffer1.len)";
//        return "A[] (buffer2.count <= buffer2.len)";
        // A[] (buffer1.count <= buffer1.len)
        // A[] (buffer2.count <= buffer2.len)
//        return "A[] not (runnable3.s2 and runnable4.s2)";
        return "A[] not (runnable1.s2 and runnable2.s2)";
//        return "A[] not (runnable1.s2 and runnable2.s2)";
//        return "A[] (buffer1.count <= buffer1.len)";
//        return "A[] (buffer2.count >= 0)";
//        return "A[] (buffer1.count >= 0)";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("runnable1_start", true);
        syncSendMap.put("runnable2_start", true);
        syncSendMap.put("runnable3_start", true);
        syncSendMap.put("runnable4_start", true);
        return syncSendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("runnable1_start");
        set.add("runnable2_start");
        set.add("runnable3_start");
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
        return list;
    }

    @Override
    public List<Template> getM2() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx2Util.buildSchedule1());
        list.add(AutosarEx2Util.buildSchedule2());
        return list;
    }

    @Override
    public List<SequenceChecker> getSequenceChecker() {
        SequenceChecker plugin = new SequenceChecker(false);
        String s1 = "[startWith]:(runnable1_start)";
        String s2 = "[startWith]:(runnable1_start,runnable3_start)";
        plugin.add(s1);
        plugin.add(s2);
        return Collections.singletonList(plugin);
    }
}
