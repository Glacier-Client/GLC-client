package net.glacierclient.mod.ui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;
import sun.java2d.opengl.OGLSurfaceData;

import java.awt.*;

public class SplashProgress {
    private static final int MAX = 7;
    private static int PROGGRESS = 0;
    private static String CURRENT = "";
    private static ResourceLocation splash;
    private static UnicodeFontRenderer ufr;

    public static void update()
    {
        if (Minecraft.getMinecraft() == null || Minecraft.getMinecraft().getLanguageManager() == null)
        {
            return;
        }
        drawSplash(Minecraft.getMinecraft().getTextureManager());
    }

    public static void setProggress(int givenProgress, String givenText)
    {
        PROGGRESS = givenProgress;
        CURRENT = givenText;
        update();
    }

    public static void drawSplash(TextureManager tm)
    {
        ScaledResolution scaledResolution = new ScaledResolution(Minecraft.getMinecraft());
        int scaleFactor = scaledResolution.getScaleFactor();

        Framebuffer framebuffer = new Framebuffer(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor, true);
        framebuffer.bindFramebuffer(false);

        GlStateManager.matrixMode(GL11.GL_PROJECTION);
        GlStateManager.loadIdentity();
        GlStateManager.ortho(0.0D, (double) (scaledResolution.getScaledWidth()), (double) (scaledResolution.getScaledHeight()), 0.0D, 1000.0D,3000.0D);
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);
        GlStateManager.loadIdentity();
        GlStateManager.translate(0.0F, 0.0F, -2000);
        GlStateManager.disableLighting();
        GlStateManager.disableFog();
        GlStateManager.disableDepth();
        GlStateManager.enableTexture2D();

        if(splash == null)
        {
            splash = new ResourceLocation("glacier/splash.png");
        }

        tm.bindTexture(splash);
        GlStateManager.resetColor();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

        Gui.drawModalRectWithCustomSizedTexture(0,0,0,0,scaledResolution.getScaledWidth(),scaledResolution.getScaledHeight(),scaledResolution.getScaledWidth(), scaledResolution.getScaledHeight());
        drawProgress();
        framebuffer.unbindFramebuffer();
        framebuffer.framebufferRender(scaledResolution.getScaledWidth() * scaleFactor, scaledResolution.getScaledHeight() * scaleFactor);

        GlStateManager.enableAlpha();
        GlStateManager.alphaFunc(516, 0.1F);

        Minecraft.getMinecraft().updateDisplay();
    }

    public static void drawProgress()
    {
        if(Minecraft.getMinecraft().gameSettings == null || Minecraft.getMinecraft().getTextureManager() == null)
        {
            return;
        }
        if(ufr == null)
        {
            ufr = UnicodeFontRenderer.getFontFromAssets("glacier/font/font.ttf", 20);
        }

        ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
        double nProgress = (double) (PROGGRESS);
        double calc = (nProgress / MAX * sr.getScaledWidth());

        Gui.drawRect(0, sr.getScaledHeight() - 35, sr.getScaledWidth(), sr.getScaledHeight(), new Color(0, 0, 0, 170).getRGB());

        GlStateManager.resetColor();
        resetTextureState();

        ufr.drawString(CURRENT, 20, sr.getScaledHeight() - 25, 0xFFFFFFFF);

        String step =PROGGRESS + "/" + MAX;
        ufr.drawString(step, sr.getScaledWidth() - 20 -ufr.getStringWidth(step), sr.getScaledHeight() - 25, 0xe1e1e1FF);

        GlStateManager.resetColor();
        resetTextureState();

        Gui.drawRect(0,sr.getScaledHeight() - 2, (int) (calc), sr.getScaledHeight(), new Color(0, 255, 255).getRGB());
        Gui.drawRect(0, sr.getScaledHeight() - 2, sr.getScaledWidth(), sr.getScaledHeight(), new Color(0,0, 0, 25).getRGB());
    }

    public static void resetTextureState()
    {
        GlStateManager.textureState[GlStateManager.activeTextureUnit].textureName = -1;
    }
}
