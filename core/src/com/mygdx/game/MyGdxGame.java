package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture flowerAtlas;
	private Animation animation;
	private float timepassed=0;
//	private Texture img;
//	private Sprite sprite;//used to convert image
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		flowerAtlas = new Texture(Gdx.files.internal("flower.atlas"));
		animation = new Animation(1/3f, flowerAtlas.getRegions());
//		img = new Texture("circle.png");
//		sprite = new Sprite(img);//convert image in to sprite
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);//clear screen color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//		start batch to execute the code
		batch.begin();
		timepassed = Gdx.graphics.getDeltaTime();
		batch.draw((Texture) animation.getKeyFrame(timepassed, true), 100, 100);
//		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		//dispose resources
		batch.dispose();
		flowerAtlas.dispose();
//		img.dispose();
	}
}
