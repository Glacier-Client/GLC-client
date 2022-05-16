package net.glacierclient.mod.management;

import net.glacierclient.mod.impl.gui.*;

import java.util.ArrayList;

public class HudManager {

    public ArrayList<HudMod> hudMods = new ArrayList<>();

    public ClientNAMEVERHUD clientNAMEVERHUD;
    public FPSMod fps;
    public CPSMod cps;
    public TargetHUD targetHUD;
    public CoordinatesHud coordinatesHud;
    public ServerDisplay serverDisplay;
    public MemoryUsedMod memoryUsedMod;
    public RealTimeDisplay realTimeDisplay;
    public KeyStrokes keyStrokes;

    public HudManager() {
        loadAllMods();
    }

    public void renderMods()
    {
        for(HudMod m : hudMods)
        {
            if(m.isEnabled()) {
                m.draw();
            }
        }
    }
    public void saveAllMods()
    {
        for(HudMod m : hudMods)
        {
            m.saveHudMod();
        }
    }

    public void loadAllMods()
    {
        hudMods.add(clientNAMEVERHUD = new ClientNAMEVERHUD());
        hudMods.add(fps = new FPSMod());
        hudMods.add(targetHUD = new TargetHUD());
        hudMods.add(coordinatesHud = new CoordinatesHud());
        hudMods.add(serverDisplay = new ServerDisplay());
        hudMods.add(memoryUsedMod = new MemoryUsedMod());
        hudMods.add(realTimeDisplay = new RealTimeDisplay());
        hudMods.add(keyStrokes = new KeyStrokes());
        hudMods.add(cps = new CPSMod());
    }

    public void unloadAllMods() {
        hudMods.remove(clientNAMEVERHUD);
        hudMods.remove(fps);
        hudMods.remove(targetHUD);
        hudMods.remove(coordinatesHud);
        hudMods.remove(serverDisplay);
        hudMods.remove(memoryUsedMod);
        hudMods.remove(realTimeDisplay);
        hudMods.remove(keyStrokes);
        hudMods.remove(cps);
    }
    public void loadAllModsForceNew()
    {
        hudMods.add(clientNAMEVERHUD = new ClientNAMEVERHUD(true));
        hudMods.add(fps = new FPSMod(true));
        hudMods.add(targetHUD = new TargetHUD(true));
        hudMods.add(coordinatesHud = new CoordinatesHud(true));
        hudMods.add(serverDisplay = new ServerDisplay(true));
        hudMods.add(memoryUsedMod = new MemoryUsedMod(true));
        hudMods.add(realTimeDisplay = new RealTimeDisplay(true));
        hudMods.add(keyStrokes = new KeyStrokes(true));
        hudMods.add(cps = new CPSMod(true));
    }
}
