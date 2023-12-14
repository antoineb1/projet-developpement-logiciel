package com.keyboards.game;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;

import com.keyboards.global.Global;
import com.keyboards.graphics.SpriteSheet;
import com.keyboards.sound.Sound;
import com.keyboards.tile.Tile;

public class Life_potion extends Item {
	Sound drinkingSound;
	public Life_potion(int col, int row, Tile[][] mapTiles, boolean isInInventory) {
		super(col, row, mapTiles, isInInventory);
		this.skillIncrease = 2;
	}
	
	public Life_potion (Tile[][] mapTiles, float distance_min, Player p, boolean isInInventory) {
		super(mapTiles, distance_min, p, isInInventory);
		this.skillIncrease = 2;
	}
	public void playDrinkingSound() {
		drinkingSound.play();
	}

	public void use(Player p) {
		utilise=1;
		System.out.println("before health = " + p.health);
		if (p.health + this.skillIncrease <= p.maxHealth + p.bouclier) {
			p.health += this.skillIncrease;
		} else {
			p.health = p.maxHealth + p.bouclier;
			
		}
		System.out.println("after health = " + p.health);
		System.out.println("used " + this.getClass().getSimpleName());
		playDrinkingSound();
	}

	public void initHitBox() {
		hitBoxCornersOffset = new Point(3, 3);
		hitbox = new Rectangle(worldPosition.x-this.image.getHeight()/2, worldPosition.y-this.image.getWidth()/2,this.image.getHeight() - hitBoxCornersOffset.x,this.image.getWidth()- hitBoxCornersOffset.y);
	}

	public void initSolidBox() {
		solidBoxCornersOffset = new Point(3,3);
		solidBox = new Rectangle(worldPosition.x-this.image.getHeight()/2, worldPosition.y-this.image.getWidth()/2,this.image.getHeight() - hitBoxCornersOffset.x,this.image.getWidth()- hitBoxCornersOffset.y);
	}

	protected void initSprites() {
		SpriteSheet Sprite = new SpriteSheet("res/Objects/Life-potion.png", 32, 32);

		sprite = Sprite.getSpriteArray();
		image = sprite[0].image;
		
		drinkingSound = new Sound("res/sound/drinkingSound.wav");
	}
	public void draw(Graphics2D g) {
		
	}
}
