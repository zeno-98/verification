package verification.experiment.autosar4;

import verification.uppaal.model.Template;
import verification.util.VerificationUtil;

import java.io.IOException;
import java.util.*;


/**
 * case 1: buildTask1 + buildRunnable2 + buildSchedule
 * case 2:
 * case 3:
 */
public class Experiment4_1 extends Experiment4 {

    @Override
    public String getStatement() {
        return "A[] buffer1.count >= 0";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> sendMap = new HashMap<>();
        sendMap.put("read1", true);
        sendMap.put("write1", true);
        sendMap.put("write2", true);
        sendMap.put("runnable1_start", true);
        sendMap.put("runnable1_finish", false);
//        sendMap.put("runnable2_start",true);
//        sendMap.put("runnable2_finish",true);
//        sendMap.put("task1_start", true);
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
//        list.add(AutosarEx4Util.buildRunnable2());
        list.add(Experiment4Util.buildRunnable3());
        list.add(Experiment4Util.buildRunnable4());
        list.add(Experiment4Util.buildRunnable5());
        list.add(Experiment4Util.buildRunnable6());
        list.add(Experiment4Util.buildRunnable7());
        list.add(Experiment4Util.buildBuffer1());
        list.add(Experiment4Util.buildBuffer2());
        list.add(Experiment4Util.buildBuffer3());
//        list.add(AutosarEx4Util.buildTask1());
        list.add(Experiment4Util.buildTask2());
        list.add(Experiment4Util.buildTask3());
//        list.add(AutosarEx4Util.buildSchedule());
        return list;
    }

    @Override
    public List<Template> getM2() throws IOException {
        List<Template> list = new ArrayList<>();
        Template template = VerificationUtil.transToUppaal(Experiment4Util.buildComponent1_3());
        VerificationUtil.refine(template, getSyncSendMap(), true);
        list.add(template);
        return list;
    }
}
