package net.glacierclient.mod.impl.gui;

import net.glacierclient.mod.management.HudMod;
import org.lwjgl.input.Mouse;

import java.util.ArrayList;
import java.util.List;

public class CPSMod extends HudMod {


    private List<Long>  clicksL = new ArrayList<Long>();
    private boolean wasPressedL;
    private long lastPressedL;
    private List<Long>  clicksR = new ArrayList<Long>();
    private boolean wasPressedR;
    private long lastPressedR;

    public CPSMod()
    {
        super("CPS", 5, 65, false);
    }
    public CPSMod(boolean forceNew)
    {
        super("CPS", 5, 25, forceNew);
    }
    @Override
    public void draw()
    {
        final boolean pressedL = Mouse.isButtonDown(0);
        final boolean pressedR = Mouse.isButtonDown(1);
        if(pressedL != this.wasPressedL)
        {
            this.lastPressedL = System.currentTimeMillis();
            this.wasPressedL = pressedL;
            if(pressedL)
            {
                this.clicksL.add(this.lastPressedL);
            }
        }
        if(pressedR != this.wasPressedR)
        {
            this.lastPressedR = System.currentTimeMillis();
            this.wasPressedR = pressedR;
            if(pressedR)
            {
                this.clicksR.add(this.lastPressedR);
            }
        }

        fr.drawString("§l§8CPS: §r§7[ " + getCPSL() + " | " + getCPSR() + " ]", getX(), getY(), -1);

        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawString("§l§8CPS: §r§7 00 §l§8", getX(), getY(), -1);
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

    private int getCPSL()
    {
        final long time = System.currentTimeMillis();
        this.clicksL.removeIf(aLong -> aLong + 1000 < time);
        return this.clicksL.size();
    }
    private int getCPSR()
    {
        final long time = System.currentTimeMillis();
        this.clicksR.removeIf(aLong -> aLong + 1000 < time);
        return this.clicksR.size();
    }
}
