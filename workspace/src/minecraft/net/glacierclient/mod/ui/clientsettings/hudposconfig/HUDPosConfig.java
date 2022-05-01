package net.glacierclient.mod.ui.clientsettings.hudposconfig;

import net.glacierclient.GlacierClient;
import net.glacierclient.mod.management.HudMod;
import net.minecraft.client.gui.GuiScreen;

public class HUDPosConfig extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        this.drawDefaultBackground();

        for(HudMod m : GlacierClient.INSTANCE.hudManager.hudMods)
        {
            if(m.isEnabled())
            {
                m.renderDummy(mouseX, mouseY);
            }
        }
    }
}
