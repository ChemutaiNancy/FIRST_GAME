package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MyGdxGame extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture img;
	private Sprite sprite;//used to convert image
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("circle.png");
		sprite = new Sprite(img);//convert image in to sprite
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);//clear screen color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

//		start batch to execute the code
		batch.begin();
		sprite.draw(batch);
		batch.end();
	}
	
	@Override
	public void dispose () {
		//dispose resources
		batch.dispose();
		img.dispose();
	}
}
