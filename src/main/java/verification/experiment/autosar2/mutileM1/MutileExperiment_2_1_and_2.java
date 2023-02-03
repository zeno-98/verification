package verification.experiment.autosar2.mutileM1;

import verification.experiment.Experiment;
import verification.experiment.autosar2.AutosarEx2Util;
import verification.plugins.SequenceChecker;
import verification.uppaal.model.Declaration;
import verification.uppaal.model.Template;

import java.util.*;

public class MutileExperiment_2_1_and_2 extends Experiment {
    @Override
    public String getStatement() {
        return "A[] (buffer1.count >=0)";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("read1", true);
        syncSendMap.put("write1", true);
        syncSendMap.put("runnable1_start", false);
        syncSendMap.put("runnable2_start", false);
        return syncSendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("read1");
        set.add("write1");
        set.add("runnable1_start");
        set.add("runnable2_start");
        return set;
    }

    @Override
    public List<Template> getM1() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx2Util.buildBuffer1());
        list.add(AutosarEx2Util.buildSchedule1());
        return list;
    }

    @Override
    public List<Template> getM2() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx2Util.buildRunnable1());
        list.add(AutosarEx2Util.buildRunnable2());
        list.add(AutosarEx2Util.buildRunnable3());
        list.add(AutosarEx2Util.buildRunnable4());
//        list.add(AutosarEx2Util.buildBuffer1());
        list.add(AutosarEx2Util.buildBuffer2());
        list.add(AutosarEx2Util.buildSchedule2());
//        list.add(AutosarEx2Util.buildSchedule1());
        return list;
    }

    @Override
    public String getNtaPath() {
        return ".\\src\\main\\resources\\verification\\autosar_ex2-source.xml";
    }

    @Override
    public Declaration getGlobalDeclaration() {
        Declaration globalDeclaration = new Declaration();
        globalDeclaration.put("read1,write1", "chan");
        globalDeclaration.put("read2,write2", "chan");
        globalDeclaration.put("runnable1_start", "chan");
        globalDeclaration.put("runnable2_start", "chan");
        globalDeclaration.put("runnable3_start", "chan");
        globalDeclaration.put("runnable4_start", "chan");
        return globalDeclaration;
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
