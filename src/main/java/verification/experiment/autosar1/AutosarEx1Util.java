package verification.experiment.autosar1;

import ta.ota.DOTA;
import ta.ota.DOTAUtil;
import verification.uppaal.model.Template;
import verification.uppaal.model.UppaalLocation;
import verification.uppaal.model.UppaalTransition;
import verification.uppaal.model.builder.TemplateBuilder;
import verification.uppaal.model.builder.UppaalTransitionBuilder;
import verification.util.UppaalModelUtil;

import java.io.IOException;

public class AutosarEx1Util {

    public static Template buildRunnable1() {
        String name = "runnable1";
        UppaalLocation s1 = UppaalModelUtil.buildUppaalLocation(name, "passive");
        UppaalLocation s2 = UppaalModelUtil.buildUppaalLocation(name, "active", "x<=4");
        UppaalLocation s3 = UppaalModelUtil.buildUppaalLocation(name, "write", "x<=4");
        UppaalLocation s4 = UppaalModelUtil.buildUppaalLocation(name, "active1", "x<=4&&x>=2");
        UppaalTransition t1 = new UppaalTransitionBuilder(s1, s2)
                .addSync("runnable1_start", "?")
                .addAssignment("x=0")
                .getUppaalTransition();
        UppaalTransition t2 = new UppaalTransitionBuilder(s2, s3)
                .addSync("write1", "!")
                .addGuard("write1_count<=2")
                .addAssignment("write1_count++")
                .getUppaalTransition();
        UppaalTransition t3 = new UppaalTransitionBuilder(s3, s2)
                .addSync("runnable2_start", "!")
                .getUppaalTransition();
        UppaalTransition t4 = new UppaalTransitionBuilder(s2, s4)
                .addSync("trigger1", "!")
                .addGuard("write1_count>=2")
                .addAssignment("write1_count=0")
                .getUppaalTransition();
        UppaalTransition t5 = new UppaalTransitionBuilder(s4, s1)
                .addGuard("x>=2")
                .getUppaalTransition();
        return new TemplateBuilder()
                .setName(name)
                .addLocalDeclaration("x", "clock")
                .addLocalDeclaration("write1_count", "int")
                .addInitLocation(s1)
                .addLocations(s2, s3, s4)
                .addTransitions(t1, t2, t3, t4, t5)
                .createTemplate();

    }

    public static Template buildRunnable2() {
        String name = "runnable2";
        UppaalLocation s1 = UppaalModelUtil.buildUppaalLocation(name, "passive");
        UppaalLocation s2 = UppaalModelUtil.buildCommittedUppaalLocation(name, "implic_R");
        UppaalLocation s3 = UppaalModelUtil.buildUppaalLocation(name, "active", "x<=4");
        UppaalTransition t1 = new UppaalTransitionBuilder(s1, s2)
                .addSync("runnable2_start", "?")
                .addAssignment("x=0")
                .getUppaalTransition();
        UppaalTransition t2 = new UppaalTransitionBuilder(s2, s2)
                .addGuard("read1_count<1")
                .addSync("read1", "!")
                .addAssignment("read1_count++")
                .getUppaalTransition();
        UppaalTransition t3 = new UppaalTransitionBuilder(s2, s3)
                .addGuard("read1_count>=1")
                .addAssignment("read1_count=0")
                .getUppaalTransition();
        UppaalTransition t4 = new UppaalTransitionBuilder(s3, s3)
                .addGuard("write1_count<=1")
                .addSync("write1", "!")
                .addAssignment("write1_count++")
                .getUppaalTransition();
        UppaalTransition t5 = new UppaalTransitionBuilder(s3, s1)
                .appendGuard("write1_count>=1")
                .addAssignment("write1_count=0")
                .getUppaalTransition();
        return new TemplateBuilder()
                .setName(name)
                .addLocalDeclaration("x", "clock")
                .addLocalDeclaration("read1_count", "int")
                .addLocalDeclaration("write1_count", "int")
                .addInitLocation(s1)
                .addLocations(s2, s3)
                .addTransitions(t1, t2, t3, t4, t5)
                .createTemplate();
    }

    public static Template buildRunnable3() {
        String name = "runnable3";

        UppaalLocation s1 = UppaalModelUtil.buildUppaalLocation(name, "s1");
        UppaalLocation s2 = UppaalModelUtil.buildUppaalLocation(name, "s2", "x<=4");

        UppaalLocation s3 = UppaalModelUtil.buildUppaalLocation(name, "s3", "x<=4&&x>=2");

        UppaalTransition t1 = new UppaalTransitionBuilder(s1, s2)
                .addSync("runnable3_start", "?")
                .addAssignment("x=0")
                .getUppaalTransition();
        UppaalTransition t2 = new UppaalTransitionBuilder(s2, s3)
                .addSync("read1", "!")
                .addGuard("x<=4")
                .getUppaalTransition();

        UppaalTransition t3 = new UppaalTransitionBuilder(s3, s1)
                .addGuard("x>=2")
                .getUppaalTransition();

        Template template = new TemplateBuilder()
                .setName(name)
                .addLocalDeclaration("x", "clock")
                .addInitLocation(s1)
                .addLocations(s2, s3)
                .addTransitions(t1, t2, t3)
                .createTemplate();

        return template;
    }

