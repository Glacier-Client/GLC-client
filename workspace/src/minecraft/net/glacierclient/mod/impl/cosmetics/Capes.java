package net.glacierclient.mod.impl.cosmetics;

import net.glacierclient.mod.management.Category;
import net.glacierclient.mod.management.ModNoGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

public class Capes extends ModNoGUI {

    public Capes() {
        super("Capes", "A mod that adds custom capes", Category.COSMETIC);
    }

    public static boolean ownsCape(AbstractClientPlayer entitylivingbaseIn, int capeID)
    {
        if (entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) && capeID == 0) //entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername())
        {
            return true;
        }
        else if(entitylivingbaseIn.getName().equals("SpyMiner"))
        {
            return true;
        }
        else return false;
    }

    public static boolean ownsAndSelectedCape(AbstractClientPlayer entitylivingbaseIn, int capeID)
    {
        if (entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername()) && capeID == 0) //entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername())
        {
            return true;
        }
        else if(entitylivingbaseIn.getName().equals("SpyMiner") && capeID == 1)
        {
            return true;
        }
        else if(entitylivingbaseIn.getName().equals("oYugo") && capeID == 1)
        {
            return true;
        }
        else return false;
    }

    @Override
    public void onEnable()
    {
        super.onEnable();
        System.out.println("Loading Capes");
    }
    @Override
    public void onDisable()
    {
        super.onDisable();
        System.out.println("Unloading Capes");
    }
}
