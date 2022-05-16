package net.glacierclient.mod.ui;

import net.glacierclient.GlacierClient;
import net.minecraft.client.gui.*;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

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

        mc.fontRendererObj.drawStringWithShadow(GlacierClient.INSTANCE.VERSIONLong, width - (mc.fontRendererObj.getStringWidth(GlacierClient.INSTANCE.VERSIONLong) + 5), (height - mc.fontRendererObj.FONT_HEIGHT) - 5, -1);
        mc.getTextureManager().bindTexture(new ResourceLocation("glacier/logo.png"));
        this.drawModalRectWithCustomSizedTexture( width - 150, 2, 0, 0, 75, 75, 75, 75);

        super.drawScreen(mouseX, mouseY, partialTicks);
    }
    @Override
    public void initGui()
    {
        this.buttonList.add(new GuiButton(1, width - 210, height - 131, 200, 20, "Singleplayer"));
        this.buttonList.add(new GuiButton(2, width - 210, height - 109, 200, 20, "Multiplayer"));
        this.buttonList.add(new GuiButton(3, width - 210, height - 87, 200, 20, "Options"));
        this.buttonList.add(new GuiButton(4, width - 210, height - 44, 200, 20, "Quit"));
        this.buttonList.add(new GuiButton(10, width - 210, height - 65, 99, 20, "Website"));
        this.buttonList.add(new GuiButton(11, width - 109, height - 65, 99, 20, "Discord"));
        super.initGui();
    }
    @Override
    protected void actionPerformed(GuiButton button) throws IOException
    {
        switch (button.id)
        {
            case 1: mc.displayGuiScreen(new GuiSelectWorld(this)); break;
            case 2: mc.displayGuiScreen(new GuiMultiplayer(this)); break;
            case 3: mc.displayGuiScreen(new GuiOptions(this, mc.gameSettings)); break;
            case 4: mc.shutdown(); break;
            case 10: try{ Desktop.getDesktop().browse(new URI("https://www.glacierclient.net"));} catch (IOException e) {e.printStackTrace();} catch (URISyntaxException e) {e.printStackTrace();} break;
            case 11: try{ Desktop.getDesktop().browse(new URI("https://www.glacierclient.net/discord"));} catch (IOException e) {e.printStackTrace();} catch (URISyntaxException e) {e.printStackTrace();} break;
        }

        super.actionPerformed(button);
    }

}
