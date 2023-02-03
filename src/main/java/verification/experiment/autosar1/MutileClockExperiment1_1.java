package verification.experiment.autosar1;

import verification.uppaal.model.Template;

import java.util.*;

public class MutileClockExperiment1_1 extends Experiment1 {
    @Override
    public String getStatement() {
        //"A[] (buffer1.count >=0)" 无法验证：uppaal接口返回无法生成trace, 但是直接用uppaal验证可以得到trace
        // 其余均可验证
        // A[] not (runnable1.active1 and runnable2.implic_R)
        // A[] not (runnable1.active and runnable2.active)
        // A[] (buffer1.count <= buffer1.len)
        return "A[] not (runnable1.active and runnable2.active)";
    }

    @Override
    public Map<String, Boolean> getSyncSendMap() {
        Map<String, Boolean> syncSendMap = new HashMap<>();
        syncSendMap.put("runnable1_start", true);
        syncSendMap.put("runnable3_start", true);
        syncSendMap.put("trigger1", false);
        return syncSendMap;
    }

    @Override
    public Set<String> getResetSigma() {
        Set<String> set = new HashSet<>();
        set.add("runnable1_start");
        set.add("trigger1");
        set.add("runnable3_start");
        return set;
    }

    @Override
    public List<Template> getM1() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx1Util.buildRunnable1());
        list.add(AutosarEx1Util.buildRunnable2());
        list.add(AutosarEx1Util.buildRunnable3());
        list.add(AutosarEx1Util.buildBuffer1());
        return list;
    }

    @Override
    public List<Template> getM2() {
        List<Template> list = new ArrayList<>();
        list.add(AutosarEx1Util.buildSchedule());
        list.add(AutosarEx1Util.buildRTE());
        return list;
    }
}
