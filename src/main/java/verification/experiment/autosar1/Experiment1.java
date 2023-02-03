package verification.experiment.autosar1;

import verification.experiment.Experiment;
import verification.plugins.SequenceChecker;
import verification.uppaal.model.Declaration;
import verification.uppaal.model.Template;

import java.util.*;

public abstract class Experiment1 extends Experiment {

    public abstract String getStatement();

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("runnable1_start", true);
        syncSendMap.put("trigger0", true);
        return syncSendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("runnable1_start");
        set.add("trigger0");
        return set;
    }

    @Override
    public List<Template> getM1() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx1Util.buildRunnable1());
        list.add(AutosarEx1Util.buildRunnable2());
        list.add(AutosarEx1Util.buildRunnable3());
        list.add(AutosarEx1Util.buildBuffer1());
        list.add(AutosarEx1Util.buildRTE());
        return list;
    }

    @Override
    public List<Template> getM2() {
        return Collections.singletonList(AutosarEx1Util.buildSchedule());
    }

    @Override
    public String getNtaPath() {
        return ".\\src\\main\\resources\\verification\\autosar_ex1-source.xml";
    }

    @Override
    public List<SequenceChecker> getSequenceChecker() {
        SequenceChecker plugin = new SequenceChecker(false);
        String s = "[circle]:(runnable1_start,trigger0)";
        plugin.add(s);
        return Collections.singletonList(plugin);
    }

    @Override
    public Declaration getGlobalDeclaration() {
        Declaration globalDeclaration = new Declaration();
        globalDeclaration.put("read1,write1", "chan");
        globalDeclaration.put("runnable1_start", "chan");
        globalDeclaration.put("runnable2_start", "chan");
        globalDeclaration.put("runnable3_start", "chan");
        globalDeclaration.put("trigger0,trigger1", "chan");
        return globalDeclaration;
    }
}
