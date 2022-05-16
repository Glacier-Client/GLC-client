package net.glacierclient.mod.impl.movement;

import net.glacierclient.event.EventTarget;
import net.glacierclient.event.impl.EventUpdate;
import net.glacierclient.mod.management.ModNoGUI;
import net.minecraft.potion.Potion;

public class ToggleSprintSneak extends ModNoGUI {
    public ToggleSprintSneak() {

        super("ToggleSprint", "ToggleSprint");
    }

    @EventTarget
    public void onUpdate(EventUpdate event)
    {
        if(this.isEnabled()
                && !mc.thePlayer.isBlocking()
                && !mc.thePlayer.isSneaking()
                && (mc.thePlayer.motionX != 0 && mc.thePlayer.motionZ != 0)
                && !mc.thePlayer.isCollidedHorizontally
                && !mc.thePlayer.isPotionActive(Potion.moveSlowdown)
                && !mc.thePlayer.isPotionActive(Potion.confusion)
                && !mc.gameSettings.keyBindBack.isKeyDown())
        {
            mc.thePlayer.setSprinting(true);
        }
    }

    @Override
    public void onEnable()
    {
        super.onEnable();
        System.out.println("Loading ToggleSprint");
    }
    @Override
    public void onDisable()
    {
        super.onDisable();
        System.out.println("Unloading ToggleSprint");
        mc.thePlayer.setSprinting(false);
    }
}
