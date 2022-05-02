package net.glacierclient.mod.impl.gui;

import java.awt.Color;
import net.glacierclient.mod.management.HudMod;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;


import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.settings.KeyBinding;

public class KeyStrokes extends HudMod {

    public KeyStrokes()
    {
        super("Keystrokes", 5, 110, false);
    }
    public KeyStrokes(boolean forceNew)
    {
        super("Keystrokes", 5, 110, forceNew);
    }

    public static enum KeystrokesMode {

		WASD(Key.W, Key.A, Key.S, Key.D),
		WASD_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB),
		WASD_JUMP(Key.W, Key.A, Key.S, Key.D, Key.Jump1),
		WASD_JUMP_MOUSE(Key.W, Key.A, Key.S, Key.D, Key.LMB, Key.RMB, Key.Jump2);

		private final Key[] keys;
		private int width = 0;
		private int height = 0;

		private KeystrokesMode(Key... keysIn) {
			this.keys = keysIn;

			for(Key key : keys) {
				this.width = Math.max(this.width, key.getX() + key.getWidth());
				this.height = Math.max(this.height, key.getY() + key.getHeight());
			}
		}

		public int getHeight() {
			return height;
		}

		public int getWidth() {
			return width;
		}

		public Key[] getKeys() {
			return keys;
		}

	}

	private static class Key {
		private static final Key W = new Key("W", Minecraft.getMinecraft().gameSettings.keyBindForward, 21, 1, 18, 18);
		private static final Key A = new Key("A", Minecraft.getMinecraft().gameSettings.keyBindLeft, 1, 21, 18, 18);
		private static final Key S = new Key("S", Minecraft.getMinecraft().gameSettings.keyBindBack, 21, 21, 18, 18);
		private static final Key D = new Key("D", Minecraft.getMinecraft().gameSettings.keyBindRight, 41, 21, 18, 18);

		private static final Key LMB = new Key("LMB", Minecraft.getMinecraft().gameSettings.keyBindAttack, 1, 41, 28, 18);
		private static final Key RMB = new Key("RMB", Minecraft.getMinecraft().gameSettings.keyBindUseItem, 31, 41, 28, 18);

		private static final Key Jump1 = new Key("----", Minecraft.getMinecraft().gameSettings.keyBindJump, 1, 41, 58, 18);
		private static final Key Jump2 = new Key("----", Minecraft.getMinecraft().gameSettings.keyBindJump, 1, 61, 58, 18);

		private final String name;
		private final KeyBinding keyBind;
		private final int x, y, w, h;

		public Key(String name, KeyBinding keyBind, int x, int y, int w, int h) {
			this.name = name;
			this.keyBind = keyBind;
			this.x = x;
			this.y = y;
			this.w = w;
			this.h = h;
		}

		public boolean isDown() {
			return keyBind.isKeyDown();
		}

		public int getHeight() {
			return h;
		}

		public String getName() {
			return name;
		}

		public int getWidth() {
			return w;
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

	}

	private KeystrokesMode mode = KeystrokesMode.WASD_JUMP_MOUSE;

	public void setMode(KeystrokesMode mode) {
		this.mode = mode;
	}

	@Override
	public int getWidth() {
		return 58;
	}

	@Override
	public int getHeight() {
		if (mode == KeystrokesMode.WASD)
		{
			return 39;
		}
		else if (mode == KeystrokesMode.WASD_MOUSE || mode == KeystrokesMode.WASD_JUMP)
		{
			return 60;
		}
		else
		{
			return 81;
		}
	}

    @Override
    public void draw()
    {
        GL11.glPushMatrix();
        for(Key key : mode.getKeys())
        {
            int textWidth = fr.getStringWidth(key.getName());

            Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getX() + key.getWidth(), getY() + key.getY() + key.getHeight(), key.isDown() ? new Color(255, 255, 255,102).getRGB() : new Color(0, 0, 0, 120).getRGB());

            fr.drawString(key.getName(), getX() + key.getX() + key.getWidth() / 2 - textWidth / 2, getY() + key.getY() + key.getHeight() / 2 - 3, key.isDown() ? new Color(0,0,0,255).getRGB() : -1);
        }
        GL11.glPopMatrix();
		super.draw();

	}
    @Override
    public void renderDummy(int mouseX, int mouseY)
    {
        GL11.glPushMatrix();
        for(Key key : mode.getKeys())
        {
            int textWidth = fr.getStringWidth(key.getName());

            Gui.drawRect(getX() + key.getX(), getY() + key.getY(), getX() + key.getX() + key.getWidth(), getY() + key.getY() + key.getHeight(), key.isDown() ? new Color(255, 255, 255,102).getRGB() : new Color(0, 0, 0, 120).getRGB());

            fr.drawString(key.getName(), getX() + key.getX() + key.getWidth() / 2 - textWidth / 2, getY() + key.getY() + key.getHeight() / 2 - 3, key.isDown() ? new Color(0,0,0,255).getRGB() : -1);
        }
        GL11.glPopMatrix();
		super.renderDummy(mouseX, mouseY);
    }
}