package net.glacierclient.mod.ui;

import net.glacierclient.GlacierClient;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;

public class GlacierMainMenu extends GuiScreen {

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks)
    {
        GL11.glColor4f(1, 1, 1, 1);
        mc.getTextureManager().bindTexture(new ResourceLocation("glacier/main_menu.png"));
        this.drawModalRectWithCustomSizedTexture(0, 0, 0, 0, this.width, this.height, this.width, this.height);
        Gui.drawRect(width-220, 0, width, this.height, new Color(0, 0, 0, 170).getRGB());

        GlStateManager.pushMatrix();
        GlStateManager.scale(2, 2, 1);
        this.drawString(mc.fontRendererObj, GlacierClient.INSTANCE.NAME,(width/2) - 85, 42, -1);
        GlStateManager.popMatrix();

        mc.fontRendererObj.drawStringWithShadow(GlacierClient.INSTANCE.VERSION, width - (mc.fontRendererObj.getStringWidth(GlacierClient.INSTANCE.VERSION) + 5), (height - mc.fontRendererObj.FONT_HEIGHT) - 5, -1);
        mc.getTextureManager().bindTexture(new ResourceLocation("glacier/logo.png"));
        this.drawModalRectWithCustomSizedTexture( width - 150, 2, 0, 0, 75, 75, 75, 75);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    @Override
    public void initGui()
    {
        this.buttonList.add(new GuiButton(1, width - 210, height - 110, "Singleplayer"));
        this.buttonList.add(new GuiButton(2, width - 210, height - 88, "Multiplayer"));
        this.buttonList.add(new GuiButton(3, width - 210, height - 66, "Options"));
        this.buttonList.add(new GuiButton(4, width - 210, height - 44, "Quit"));
        super.initGui();
    }
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        if(button.id == 1)
        {
            mc.displayGuiScreen(new GuiSelectWorld(this));
        }
        if(button.id == 2)
        {
            mc.displayGuiScreen(new GuiMultiplayer(this));
        }
        if(button.id == 3)
        {
            mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings));
        }
        if(button.id == 4)
        {
            mc.shutdown();
        }
        super.actionPerformed(button);
    }

}
