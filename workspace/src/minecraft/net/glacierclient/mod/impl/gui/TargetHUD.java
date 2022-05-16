package net.glacierclient.mod.impl.gui;

import net.glacierclient.mod.management.HudMod;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItemFrame;

import java.awt.*;

public class TargetHUD extends HudMod {

    EntityLivingBase target = (EntityLivingBase) (mc.pointedEntity);

    public TargetHUD()
    {
        super("TargetHUD", 5, 90, false);
    }
    public TargetHUD(boolean forceNew)
    {
        super("TargetHUD", 5, 80, forceNew);
    }
    @Override
    public void draw()
    {
        renderTargetHud();
        super.draw();
    }

    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        fr.drawStringWithShadow(mc.thePlayer.getName(), getX() +2, getY() +2, -1);
        fr.drawStringWithShadow((int) (mc.thePlayer.getHealth())+ "§4 \u2764§r", getX() +2, getY() + 2 + fr.FONT_HEIGHT, -1);
        GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(mc.thePlayer.getName()) + 30, getY() + 25, 25, 50, 5, mc.thePlayer);

        super.renderDummy(mouseX, mouseY);
    }
    @Override
    public int getWidth()
    {
        return 100;
    }
    @Override
    public int getHeight()
    {
        return fr.FONT_HEIGHT * 2 + 4;
    }
    public void renderTargetHud() {
        if (!(mc.pointedEntity instanceof EntityItemFrame)) {
            target = (EntityLivingBase) (mc.pointedEntity);

            if (target != null) {
                Gui.drawRect(getX() - 3, getY() - (getHeight() + 5), getX() + fr.getStringWidth(target.getName()) + 45, getY() + getHeight() + 5, new Color(0, 0, 0, 75).getRGB());
                fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
                fr.drawStringWithShadow((int) (target.getHealth()) + "§4 \u2764§r", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
                GuiInventory.drawEntityOnScreen(getX() + fr.getStringWidth(target.getName()) + 30, getY() + 25, 25, 50, 5, target);
            }
        }
    }
}
