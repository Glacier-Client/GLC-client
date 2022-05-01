package net.glacierclient.mod.impl.gui;

import net.glacierclient.mod.management.HudMod;

public class FPSMod extends HudMod {


    public FPSMod()
    {
        super("FPS", 5, 15, false);
    }
    public FPSMod(boolean forceNew)
    {
        super("FPS", 5, 15, forceNew);
    }
    @Override
    public void draw()
    {
        fr.drawString("§l§8FPS: §r§7" + mc.getDebugFPS(), getX(), getY(), -1);

        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("§l§8FPS: §r§7" + mc.getDebugFPS() + " §l§8", getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    @Override
    public int getWidth()
    {
        return fr.getStringWidth("§l§8FPS: §r§7" + mc.getDebugFPS() + " §l§8]");
    }
    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
