package net.glacierclient.mod.impl.cosmetics.animations;

import net.glacierclient.mod.management.ModNoGUI;
import net.minecraft.client.Minecraft;
import org.lwjgl.opengl.GL11;

public class MotionBlur extends ModNoGUI {
    public MotionBlur() {
        super("MotionBlur", "Motion Blur Mod");
        modEnable = this.isEnabled();
    }
    public static float f;
    private static boolean modEnable;

    public static void createAccumulation() {
        if(modEnable)
        {
            float f = getAccumulationValue();
            GL11.glAccum(GL11.GL_MULT, f);
            GL11.glAccum(GL11.GL_ACCUM, 1.0F - f);
            GL11.glAccum(GL11.GL_RETURN, 1.0F);
        }
    }

    public static float getMultiplier() {
        return Minecraft.getDebugFPS() > 120 ? (Minecraft.getDebugFPS() > 200 ? 60.0F : 30.0F) : 0.0F;
    }

    public static float getAccumulationValue() {
        f = getMultiplier() * 10.0F;
        long lastTimestampInGame = System.currentTimeMillis();

        if (f > 996.0F) {
            f = 996.0F;
        }

        if (f > 990.0F) {
            f = 990.0F;
        }

        long i = System.currentTimeMillis() - lastTimestampInGame;

        if (i > 10000L) {
            return 0.0F;
        } else {
            if (f < 0.0F) {
                f = 0.0F;
            }

            return f / 1000.0F;
        }
    }

    @Override
    public void onEnable()
    {
        super.onEnable();
        modEnable = true;
        System.out.println("Loading MotionBlur");
    }

    @Override
    public void onDisable()
    {
        super.onDisable();
        modEnable = false;
        System.out.println("Unloading MotionBlur");
    }
}
