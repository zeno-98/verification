package verification.experiment.autosar4;

import verification.plugins.SequenceChecker;
import verification.uppaal.model.Template;
import verification.util.VerificationUtil;

import java.io.IOException;
import java.util.*;

public class Experiment4_3 extends Experiment4 {
    @Override
    public String getStatement() {
        return "A[] buffer1.count >= 0";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> sendMap = new HashMap<>();
        sendMap.put("runnable1_start", true);
        sendMap.put("runnable1_finish", true);
        sendMap.put("runnable2_start", true);
        sendMap.put("runnable2_finish", true);
        sendMap.put("task2_start", true);
        sendMap.put("task3_start", true);
        return sendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> resetSigma = new HashSet<>();
        resetSigma.add("task3_start");
        return resetSigma;
    }

    @Override
    public List<Template> getM1() {
        List<Template> list = new ArrayList<>();
        list.add(Experiment4Util.buildRunnable1());
        list.add(Experiment4Util.buildRunnable2());
        list.add(Experiment4Util.buildRunnable3());
        list.add(Experiment4Util.buildRunnable4());
        list.add(Experiment4Util.buildRunnable5());
        list.add(Experiment4Util.buildRunnable6());
        list.add(Experiment4Util.buildRunnable7());
        list.add(Experiment4Util.buildBuffer1());
        list.add(Experiment4Util.buildBuffer2());
        list.add(Experiment4Util.buildBuffer3());
        list.add(Experiment4Util.buildTask2());
        list.add(Experiment4Util.buildTask3());
        return list;
    }

    @Override
    public List<Template> getM2() throws IOException {
        List<Template> list = new ArrayList<>();
        Template template = VerificationUtil.transToUppaal(Experiment4Util.buildComponent1_2_1());
        VerificationUtil.refine(template, getSyncSendMap(), true);
        list.add(template);
        return list;
    }

    @Override
    public List<SequenceChecker> getSequenceChecker() {
        SequenceChecker plugin = new SequenceChecker(false);
        String s0 = "[startWith]:(task2_start, runnable1_start)";
        String s1 = "[startWith]:(runnable1_start,runnable1_finish)";
        String s3 = "[startWith]:(runnable1_start)";
        String s4 = "[startWith]:(runnable1_finish,runnable2_start)";
        plugin.add(s0);
        plugin.add(s1);
        plugin.add(s3);
        plugin.add(s4);

        SequenceChecker plugin2 = new SequenceChecker(true);
        plugin2.add("[beforeAfter]:(runnable1_start, runnable1_finish)");
        plugin2.add("[beforeAfter]:(runnable2_start, runnable2_finish)");
        return Arrays.asList(plugin, plugin2);
    }
}
