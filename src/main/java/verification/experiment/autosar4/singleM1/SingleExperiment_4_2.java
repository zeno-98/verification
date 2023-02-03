package verification.experiment.autosar4.singleM1;

import verification.experiment.autosar4.Experiment4;
import verification.experiment.autosar4.Experiment4Util;
import verification.uppaal.model.Template;

import java.io.IOException;
import java.util.*;

public class SingleExperiment_4_2 extends Experiment4 {

    @Override
    public String getStatement() {
        return "A[] buffer2.count >= 0";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> sendMap = new HashMap<>();
        sendMap.put("read2", true);
        sendMap.put("write2", true);
        return sendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("read2");
        set.add("write2");
        return set;
    }

    @Override
    public List<Template> getM1() {
        List<Template> list = new ArrayList<>();
        list.add(Experiment4Util.buildBuffer2());
        return list;
    }

    @Override
    public List<Template> getM2() throws IOException {
        List<Template> list = new ArrayList<>();
        list.add(Experiment4Util.buildRunnable1());
        list.add(Experiment4Util.buildRunnable2());
        list.add(Experiment4Util.buildRunnable3());
        list.add(Experiment4Util.buildRunnable4());
        list.add(Experiment4Util.buildRunnable5());
        list.add(Experiment4Util.buildRunnable6());
        list.add(Experiment4Util.buildRunnable7());
        list.add(Experiment4Util.buildBuffer1());
//        list.add(Experiment4Util.buildBuffer2());
        list.add(Experiment4Util.buildBuffer3());
        list.add(Experiment4Util.buildTask1());
        list.add(Experiment4Util.buildTask2());
        list.add(Experiment4Util.buildTask3());
        list.add(Experiment4Util.buildSchedule());
        return list;
    }
}
