package com.aerodash.monolith.core.shapes;

import com.aerodash.monolith.core.Tile;
import com.aerodash.monolith.core.shapes.TetrisShape.Type;
import com.aerodash.monolith.main.Monolith;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.MathUtils;

public class LShape extends TetrisShape{

	/*	  1              2
	 *  #####          #####
	 *  #   #          #   #
	 *  #   #          #   #
	 *  #####          #####
	 *  #   #          #   #
	 *  #	#          #   #
	 *  #########  #########
	 *  #	#	#  #   #   #
	 *  # X #	#  #   # X # Coordinate of the shape relative to that tile
	 *  #########  #########
	 */
	public InitialState state;
	private RotationState rot = RotationState.INITIAL;
	
	public LShape(float x, float y, Color color) {
		super(x, y, color, null);
		
		state = InitialState.values()[MathUtils.random(1)];
		typeState = new TypeState(state, Type.L);
		
		if (state == InitialState.ONE){
			tiles.add(new Tile(x, y, color, this));
			tiles.add(new Tile(x + 1, y, color, this));
			tiles.add(new Tile(x, y + 1, color, this));
			tiles.add(new Tile(x, y + 2, color, this));
		}else{
			tiles.add(new Tile(x, y, color, this));
			tiles.add(new Tile(x - 1, y, color, this));
			tiles.add(new Tile(x, y + 1, color, this));
			tiles.add(new Tile(x, y + 2, color, this));
		}
	}
	
	public LShape(float x, float y, Color color, float tileSize, InitialState state){
		super(x, y, color, null);
		
		this.state = state;
		typeState = new TypeState(InitialState.ONE, Type.L);
		
		if (state == InitialState.ONE){
			tiles.add(new Tile(x, y, color, this));
			tiles.add(new Tile(x + 1 * tileSize, y, color, this));
			tiles.add(new Tile(x, y + 1 * tileSize, color, this));
			tiles.add(new Tile(x, y + 2 * tileSize, color, this));
		}else{
			tiles.add(new Tile(x, y, color, this));
			tiles.add(new Tile(x - 1 * tileSize, y, color, this));
			tiles.add(new Tile(x, y + 1 * tileSize, color, this));
			tiles.add(new Tile(x, y + 2 * tileSize, color, this));
		}
	}
	
	public LShape(float x, float y, Color color, float tileSize) {
		super(x, y, color, null);
		
		state = InitialState.values()[MathUtils.random(1)];
		typeState = new TypeState(InitialState.ONE, Type.L);
		
		if (state == InitialState.ONE){
			tiles.add(new Tile(x, y, color, this));
			tiles.add(new Tile(x + 1 * tileSize, y, color, this));
			tiles.add(new Tile(x, y + 1 * tileSize, color, this));
			tiles.add(new Tile(x, y + 2 * tileSize, color, this));
		}else{
			tiles.add(new Tile(x, y, color, this));
			tiles.add(new Tile(x - 1 * tileSize, y, color, this));
			tiles.add(new Tile(x, y + 1 * tileSize, color, this));
			tiles.add(new Tile(x, y + 2 * tileSize, color, this));
		}
	}

	@Override
	public void rotate() {
		float x = tiles.get(0).getGridX();
		float y = tiles.get(0).getGridY();
		if (state == InitialState.ONE){
			
			switch(rot){
			case INITIAL:
				tiles.get(1).setPos(x, y - 1);
				tiles.get(2).setPos(x + 1, y);
				tiles.get(3).setPos(x + 2, y);
				
				rot = RotationState.NINTY;
				break;
			case NINTY:
				tiles.get(1).setPos(x - 1, y);
				tiles.get(2).setPos(x, y - 1);
				tiles.get(3).setPos(x, y - 2);
				
				rot = RotationState.ONEEIGHTY;
				break;
			case ONEEIGHTY:
				tiles.get(1).setPos(x, y + 1);
				tiles.get(2).setPos(x - 1, y);
				tiles.get(3).setPos(x - 2, y);
				
				rot = RotationState.TWOSEVENTY;
				break;
			case TWOSEVENTY:
				tiles.get(1).setPos(x + 1, y);
				tiles.get(2).setPos(x, y + 1);
				tiles.get(3).setPos(x, y + 2);
				
				rot = RotationState.INITIAL;
				break;
			}
			
			
		}else{//TWO
			
			switch(rot){
			case INITIAL:
				tiles.get(1).setPos(x, y + 1);
				tiles.get(2).setPos(x + 1, y);
				tiles.get(3).setPos(x + 2, y);
				
				rot = RotationState.NINTY;
				break;
			case NINTY:
				tiles.get(1).setPos(x + 1, y);
				tiles.get(2).setPos(x, y - 1);
				tiles.get(3).setPos(x, y - 2);
				
				rot = RotationState.ONEEIGHTY;
				break;
			case ONEEIGHTY:
				tiles.get(1).setPos(x, y - 1);
				tiles.get(2).setPos(x - 1, y);
				tiles.get(3).setPos(x - 2, y);
				
				rot = RotationState.TWOSEVENTY;
				break;
			case TWOSEVENTY:
				tiles.get(1).setPos(x - 1, y);
				tiles.get(2).setPos(x, y + 1);
				tiles.get(3).setPos(x, y + 2);
				
				rot = RotationState.INITIAL;
				break;
			}
			
		}
		
	}
	
}
