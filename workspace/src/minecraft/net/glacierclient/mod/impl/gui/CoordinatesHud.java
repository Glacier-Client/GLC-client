package net.glacierclient.mod.impl.gui;

import net.glacierclient.mod.management.HudMod;

public class CoordinatesHud extends HudMod {


    public CoordinatesHud()
    {
        super("CoordinatesHud", 5, 25, false);
    }
    public CoordinatesHud(boolean forceNew)
    {
        super("CoordinatesHud", 5, 25, forceNew);
    }
    @Override
    public void draw()
    {
        fr.drawString("§r§l§8X: §r§7" + mc.thePlayer.getPosition().getX() + " §r§l§8Y: §r§7" + mc.thePlayer.getPosition().getY() + " §r§l§8Z: §r§7" + mc.thePlayer.getPosition().getZ(), getX(), getY(), -1);

        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("§r§l§8X: §r§7" + mc.thePlayer.getPosition().getX() + " §r§l§8Y: §r§7" + mc.thePlayer.getPosition().getY() + " §r§l§8Z: §r§7" + mc.thePlayer.getPosition().getZ(), getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    @Override
    public int getWidth()
    {
        return 100;//fr.getStringWidth((String) ("X: " + mc.thePlayer.getPosition().getX() + " Y: " + mc.thePlayer.getPosition().getY() + " Z: " + mc.thePlayer.getPosition().getZ()));
    }
    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
