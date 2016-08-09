package space.nodemc.stresstester;

public class Main {

    public static int tickSpeed;
    public static long lastTickTime = System.currentTimeMillis();
    public static long elapsedTime;
    public static int tick;

    public static void main(String[] args) {
        tickSpeed = 50;

        System.out.println("TPS: " + 1000 / tickSpeed);

        tick = 0;

        while (true) {
            elapsedTime = System.currentTimeMillis() - lastTickTime;
            lastTickTime = System.currentTimeMillis();

            doTick();

            tick++;

            long tickProcessingTime = System.currentTimeMillis() - lastTickTime;
            if (tickProcessingTime < tickSpeed) {
                try {
                    Thread.sleep(tickSpeed - tickProcessingTime);
                } catch (Exception e) {
                    System.err.println("Error: " + e);
                }
            }
        }
    }

    public static void doTick() {
        System.out.println(tick);
    }

}
