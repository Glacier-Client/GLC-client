package net.glacierclient.mod.management;

import net.glacierclient.mod.impl.*;
import net.glacierclient.mod.impl.cosmetics.Capes;
import net.glacierclient.mod.impl.cosmetics.OneDotSevenAnimations;

import java.util.ArrayList;

public class ModManager {

    public ToggleSprint toggleSprint;
    public OneDotSevenAnimations oneDotSevenAnimations;
    public Capes capes;

    public ArrayList<ModNoGUI> mods;

    public ModManager()
    {
        mods = new ArrayList<>();
        //Misc
        mods.add(toggleSprint = new ToggleSprint());
        mods.add(oneDotSevenAnimations = new OneDotSevenAnimations());
        mods.add(capes = new Capes());
    }

}
