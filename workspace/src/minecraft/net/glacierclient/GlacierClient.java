package net.glacierclient;

import com.mojang.authlib.GameProfile;
import net.glacierclient.event.EventManager;
import net.glacierclient.event.EventTarget;
import net.glacierclient.event.impl.ClientTick;
import net.glacierclient.http.API;
import net.glacierclient.mod.impl.util.DiscordRP;
import net.glacierclient.mod.ui.SplashProgress;
import net.glacierclient.mod.ui.clientsettings.ClientSettings;
import net.glacierclient.mod.ui.clientsettings.hudposconfig.HUDPosConfig;
import net.glacierclient.mod.management.HudManager;
import net.glacierclient.mod.management.ModManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;

import java.awt.*;
import java.io.IOException;

public class GlacierClient {
    public String NAME = "Glacier Client", VERSION = "1.0.3/augustine", AUTHOR = "SpyMiner", NAMEVER = NAME + " " + VERSION;
    public static GlacierClient INSTANCE = new GlacierClient();
    public Minecraft mc = Minecraft.getMinecraft();
    public DiscordRP discordRP = new DiscordRP();
    public EventManager eventManager;
    public ModManager modManager;
    public HudManager hudManager;

    public void startup() throws IOException {
        SplashProgress.setProggress(6, "Client - Discord RP");
        discordRP.start();
        SplashProgress.setProggress(7, "Client - Loading Mods");
        eventManager = new EventManager();
        modManager = new ModManager();
        hudManager = new HudManager();
        System.out.println("Starting " + NAMEVER + " by " + AUTHOR);
        //API.get("user/isbanned/" + "8288a11447b84f5a83d7aefe66c46a47"));

        eventManager.register(this);
    }


    public void shutdown() throws IOException {
        System.out.println("Stopping " + NAMEVER + " by " + AUTHOR);
        discordRP.shutdown();
        //System.out.println(API.get("client/logout/" + mc.getSession().getProfile().getId().toString()));

        hudManager.saveAllMods();


        eventManager.unregister(this);
    }

    @EventTarget
    public void onTick(ClientTick event) throws IOException {
        if(mc.gameSettings.HUD_CONFIG.isPressed())
        {
            mc.displayGuiScreen(new HUDPosConfig());
        }
        if(mc.gameSettings.CLIENT_SETTINGS.isPressed())
        {
            mc.displayGuiScreen(new ClientSettings());
        }

    }
}
