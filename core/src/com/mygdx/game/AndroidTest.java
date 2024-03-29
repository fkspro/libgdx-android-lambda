package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.utils.ObjectMap;

// test to see if lambdas can work on android like they should

public class AndroidTest extends ApplicationAdapter {
    SpriteBatch batch;
    Texture img;

    ObjectMap<String, String> testmap;
    boolean done;
	
    @Override
    public void create () {
	batch = new SpriteBatch();
	img = new Texture("badlogic.jpg");

	testmap = new ObjectMap<>();
	testmap.put("one", "first entry");
	testmap.put("two", "another entry");
	testmap.put("three", "the last entry");
	done = false;
    }

    @Override
    public void render () {
	Gdx.gl.glClearColor(1, 0, 0, 1);
	Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
	batch.begin();
	batch.draw(img, 0, 0);
	batch.end();

	if(!done) {
	    testmap.forEach(e -> Gdx.app.log("test", "element: " + e));
	    done = true;
	}
			    
    }
	
    @Override
    public void dispose () {
	batch.dispose();
	img.dispose();
    }
}

