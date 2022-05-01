package net.glacierclient.mod.management;

import net.glacierclient.GlacierClient;
import net.minecraft.client.Minecraft;

public class ModNoGUI
{

    public Minecraft mc = Minecraft.getMinecraft();
    public String name, description;
    public boolean enabled;
    public static boolean capeEnable;
    public Category category;

    public ModNoGUI(String name, String description, Category category )
    {
        this.name = name;
        this.description = description;
        this.category = category;
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
        this.capeEnable = enabled;
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
        return enabled;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Category getCategory() {
        return category;
    }
}
