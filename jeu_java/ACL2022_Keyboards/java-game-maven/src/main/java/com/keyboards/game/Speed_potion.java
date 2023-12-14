package com.keyboards.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.keyboards.global.Global;
import com.keyboards.graphics.SpriteSheet;
import com.keyboards.sound.Sound;
import com.keyboards.tile.Tile;

public class Speed_potion extends Item {
	Sound drinkingSound;
	public Speed_potion(int col, int row, Tile[][] mapTiles, boolean isInInventory) {
		super(col, row, mapTiles, isInInventory);
		this.skillIncrease = 2;
	}
	
	public Speed_potion (Tile[][] mapTiles, float distance_min, Player p, boolean isInInventory) {
		super(mapTiles, distance_min, p, isInInventory);
		this.skillIncrease = 2;
	}
	public void playDrinkingSound() {
		drinkingSound.play();
	}
	public void use(Player p) {
		p.speed += this.skillIncrease;
		pl=p;
		utilise=1;
		System.out.println("used " + this.getClass().getSimpleName());
		playDrinkingSound();
	}

	public void initHitBox() {
		hitBoxCornersOffset = new Point(3,3);
		hitbox = new Rectangle(worldPosition.x-this.image.getHeight()/2, worldPosition.y-this.image.getWidth()/2,this.image.getHeight() - hitBoxCornersOffset.x,this.image.getWidth()- hitBoxCornersOffset.y);
	}

	public void initSolidBox() {
		solidBoxCornersOffset = new Point(3,3);
		solidBox = new Rectangle(worldPosition.x-this.image.getHeight()/2, worldPosition.y-this.image.getWidth()/2,this.image.getHeight() - hitBoxCornersOffset.x,this.image.getWidth()- hitBoxCornersOffset.y);
	}

	protected void initSprites() {
		SpriteSheet Sprite = new SpriteSheet("res/Objects/Speed-potion.png", 32, 32);

		sprite = Sprite.getSpriteArray();
		image = sprite[0].image;
		
		drinkingSound = new Sound("res/sound/drinkingSound.wav");
	}
	public void draw(Graphics2D g) {
		if ((utilise==1) & (temps>-1)) {
			temps -=1;
		}
		if (temps==0) {
			pl.sprintSpeed-=skillIncrease;
		}
	}
}