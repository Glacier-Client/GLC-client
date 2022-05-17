package net.glacierclient.mod.ui.clientsettings.togglegui;

import net.glacierclient.GlacierClient;
import net.glacierclient.mod.ui.clientsettings.ClientSettings;
import net.glacierclient.mod.ui.clientsettings.togglegui.comp.ModButtonGUIMod;
import net.glacierclient.mod.ui.clientsettings.togglegui.comp.ModButtonMod;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.util.ResourceLocation;


import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class ToggleGUI extends GuiScreen {

    ArrayList<ModButtonGUIMod> modButtonsGUIMod = new ArrayList<>();
    ArrayList<ModButtonMod> modButtons = new ArrayList<>();

    @Override
    public void initGui()
    {
        super.initGui();
        this.modButtonsGUIMod.add(new ModButtonGUIMod(60, 60, 80, 10, GlacierClient.INSTANCE.hudManager.clientNAMEVERHUD));
        this.modButtonsGUIMod.add(new ModButtonGUIMod(60, 80, 80, 10, GlacierClient.INSTANCE.hudManager.fps));
        this.modButtonsGUIMod.add(new ModButtonGUIMod(60, 100, 80, 10 , GlacierClient.INSTANCE.hudManager.targetHUD));
        this.modButtonsGUIMod.add(new ModButtonGUIMod(60, 120, 80, 10, GlacierClient.INSTANCE.hudManager.coordinatesHud));
        this.modButtonsGUIMod.add(new ModButtonGUIMod(60, 140,80,10, GlacierClient.INSTANCE.hudManager.serverDisplay));
        this.modButtonsGUIMod.add(new ModButtonGUIMod(60, 160,80, 10, GlacierClient.INSTANCE.hudManager.memoryUsedMod));
        this.modButtonsGUIMod.add(new ModButtonGUIMod(150, 60, 80,10, GlacierClient.INSTANCE.hudManager.realTimeDisplay));
        this.modButtonsGUIMod.add(new ModButtonGUIMod(150, 80, 80,10, GlacierClient.INSTANCE.hudManager.keyStrokes));
        this.modButtonsGUIMod.add(new ModButtonGUIMod(150, 100, 80,10, GlacierClient.INSTANCE.hudManager.cps));

        this.modButtons.add(new ModButtonMod(240,60, 240,10, GlacierClient.INSTANCE.modManager.toggleSprint));
        this.modButtons.add(new ModButtonMod(240,80, 240,10, GlacierClient.INSTANCE.modManager.oneDotSevenAnimations));
        this.modButtons.add(new ModButtonMod(240,100, 240,10, GlacierClient.INSTANCE.modManager.motionBlur));
    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTick)
    {
        ScaledResolution sr = new ScaledResolution(mc);
        super.drawScreen(mouseX, mouseY, partialTick);

        Gui.drawRect(50, 50, sr.getScaledWidth() - 50, sr.getScaledHeight() - 50, new Color(0, 0, 0, 170).getRGB());

        for(ModButtonGUIMod m : modButtonsGUIMod)
        {
            m.draw();
        }
        for(ModButtonMod m : modButtons)
        {
            m.draw();
        }
        GlStateManager.color(255, 255, 255,255);
        mc.getTextureManager().bindTexture(new ResourceLocation("glacier/icon/exit.png"));
        Gui.drawModalRectWithCustomSizedTexture(sr.getScaledWidth() - 70, 55, 0, 0, 15,15,15,15);
        super.drawScreen(mouseX, mouseY, partialTick);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        super.mouseClicked(mouseX, mouseY, mouseButton);
        ScaledResolution sr = new ScaledResolution(mc);
        for(ModButtonGUIMod m :modButtonsGUIMod)
        {
            m.onClick(mouseX, mouseY, mouseButton);
        }
        for(ModButtonMod m :modButtons)
        {
            m.onClick(mouseX, mouseY, mouseButton);
        }
        if(mouseX >= sr.getScaledWidth() - 70 && mouseX <= sr.getScaledWidth() - 70 + 15 && mouseY >= 55 && mouseY <= 55 + 15)
        {
            //mc.getSoundHandler().playSound();
            mc.displayGuiScreen(new ClientSettings());
        }
    }


}
