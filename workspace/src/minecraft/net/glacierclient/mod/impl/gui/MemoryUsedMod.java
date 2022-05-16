package net.glacierclient.mod.impl.gui;

import net.glacierclient.mod.management.HudMod;

public class MemoryUsedMod extends HudMod {


    public MemoryUsedMod()
    {
        super("MemoryUsedMod", 5, 45, false);
    }
    public MemoryUsedMod(boolean forceNew)
    {
        super("MemoryUsedMod", 5, 45, forceNew);
    }
    @Override
    public void draw()
    {
        fr.drawString("§l§8Memory: §r§7" + (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000) + " MB / " + (int) (Runtime.getRuntime().totalMemory() / 100000) + " MB", getX(), getY(), -1);

        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("§l§8Memory: §r§7" + (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000) + " MB / " + (int) (Runtime.getRuntime().totalMemory() / 100000) + " MB", getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    @Override
    public int getWidth()
    {
        return fr.getStringWidth("§l§8Memory: §r§7" + (int) ((Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / 1000000) + " MB / " + (int) (Runtime.getRuntime().totalMemory() / 100000) + " MB");
    }
    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
