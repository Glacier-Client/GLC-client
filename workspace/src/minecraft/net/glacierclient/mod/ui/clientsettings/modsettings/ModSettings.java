package net.glacierclient.mod.ui.clientsettings.modsettings;

import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;

public class ModSettings extends GuiScreen
{

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTick) {
        ScaledResolution sr = new ScaledResolution(mc);
        super.drawScreen(mouseX, mouseY, partialTick);
        Gui.drawRect(50, 50, sr.getScaledWidth() - 50, sr.getScaledHeight() - 50, new Color(0, 0, 0, 170).getRGB());
    }
    @Override
    public void initGui()
    {
        super.initGui();
        this.drawCenteredString(fontRendererObj, "TBA", this.width/2, this.height/2, new Color(255, 255, 255,255).getRGB());
    }
}
