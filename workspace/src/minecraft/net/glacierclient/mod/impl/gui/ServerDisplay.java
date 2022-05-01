package net.glacierclient.mod.impl.gui;

import net.glacierclient.mod.management.HudMod;

public class ServerDisplay extends HudMod {


    public ServerDisplay()
    {
        super("ServerDisplay", 5, 35, false);
    }
    public ServerDisplay(boolean forceNew)
    {
        super("ServerDisplay", 5, 35, forceNew);
    }
    @Override
    public void draw()
    {
        try {
            if (mc.getCurrentServerData().serverIP != null) {
                fr.drawString("§l§8Server: §r§7" + mc.getCurrentServerData().serverIP, getX(), getY(), -1);
            } else {
                fr.drawString("§l§8Server: §r§7SinglePlayer", getX(), getY(), -1);
            }
        }
        catch (Exception e)
        {
            fr.drawString("§l§8Server: §r§7SinglePlayer", getX(), getY(), -1);
        }
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("§l§8Server: §r§7ServerIp", getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    @Override
    public int getWidth()
    {
        return fr.getStringWidth("§l§8Server §r SinglePlayer");
    }
    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
