package net.glacierclient.mod.impl.cosmetics;

import net.glacierclient.GlacierClient;
import net.glacierclient.http.API;
import net.glacierclient.mod.management.ModNoGUI;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.util.ResourceLocation;

import java.io.IOException;

public class Capes extends ModNoGUI {

    public Capes() {
        super("Capes", "A mod that adds custom capes");
    }

    public static boolean capeEquiped(AbstractClientPlayer entitylivingbaseIn)
    {
            if (entitylivingbaseIn.getName().equals(Minecraft.getMinecraft().getSession().getUsername())) {
                return true;
            } else if (entitylivingbaseIn.getName().equals("SpyMiner")) {
                return true;
            } else return false;
    }
    public static ResourceLocation getCape(AbstractClientPlayer entitylivingbaseIn){

        return new ResourceLocation("glacier/capes/GlacierBackground.png");
    }

    @Override
    public void onEnable()
    {
        super.onEnable();
        System.out.println("Loading Capes");
        try{
            System.out.println(API.get("user/assets/equipedCape/txt/" + GlacierClient.INSTANCE.playerUUID).replaceAll("\"", ""));
        } catch (IOException e) {
        e.printStackTrace();
    }
    }
    @Override
    public void onDisable()
    {
        super.onDisable();
        System.out.println("Unloading Capes");
    }
}
