package net.glacierclient.mod.management;

import net.glacierclient.mod.impl.cosmetics.Capes;
import net.glacierclient.mod.impl.cosmetics.OneDotSevenAnimations;
import net.glacierclient.mod.impl.movement.ToggleSprintSneak;

import java.util.ArrayList;

public class ModManager {

    public ToggleSprintSneak toggleSprint;
    public OneDotSevenAnimations oneDotSevenAnimations;
    public Capes capes;

    public ArrayList<ModNoGUI> mods;

    public ModManager()
    {
        mods = new ArrayList<>();
        //Misc
        mods.add(toggleSprint = new ToggleSprintSneak());
        mods.add(oneDotSevenAnimations = new OneDotSevenAnimations());
        mods.add(capes = new Capes());
    }

}
