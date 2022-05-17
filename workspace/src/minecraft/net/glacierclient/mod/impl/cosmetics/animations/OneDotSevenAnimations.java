package net.glacierclient.mod.impl.cosmetics.animations;

import net.glacierclient.mod.management.ModNoGUI;

public class OneDotSevenAnimations extends ModNoGUI {
    public OneDotSevenAnimations() {
        super("1.7 Animations","1.7 Animations");
    }
    public void onEnable()
    {
        super.onEnable();
        System.out.println("Loading 1.7 Animations");
    }
    @Override
    public void onDisable()
    {
        super.onDisable();
        System.out.println("Unloading 1.7 Animations");
    }
}
