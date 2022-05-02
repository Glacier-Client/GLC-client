package net.glacierclient.mod.management;

import net.glacierclient.GlacierClient;
import net.minecraft.client.Minecraft;

public class ModNoGUI
{

    public Minecraft mc = Minecraft.getMinecraft();
    public String name, description;
    public boolean enabled;


    public ModNoGUI(String name, String description)
    {
        this.name = name;
        this.description = description;

    }

    public void onEnable()
    {
        GlacierClient.INSTANCE.eventManager.register(this);
    }
    public void onDisable()
    {
        GlacierClient.INSTANCE.eventManager.unregister(this);
    }
    public void setEnable(boolean enabled)
    {
        this.enabled = enabled;
        if(enabled)
        {
            onEnable();
        }
        else
        {
            onDisable();
        }
    }
    public void toggle()
    {
        setEnable(!this.enabled);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

}
