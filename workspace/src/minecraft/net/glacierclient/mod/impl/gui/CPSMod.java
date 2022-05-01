package net.glacierclient.mod.impl.gui;

import net.glacierclient.mod.management.HudMod;

public class CPSMod extends HudMod {


    public CPSMod()
    {
        super("CPS", 5, 25, false);
    }
    public CPSMod(boolean forceNew)
    {
        super("CPS", 5, 25, forceNew);
    }
    @Override
    public void draw()
    {
        fr.drawString("§l§8CPS: §r§7" + mc.getDebugFPS(), getX(), getY(), -1);

        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("§l§8CPS: §r§7" + mc.getDebugFPS() + " §l§8", getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    @Override
    public int getWidth()
    {
        return fr.getStringWidth("§l§8FPS: §r§7" + mc.getDebugFPS() + " §l§8");
    }
    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
