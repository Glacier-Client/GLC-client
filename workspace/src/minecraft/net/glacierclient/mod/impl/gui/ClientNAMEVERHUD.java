package net.glacierclient.mod.impl.gui;

import net.glacierclient.GlacierClient;
import net.glacierclient.mod.management.HudMod;

public class ClientNAMEVERHUD extends HudMod {


    public ClientNAMEVERHUD()
    {
        super("NAMEVER", 5, 5, false);
    }
    public ClientNAMEVERHUD(boolean forceNew)
    {
        super("NAMEVER", 5, 5, forceNew);
    }
    @Override
    public void draw()
    {
        fr.drawString(GlacierClient.INSTANCE.NAMEVER, getX(), getY(), -1);

        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString(GlacierClient.INSTANCE.NAMEVER, getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    @Override
    public int getWidth()
    {
        return fr.getStringWidth(GlacierClient.INSTANCE.NAMEVER);
    }
    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