    public static Template buildBuffer1() {
        String name = "buffer1";
        UppaalLocation s1 = UppaalModelUtil.buildUppaalLocation(name, "initial");

        UppaalTransition t1 = new UppaalTransitionBuilder(s1, s1)
                .addSync("read1", "?")
                .addGuard("count>=0")
                .addAssignment("count--")
                .getUppaalTransition();
        UppaalTransition t2 = new UppaalTransitionBuilder(s1, s1)
                .addSync("write1", "?")
                .addGuard("count< len")
                .addAssignment("count++")
                .getUppaalTransition();
        UppaalTransition t3 = new UppaalTransitionBuilder(s1, s1)
                .addGuard("count >= len")
                .addAssignment("count = count/2")
                .getUppaalTransition();
        Template template = new TemplateBuilder()
                .setName(name)
                .addLocalDeclaration("count", "int")
                .addLocalDeclaration("len=1000", "int")
                .addInitLocation(s1)
                .addTransitions(t1, t2, t3)
                .createTemplate();
        return template;
    }

    public static Template buildRTE() {
        String name = "rte";
        UppaalLocation s1 = UppaalModelUtil.buildUppaalLocation(name, "s1");
        UppaalLocation s2 = UppaalModelUtil.buildUppaalLocation(name, "s2");
        UppaalLocation s3 = UppaalModelUtil.buildUppaalLocation(name, "s3", "x<=10");
        UppaalLocation s4 = UppaalModelUtil.buildUppaalLocation(name, "s4");
        UppaalTransition t1 = new UppaalTransitionBuilder(s1, s2)
                .addSync("trigger0", "?")
                .getUppaalTransition();
        UppaalTransition t2 = new UppaalTransitionBuilder(s2, s2)
                .addSync("trigger0", "?")
                .getUppaalTransition();
        UppaalTransition t3 = new UppaalTransitionBuilder(s2, s3)
                .addSync("trigger1", "?")
                .addAssignment("x=0")
                .getUppaalTransition();
        UppaalTransition t4 = new UppaalTransitionBuilder(s3, s1)
                .addGuard("x<=10")
                .addSync("runnable3_start", "!")
                .getUppaalTransition();
        UppaalTransition t5 = new UppaalTransitionBuilder(s1, s4)
                .addSync("trigger1", "?")
                .getUppaalTransition();
        UppaalTransition t6 = new UppaalTransitionBuilder(s4, s4)
                .addSync("trigger1", "?")
                .getUppaalTransition();
        UppaalTransition t7 = new UppaalTransitionBuilder(s4, s3)
                .addSync("trigger0", "?")
                .addAssignment("x=0")
                .getUppaalTransition();

        return new TemplateBuilder()
                .setName(name)
                .addLocalDeclaration("x", "clock")
                .addInitLocation(s1)
                .addLocations(s2, s3, s4)
                .addTransitions(t1, t2, t3, t4, t5, t6, t7)
                .createTemplate();
    }

    public static Template buildSchedule() {
        String name = "schedule";
        UppaalLocation s1 = UppaalModelUtil.buildUppaalLocation(name, "s1", "x<=10");
        UppaalLocation s2 = UppaalModelUtil.buildUppaalLocation(name, "s2", "x<=10");
        UppaalLocation s3 = UppaalModelUtil.buildUppaalLocation(name, "s3", "x<=20");
        UppaalLocation s4 = UppaalModelUtil.buildUppaalLocation(name, "s4", "x<=20");
        UppaalTransition t1 = new UppaalTransitionBuilder(s1, s2)
                .addGuard("x<=10")
                .addSync("runnable1_start", "!")
                .addAssignment("x=0")
                .getUppaalTransition();
        UppaalTransition t2 = new UppaalTransitionBuilder(s2, s3)
                .addGuard("x<=10")
                .addSync("trigger0", "!")
                .addAssignment("x=0")
                .getUppaalTransition();
        UppaalTransition t3 = new UppaalTransitionBuilder(s3, s4)
                .addGuard("x<=20")
                .addSync("runnable1_start", "!")
                .addAssignment("x=0")
                .getUppaalTransition();
        UppaalTransition t4 = new UppaalTransitionBuilder(s4, s1)
                .addGuard("x<=20")
                .addSync("trigger0", "!")
                .addAssignment("x=0")
                .getUppaalTransition();
        return new TemplateBuilder()
                .setName(name)
                .addInitLocation(s1)
                .addLocations(s2, s3, s4)
                .addTransitions(t1, t2, t3, t4)
                .addLocalDeclaration("x", "clock")
                .createTemplate();
    }


    public static DOTA buildComponent() throws IOException {
        String base = ".\\src\\main\\resources\\";
        String path = base + "autosar_ex1\\schedule.json";
        return DOTAUtil.getDOTAFromJsonFile(path);
    }


}

























