package net.mcreator.anniepantsmod.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.WidgetSprites;
import net.minecraft.client.gui.components.ImageButton;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.anniepantsmod.world.inventory.GSGuiMenu;
import net.mcreator.anniepantsmod.network.GSGuiButtonMessage;

import java.util.HashMap;

import com.mojang.blaze3d.systems.RenderSystem;

public class GSGuiScreen extends AbstractContainerScreen<GSGuiMenu> {
	private final static HashMap<String, Object> guistate = GSGuiMenu.guistate;
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private long cupPressedTime = 0;
	private long flavorPressedTime = 0;
	private static final long PRESS_DURATION = 200; // milliseconds
	ImageButton imagebutton_gs_button_cup;
	ImageButton imagebutton_gs_button_flavor;

	public GSGuiScreen(GSGuiMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 390;
		this.imageHeight = 190;
	}

	private static final ResourceLocation texture = ResourceLocation.parse("anniepantsmod:textures/screens/gs_gui1.png");

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(guiGraphics, mouseX, mouseY, partialTicks);
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int gx, int gy) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(texture, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		imagebutton_gs_button_cup = new ImageButton(this.leftPos + 45, this.topPos + 38, 128, 128,
				new WidgetSprites(ResourceLocation.parse("anniepantsmod:textures/screens/gs_button_cup.png"), ResourceLocation.parse("anniepantsmod:textures/screens/gs_button_cup_pressed.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GSGuiButtonMessage(0, x, y, z));
						GSGuiButtonMessage.handleButtonAction(entity, 0, x, y, z);
						cupPressedTime = System.currentTimeMillis();
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				boolean pressed = System.currentTimeMillis() - cupPressedTime < PRESS_DURATION;
				ResourceLocation tex = pressed
					? ResourceLocation.parse("anniepantsmod:textures/screens/gs_button_cup_pressed.png")
					: ResourceLocation.parse("anniepantsmod:textures/screens/gs_button_cup.png");
				guiGraphics.blit(tex, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_gs_button_cup", imagebutton_gs_button_cup);
		this.addRenderableWidget(imagebutton_gs_button_cup);

		imagebutton_gs_button_flavor = new ImageButton(this.leftPos + 218, this.topPos + 38, 128, 128,
				new WidgetSprites(ResourceLocation.parse("anniepantsmod:textures/screens/gs_button_flavor.png"), ResourceLocation.parse("anniepantsmod:textures/screens/gs_button_flavor_pressed.png")), e -> {
					if (true) {
						PacketDistributor.sendToServer(new GSGuiButtonMessage(1, x, y, z));
						GSGuiButtonMessage.handleButtonAction(entity, 1, x, y, z);
						flavorPressedTime = System.currentTimeMillis();
					}
				}) {
			@Override
			public void renderWidget(GuiGraphics guiGraphics, int x, int y, float partialTicks) {
				boolean pressed = System.currentTimeMillis() - flavorPressedTime < PRESS_DURATION;
				ResourceLocation tex = pressed
					? ResourceLocation.parse("anniepantsmod:textures/screens/gs_button_flavor_pressed.png")
					: ResourceLocation.parse("anniepantsmod:textures/screens/gs_button_flavor.png");
				guiGraphics.blit(tex, getX(), getY(), 0, 0, width, height, width, height);
			}
		};
		guistate.put("button:imagebutton_gs_button_flavor", imagebutton_gs_button_flavor);
		this.addRenderableWidget(imagebutton_gs_button_flavor);
	}
}
