package com.andbeyond.rain;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.ScreenUtils;

/** {@link com.badlogic.gdx.ApplicationListener} implementation shared by all platforms. */
public class Main extends ApplicationAdapter {
    private SpriteBatch batch;
    private Texture image;
    private ParticleEffect effect;
    private TextureAtlas particleAtlas; //<-load some atlas with your particle assets in




    @Override
    public void create() {
        batch = new SpriteBatch();
        image = new Texture("libgdx.png");
        effect= new ParticleEffect();
        particleAtlas = new TextureAtlas("particles.atlas"); //<-load some atlas with your particle assets in
        effect.load(Gdx.files.internal("draftrain.p"), particleAtlas);
        effect.setPosition(Gdx.graphics.getWidth() / 2f, Gdx.graphics.getHeight() / 2f);   
        effect.start();
        

    }

    @Override
    public void render() {
        ScreenUtils.clear(0.15f, 0.15f, 0.2f, 1f);
        batch.begin();
        batch.draw(image, 140, 210);
        
        effect.draw(batch, Gdx.graphics.getDeltaTime());
        batch.end();
    }

    @Override
    public void dispose() {
        batch.dispose();
        image.dispose();
        effect.dispose();
        particleAtlas.dispose();
    }
}




  
