package verification.experiment.autosar4;

import verification.uppaal.model.Template;

import java.util.*;

public class Experiment4_2 extends Experiment4 {
    @Override
    public String getStatement() {
        return "A[] buffer3.count >= 0";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> sendMap = new HashMap<>();
//        sendMap.put("runnable1_start", true);
//        sendMap.put("runnable1_finish", false);
//        sendMap.put("runnable2_start", true);
//        sendMap.put("runnable2_finish", false);
//        sendMap.put("task1_start", true);
        sendMap.put("read1", true);
        sendMap.put("write1", true);
        sendMap.put("write2", true);
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
//        list.add(AutosarEx4Util.buildRunnable1());
//        list.add(AutosarEx4Util.buildRunnable2());
        list.add(AutosarEx4Util.buildRunnable3());
        list.add(AutosarEx4Util.buildRunnable4());
        list.add(AutosarEx4Util.buildRunnable5());
        list.add(AutosarEx4Util.buildRunnable6());
        list.add(AutosarEx4Util.buildRunnable7());
        list.add(AutosarEx4Util.buildBuffer1());
        list.add(AutosarEx4Util.buildBuffer2());
        list.add(AutosarEx4Util.buildBuffer3());
//        list.add(AutosarEx4Util.buildTask1());
        list.add(AutosarEx4Util.buildTask2());
        list.add(AutosarEx4Util.buildTask3());
//        list.add(AutosarEx4Util.buildSchedule());
        return list;
    }

    @Override
    public List<Template> getM2() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx4Util.buildRunnable1());
        list.add(AutosarEx4Util.buildRunnable2());
        list.add(AutosarEx4Util.buildTask1());
        list.add(AutosarEx4Util.buildSchedule());
        return list;
    }
}
