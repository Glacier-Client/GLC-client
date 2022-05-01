package net.glacierclient.mod.ui.clientsettings.togglegui.comp;

import net.glacierclient.mod.management.HudMod;
import net.minecraft.client.Minecraft;


import java.awt.*;

public class ModButtonGUIMod {

    public int x, y, w, h;
    public HudMod m;


    public ModButtonGUIMod(int x, int y, int w, int h, HudMod m)
    {
        this.x = x;
        this.y = y;
        this.w = w;
        this.h = h;
        this.m = m;
    }

    public void draw()
    {
        //Gui.drawRect(x, y, w, h, new Color(0,0,0, 170).getRGB());
        Minecraft.getMinecraft().fontRendererObj.drawString(m.name, x + 2, y + 2, getColour()); //m.name, x + 2, y + 2, getColour()

    }

    public int getColour()
    {
        if(m.isEnabled())
        {
            return new Color(0, 255,0,255).getRGB();
        }
        else
        {
            return new Color(255, 0, 0, 255).getRGB();
        }
    }

    public void onClick(int mouseX, int mouseY, int button)
    {
        if(mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY <= y + h)
        {
            m.toggle();
            System.out.println(m.name);
        }
    }

}
