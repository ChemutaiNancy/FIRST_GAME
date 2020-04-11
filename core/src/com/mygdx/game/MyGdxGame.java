package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.input.GestureDetector;
import com.badlogic.gdx.math.Vector2;

public class MyGdxGame extends ApplicationAdapter implements GestureDetector.GestureListener {
	private SpriteBatch batch;
	private OrthographicCamera orthographicCamera;
	private Texture texture;
	private Sprite sprite;
//	private Texture flowerAtlas;
//	private Animation animation;
//	private float timepassed=0;
//	private Texture img;
//	private Sprite sprite;//used to convert image
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		orthographicCamera = new OrthographicCamera(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		texture = new Texture(Gdx.files.internal("peach.jpg"));
		sprite = new Sprite(texture);

		sprite.setPosition(-sprite.getWidth()/2, -sprite.getHeight()/2);
		Gdx.input.setInputProcessor(new GestureDetector(this));
//		flowerAtlas = new Texture(Gdx.files.internal("flower.atlas"));
//		animation = new Animation(1/3f, flowerAtlas.getRegions());
//		img = new Texture("circle.png");
//		sprite = new Sprite(img);//convert image in to sprite
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);//clear screen color
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(orthographicCamera.combined);

//		start batch to execute the code
		batch.begin();
		sprite.draw(batch);
//		timepassed = Gdx.graphics.getDeltaTime();
//		batch.draw((Texture) animation.getKeyFrame(timepassed, true), 100, 100);
//		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		//dispose resources
		batch.dispose();
		texture.dispose();
//		flowerAtlas.dispose();
//		img.dispose();
	}

	@Override
	public boolean pan(float x, float y, float deltaX, float deltaY) {
		orthographicCamera.translate(-deltaX, deltaY);
		orthographicCamera.update();
		return false;
	}

	@Override
	public boolean touchDown(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean tap(float x, float y, int count, int button) {
		return false;
	}

	@Override
	public boolean longPress(float x, float y) {
		return false;
	}

	@Override
	public boolean fling(float velocityX, float velocityY, int button) {
		return false;
	}

	@Override
	public boolean panStop(float x, float y, int pointer, int button) {
		return false;
	}

	@Override
	public boolean zoom(float initialDistance, float distance) {
		return false;
	}

	@Override
	public boolean pinch(Vector2 initialPointer1, Vector2 initialPointer2, Vector2 pointer1, Vector2 pointer2) {
		return false;
	}

	@Override
	public void pinchStop() {

	}
}
