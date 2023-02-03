package verification.experiment.autosar3.mutileM1;

import verification.experiment.Experiment;
import verification.experiment.autosar3.AutosarEx3Util;
import verification.plugins.SequenceChecker;
import verification.uppaal.model.Declaration;
import verification.uppaal.model.Template;

import java.util.*;

public class MutileExperiment_3_1_and_2 extends Experiment {
    @Override
    public String getStatement() {
        return "A[] (buffer1.count >= 0)";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("read1", true);
        syncSendMap.put("write1", true);
        syncSendMap.put("runnable1_start", false);
        syncSendMap.put("task_start", false);
        return syncSendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("read1");
        set.add("write1");
        set.add("runnable1_start");
        set.add("task_start");
        return set;
    }

    @Override
    public List<Template> getM1() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx3Util.buildSchedule());
        list.add(AutosarEx3Util.buildBuffer1());
        return list;
    }

    @Override
    public List<Template> getM2() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx3Util.buildRunnable1());
        list.add(AutosarEx3Util.buildRunnable2());
        list.add(AutosarEx3Util.buildRunnable3());
        list.add(AutosarEx3Util.buildRunnable4());
        list.add(AutosarEx3Util.buildRunnable5());
        list.add(AutosarEx3Util.buildRunnable6());
//        list.add(AutosarEx3Util.buildBuffer1());
        list.add(AutosarEx3Util.buildBuffer2());
        list.add(AutosarEx3Util.buildBuffer3());
        list.add(AutosarEx3Util.buildBuffer4());
        list.add(AutosarEx3Util.buildBuffer5());
        list.add(AutosarEx3Util.buildRTE());
        list.add(AutosarEx3Util.buildTask());
//        list.add(AutosarEx3Util.buildSchedule());
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

    @Override
    public List<SequenceChecker> getSequenceChecker() {
        SequenceChecker plugin = new SequenceChecker(false);
        String s0 = "[startWith]:(runnable1_start,task_start)";
        String s1 = "[startWith]:(runnable1_start,runnable1_start)";
        String s2 = "[startWith]:(runnable1_start,runnable1_start,task_start)";
        String s3 = "[startWith]:(runnable1_start,runnable1_start,runnable1_start,task_start)";
        plugin.add(s0);
        plugin.add(s1);
        plugin.add(s2);
        plugin.add(s3);
        return Collections.singletonList(plugin);
    }
}
