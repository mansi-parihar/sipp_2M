package lambdaExpression;
@FunctionalInterface
interface LightBehavior {
    void execute();
}

public class SmartHomeLigthningAutomation {
    public static void main(String[] args) {

        LightBehavior motionTrigger = () -> 
            System.out.println("Motion detected → Lights ON with soft white glow.");

        LightBehavior timeOfDayTrigger = () -> 
            System.out.println("Evening detected → Lights set to warm dim mode.");

        LightBehavior voiceCommandTrigger = () -> 
            System.out.println("Voice command received → Lights change to party mode!");

        activateLight(motionTrigger);
        activateLight(timeOfDayTrigger);
        activateLight(voiceCommandTrigger);
    }

    static void activateLight(LightBehavior behavior) {
        behavior.execute();
    }
}

    
}
