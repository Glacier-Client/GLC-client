package net.glacierclient.mod.ui.clientsettings.hudposconfig;

import net.glacierclient.GlacierClient;
import net.glacierclient.mod.ui.clientsettings.ClientSettings;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class HUDPosConfigWithExtra extends HUDPosConfig
{
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        super.drawScreen(mouseX, mouseY, partialTicks);

        ScaledResolution sr = new ScaledResolution(mc);
        GlStateManager.color(255, 255, 255,255);
        mc.getTextureManager().bindTexture(new ResourceLocation("glacier/icon/exit.png"));
        Gui.drawModalRectWithCustomSizedTexture(sr.getScaledWidth() - 20, sr.getScaledHeight() - 20, 0, 0, 15,15,15,15);
        mc.getTextureManager().bindTexture(new ResourceLocation("glacier/icon/reload.png"));
        Gui.drawModalRectWithCustomSizedTexture(sr.getScaledWidth() - 40, sr.getScaledHeight() - 20, 0, 0, 15,15,15,15);
    }

    @Override
    public void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException
    {
        ScaledResolution sr = new ScaledResolution(mc);
        if(mouseX >= sr.getScaledWidth() - 20 && mouseX <= sr.getScaledWidth() - 20 + 15 && mouseY >= sr.getScaledHeight() - 20 && mouseY <= sr.getScaledHeight() - 20 + 15)
        {
            mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
            mc.displayGuiScreen(new ClientSettings());
        }
        if(mouseX >= sr.getScaledWidth() - 40 && mouseX <= sr.getScaledWidth() - 40 + 15 && mouseY >= sr.getScaledHeight() - 20 && mouseY <= sr.getScaledHeight() - 20 + 15)
        {
            mc.getSoundHandler().playSound(PositionedSoundRecord.create(new ResourceLocation("gui.button.press"), 1.0F));
            GlacierClient.INSTANCE.hudManager.unloadAllMods();
            GlacierClient.INSTANCE.hudManager.loadAllModsForceNew();
        }
    }
}
