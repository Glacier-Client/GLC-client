package net.glacierclient.mod.management;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import net.glacierclient.mod.ui.clientsettings.hudposconfig.comp.DraggableComponent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;

public class HudMod {

    private static final Gson gson = new Gson();
    public Minecraft mc = Minecraft.getMinecraft();
    public FontRenderer fr = mc.fontRendererObj;

    public String name;
    public boolean enabled;
    public DraggableComponent drag;

    public int x, y;

    public HudMod(String name, int x, int y, boolean forceNew) {
        this.name = name;
        this.x = x;
        this.y = y;

        loadHudMod(this.x, this.y, this.name, forceNew);
        //drag = new DraggableComponent(x, y, x + getWidth(), y + getHeight(), new Color(0, 0,0, 0).getRGB(), this.name);

    }

    public int getWidth() {
        return 50;
    }

    public int getHeight() {
        return 50;
    }

    public void draw() {

    }

    public void renderDummy(int mouseX, int mouseY) {
        drag.draw(mouseX, mouseY);
    }

    public int getX() {
        return drag.getxPosition();
    }

    public int getY() {
        return drag.getyPosition();
    }

    public void setEnabled(boolean enabled) {
        drag.enable = enabled;
        saveHudMod();
    }

    public void toggle() {
        this.setEnabled(!drag.enable);
    }

    public boolean isEnabled() {
        return drag.enable;
    }

    public void saveHudMod() {
        File file = new File("GlacierClientConfig/Mods/GUI/" + this.name + ".spyminerCONF");
        if (!file.exists()) {
            try {
                File directory = new File(file.getParent());
                if (!directory.exists()) {
                    directory.mkdirs();
                }
                file.createNewFile();
                System.out.println();
            } catch (IOException e) {
                System.out.println("failed to create file");
            }
        }
        try {
            FileWriter fileWriter;
            fileWriter = new FileWriter(file.getAbsoluteFile(), false);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(gson.toJson(drag));
            bufferedWriter.close();
        } catch (IOException e) {
            System.out.println("failed to save to file");
        }
    }

    public void loadHudMod(int xNew, int yNew, String nameNew, boolean forceNew) {

        if (!forceNew) {
            File file = new File("GlacierClientConfig/Mods/GUI/" + (String) this.name + ".spyminerCONF");
            if (!file.exists()) {
                drag = new DraggableComponent(xNew, yNew, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB(), nameNew, false);
            } else {
                InputStreamReader isReader;
                try {
                    isReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                    JsonReader myReader = new JsonReader(isReader);
                    drag = gson.fromJson(myReader, DraggableComponent.class);

                } catch (Exception e) {
                    System.out.println("failed to load file");
                }
            }
            saveHudMod();
        } else {
            File file = new File("GlacierClientConfig/Mods/GUI/" + (String) this.name + ".spyminerCONF");
            if (!file.exists()) {
                drag = new DraggableComponent(xNew, yNew, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB(), nameNew, false);
                saveHudMod();
            } else {
                InputStreamReader isReader;
                try {
                    isReader = new InputStreamReader(new FileInputStream(file), StandardCharsets.UTF_8);
                    JsonReader myReader = new JsonReader(isReader);
                    drag = new DraggableComponent(xNew, yNew, getWidth(), getHeight(), new Color(0, 0, 0, 0).getRGB(), nameNew, false);
                    saveHudMod();
                } catch (Exception e) {
                    System.out.println("failed to load file");
                }

            }
        }
    }
}
