package verification.experiment.autosar5;

import verification.experiment.Experiment;
import verification.experiment.autosar3.AutosarEx3Util;
import verification.plugins.SequenceChecker;
import verification.uppaal.model.Declaration;
import verification.uppaal.model.Template;

import java.util.*;

/**
 * generate from autosar3
 */
public abstract class Experiment5 extends Experiment {

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("runnable1_start", true);
        syncSendMap.put("runnable5_start", true);
        syncSendMap.put("runnable6_start", true);
        syncSendMap.put("runnable3_start", false);
        syncSendMap.put("read2", true);
        syncSendMap.put("read4", true);
        syncSendMap.put("write3", true);
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
        list.add(AutosarEx3Util.buildRunnable4());
        return list;
    }

    @Override
    public String getNtaPath() {
        return ".\\src\\main\\resources\\verification\\autosar_ex3-source.xml";
    }

    @Override
    public Declaration getGlobalDeclaration() {
        Declaration globalDeclaration = new Declaration();
        globalDeclaration.put("read1,write1", "chan");
        globalDeclaration.put("read2,write2", "chan");
        globalDeclaration.put("read3,write3", "chan");
        globalDeclaration.put("read4,write4", "chan");
        globalDeclaration.put("read5,write5", "chan");
        globalDeclaration.put("runnable1_start", "chan");
        globalDeclaration.put("runnable2_start", "chan");
        globalDeclaration.put("runnable3_start", "chan");
        globalDeclaration.put("runnable4_start", "chan");
        globalDeclaration.put("runnable5_start", "chan");
        globalDeclaration.put("runnable6_start", "chan");
        globalDeclaration.put("task_start", "chan");
        globalDeclaration.put("overflow2", "chan");
        return globalDeclaration;
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
