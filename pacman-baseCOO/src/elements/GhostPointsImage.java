package elements;

import java.awt.Graphics;
import java.io.Serializable;

import utils.Drawing;

public class GhostPointsImage extends Element implements Serializable{
	public GhostPointsImage(String imageName) {
		super(imageName);
		// TODO Auto-generated constructor stub
	}

	private long startTime=0;
	
	
	@Override
	public void autoDraw(Graphics g) {
		Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
		
	}

	public long getStartTime() {
		return this.startTime;
	}
	
	public void setStartTime(long start){
		this.startTime=start;
	}
}
