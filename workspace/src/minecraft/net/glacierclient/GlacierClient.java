package net.glacierclient;

import com.mojang.authlib.GameProfile;
import net.glacierclient.event.EventManager;
import net.glacierclient.event.EventTarget;
import net.glacierclient.event.impl.ClientTick;
import net.glacierclient.http.API;
import net.glacierclient.mod.impl.util.DiscordRP;
import net.glacierclient.mod.ui.BanScreen;
import net.glacierclient.mod.ui.SplashProgress;
import net.glacierclient.mod.ui.clientsettings.ClientSettings;
import net.glacierclient.mod.ui.clientsettings.hudposconfig.HUDPosConfig;
import net.glacierclient.mod.management.HudManager;
import net.glacierclient.mod.management.ModManager;
import net.glacierclient.util.SessionChanger;
import net.minecraft.client.Minecraft;
import org.json.JSONObject;

import java.awt.*;
import java.io.IOException;


public class GlacierClient {
    public String NAME = "Glacier Client", VERSION = "1.0.3",VERSIONLong = VERSION + "/augustine", AUTHOR = "SpyMiner", NAMEVER = NAME + " " + VERSIONLong, WINDOWTITLE = "Glacier Client (" + VERSION + ") - 1.8.9",  playerUUID, playerName, banReason;
    public boolean isBanned;
    public static GlacierClient INSTANCE = new GlacierClient();
    public Minecraft mc = Minecraft.getMinecraft();
    public DiscordRP discordRP = new DiscordRP();
    public EventManager eventManager;
    public ModManager modManager;
    public HudManager hudManager;
    public JSONObject jsonObj;

    public void startup(){
        SplashProgress.setProggress(6, "Client - Discord RP");
        discordRP.start();
        SplashProgress.setProggress(7, "Client - Loading Mods");
        eventManager = new EventManager();
        modManager = new ModManager();
        hudManager = new HudManager();
        System.out.println("Starting " + NAMEVER + " by " + AUTHOR);

        SessionChanger.getInstance().setUserOffline("SpyMiner");

        playerUUID = API.get("user/playerUUID/txt/" + mc.getSession().getUsername()).replaceAll("\"", "");
        playerName = mc.getSession().getUsername();

        jsonObj = new JSONObject(API.get("user/isbanned/" + playerUUID));

        if(jsonObj.getInt("isBanned") == 1)
        {
            isBanned = true;
            banReason = jsonObj.getString("banReason");
        }

        eventManager.register(this);
    }


    public void shutdown(){
        System.out.println("Stopping " + NAMEVER + " by " + AUTHOR);
        discordRP.shutdown();
        //System.out.println(API.get("client/logout/" + playerUUID));

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
        if(isBanned)
        {
            mc.displayGuiScreen(new BanScreen(banReason));
        }

    }
}
