package verification.experiment.autosar3;

/**
 * case 1: buildTask1 + buildRunnable2 + buildSchedule
 * case 2:
 * case 3:
 */
public class Experiment3_1 extends Experiment3 {

    @Override
    public String getStatement() {
        return "A[] buffer1.count >= 0";
    }

//    @Override
//    public Map<String, Boolean> getSyncSendMap() {
//        Map<String, Boolean> syncSendMap = new HashMap<>();
//        syncSendMap.put("task_start", false);
//        syncSendMap.put("runnable4_start", true);
//        syncSendMap.put("runnable5_start", true);
//        syncSendMap.put("runnable6_start", true);
//        return syncSendMap;
//    }
//
//    @Override
//    public Set<String> getResetSigma() {
//        Set<String> set = new HashSet<>();
//        set.add("task_start");
//        set.add("runnable4_start");
//        set.add("runnable5_start");
//        set.add("runnable6_start");
//        return set;
//    }
//
//    @Override
//    public List<Template> getM1() {
//        List<Template> list = new ArrayList<>();
//        list.add(AutosarEx3Util.buildRunnable1());
//        list.add(AutosarEx3Util.buildRunnable2());
//        list.add(AutosarEx3Util.buildRunnable3());
//        list.add(AutosarEx3Util.buildRunnable4());
//        list.add(AutosarEx3Util.buildRunnable5());
//        list.add(AutosarEx3Util.buildRunnable6());
//        list.add(AutosarEx3Util.buildBuffer1());
//        list.add(AutosarEx3Util.buildBuffer2());
//        list.add(AutosarEx3Util.buildBuffer3());
//        list.add(AutosarEx3Util.buildBuffer4());
//        list.add(AutosarEx3Util.buildBuffer5());
//        list.add(AutosarEx3Util.buildRTE());
////        list.add(AutosarEx3Util.buildSchedule());
//        list.add(AutosarEx3Util.buildTask());
//        return list;
//    }
//
//    @Override
//    public List<Template> getM2() {
//        List<Template> list = new ArrayList<>();
//        list.add(AutosarEx3Util.buildSchedule());
//        return list;
//    }
}
