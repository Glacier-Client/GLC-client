package net.glacierclient.mod.ui.clientsettings;

import net.glacierclient.mod.ui.clientsettings.hudposconfig.HUDPosConfigWithExtra;
import net.glacierclient.mod.ui.clientsettings.modsettings.ModSettings;
import net.glacierclient.mod.ui.clientsettings.togglegui.ToggleGUI;
import net.minecraft.client.gui.*;

import java.io.IOException;

public class ClientSettings extends GuiScreen
{

    @Override
    public void initGui()
    {
        super.initGui();
        this.buttonList.add(new GuiButton(694200, ((int) (this.width / 2 - this.width * 0.35)), (int) (this.height / 2 - this.height * 0.3), 100, 20, "Toggle Enable"));
        this.buttonList.add(new GuiButton(694201, ((int) (this.width / 2 - this.width * 0.35) + 110), (int) (this.height / 2 - this.height * 0.3), 100, 20, "Mod Position"));
        this.buttonList.add(new GuiButton(694202, ((int) (this.width / 2 - this.width * 0.35) + 220), (int) (this.height / 2 - this.height * 0.3), 100, 20, "Mod Settings"));
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
        switch(button.id)
        {
            case 694200: mc.displayGuiScreen(new ToggleGUI()); break;
            case 694201: mc.displayGuiScreen(new HUDPosConfigWithExtra()); break;
            case 694202: mc.displayGuiScreen(new ModSettings()); break;
        }
    }

}
