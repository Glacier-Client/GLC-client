package net.glacierclient.mod.impl.gui;

import net.glacierclient.mod.management.HudMod;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class RealTimeDisplay extends HudMod {


    public RealTimeDisplay()
    {
        super("Clock", 5, 55, false);
    }
    public RealTimeDisplay(boolean forceNew)
    {
        super("Clock", 5, 55, forceNew);
    }
    @Override
    public void draw()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();

        fr.drawString("§l§8Clock: §r§7" + dtf.format(localTime), getX(), getY(), -1);

        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        fr.drawString("§l§8Clock: §r§7" + dtf.format(localTime), getX(), getY(), -1);
        super.renderDummy(mouseX, mouseY);
    }
    @Override
    public int getWidth()
    {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("HH:mm:ss");
        LocalTime localTime = LocalTime.now();
        return fr.getStringWidth("§l§8Clock: §r§7" + dtf.format(localTime));
    }
    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT;
    }
}
