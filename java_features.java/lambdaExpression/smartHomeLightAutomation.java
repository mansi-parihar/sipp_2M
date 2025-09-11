package lambdaExpression;
import java.util.*;
public class smartHomeLightAutomation {
    public interface LightAction { 
        void execute(Light light, TriggerData data); 
    }

    public static class Light {
        public final String id;
        private boolean on;
        private int brightness;
        private String color;

        public Light(String id) { this.id = id; this.on = false; this.brightness = 0; this.color = "neutral"; }
        public void setOn(boolean on) { this.on = on; }
        public void setBrightness(int b) { this.brightness = Math.max(0, Math.min(100, b)); }
        public void setColor(String color) { this.color = color; }
        @Override
        public String toString() { return "Light{" + id + ": on=" + on + ", brightness=" + brightness + ", color='" + color + "'}"; }
    }

    public static class TriggerData {
        private final Map<String,Object> map = new HashMap<>();
        public void put(String k, Object v) { map.put(k,v); }
        @SuppressWarnings("unchecked")
        public <T> T get(String k, Class<T> cls) { Object v = map.get(k); return v == null ? null : (T) v; }
    }

    public enum TriggerType { MOTION, TIME_OF_DAY, VOICE }

    public static class Controller {
        private final Map<TriggerType, LightAction> actions = new EnumMap<>(TriggerType.class);
        public void register(TriggerType t, LightAction a) { actions.put(t,a); }
        public void trigger(TriggerType t, Light light, TriggerData data) {
            LightAction a = actions.get(t);
            if (a != null) a.execute(light, data);
        }
    }

    public static void main(String[] args) {
        Light hallway = new Light("hallway");
        Light livingRoom = new Light("livingRoom");

        Controller controller = new Controller();

        controller.register(TriggerType.MOTION, (light, data) -> {
            Integer intensity = data.get("intensity", Integer.class);
            String zone = data.get("zone", String.class);
            if (intensity == null) intensity = 1;
            light.setOn(true);
            if (intensity > 7) {
                light.setBrightness(100);
                light.setColor("warm");
            } else if (intensity > 3) {
                light.setBrightness(70);
                light.setColor("soft-warm");
            } else {
                light.setBrightness(40);
                light.setColor("cool");
            }
            System.out.println("[MOTION] " + zone + " => " + light);
        });

        controller.register(TriggerType.TIME_OF_DAY, (light, data) -> {
            String period = data.get("period", String.class);
            if ("night".equalsIgnoreCase(period)) {
                light.setOn(true);
                light.setBrightness(20);
                light.setColor("warm-dim");
            } else if ("evening".equalsIgnoreCase(period)) {
                light.setOn(true);
                light.setBrightness(60);
                light.setColor("warm");
            } else {
                light.setOn(true);
                light.setBrightness(100);
                light.setColor("neutral");
            }
            System.out.println("[TIME] " + period + " => " + light);
        });

        controller.register(TriggerType.VOICE, (light, data) -> {
            String command = data.get("command", String.class);
            if (command == null) command = "";
            switch (command.toLowerCase()) {
                case "movie":
                    light.setOn(true);
                    light.setBrightness(15);
                    light.setColor("deep-warm");
                    break;
                case "party":
                    light.setOn(true);
                    light.setBrightness(100);
                    light.setColor("color-cycle");
                    break;
                case "good night":
                    light.setOn(false);
                    light.setBrightness(0);
                    break;
                default:
                    light.setOn(true);
                    light.setBrightness(70);
                    light.setColor("neutral");
                    break;
            }
            System.out.println("[VOICE] '" + command + "' => " + light);
        });

        TriggerData motionData = new TriggerData();
        motionData.put("intensity", 8);
        motionData.put("zone", "hallway");
        controller.trigger(TriggerType.MOTION, hallway, motionData);

        TriggerData timeData = new TriggerData();
        timeData.put("period", "night");
        controller.trigger(TriggerType.TIME_OF_DAY, livingRoom, timeData);

        TriggerData voiceData = new TriggerData();
        voiceData.put("command", "movie");
        controller.trigger(TriggerType.VOICE, livingRoom, voiceData);

        TriggerData lowMotion = new TriggerData();
        lowMotion.put("intensity", 2);
        lowMotion.put("zone", "livingRoom");
        controller.trigger(TriggerType.MOTION, livingRoom, lowMotion);
    }
}

    
}
