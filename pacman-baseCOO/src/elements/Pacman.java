package elements;

import utils.Drawing;
import java.awt.Graphics;
import java.io.Serializable;


public class Pacman extends ElementMove implements Serializable  {
    
    private int score=0;
    private int remainingScore=0;
    private int numberLifes=1;
    private int numberDotstoEat=0;
    private int numberGhosttoEat=4;
    private long startTimePower=0;
    private long startTimeInvecibility = 0;
    private int ghostPointMultiplier = 2;
    
    public Pacman(String imageName) {
        super(imageName);
        this.isMortal = true;
        
    }
    
    
    public int getGhostPointMultiplier() {
    	return this.ghostPointMultiplier;
    }
    
    public void incrementGhostPointMultiplier() {
    	this.ghostPointMultiplier = ghostPointMultiplier * 2;
    }
    
    public void resetGhostPointMultiplier() {
    	this.ghostPointMultiplier = 2;
    }
    
    public int getScore(){
    	return this.score;
    }
    
    public int getRemainingScore(){
    	return this.remainingScore;
    }

	public int getLifes() {
		return this.numberLifes;
	}

	
	public int getNumberDotstoEat() {
		return this.numberDotstoEat;
	}
	
	public long getStartTimePower() {
		return this.startTimePower;
	}
	
	
	public void setStartTimePower(long start){
		this.startTimePower=start;
	}
	
	public long getStartTimeInvencibility() {
		return this.startTimePower;
	}
	
	
	public void setStartTimeInvencibility(long start){
		this.startTimePower=start;
	}
	
	public void setRemainingScore(int remainingScore){
		this.remainingScore=remainingScore;
	}
	
	public void setNumberLifes(int numberLifes){
		this.numberLifes=numberLifes;
	}
	
	public void addLife(){
		this.numberLifes++;
	}
	
	public void addNumberDotstoEat() {
		this.numberDotstoEat++;
	}
	public void minusNumberDotstoEat() {
		this.numberDotstoEat--;
	}
	public void minusNumberGhotstoEat() {
		this.numberGhosttoEat--;
	}
	
	public void addScore(int i) {
		score=score+i;
	}
	
	public void addRemainingScore(int i) {
		this.remainingScore=this.remainingScore+i;
	}
    
    @Override
    public void autoDraw(Graphics g){
        Drawing.draw(g, this.imageIcon, pos.getY(), pos.getX());
    }

	public int getNumberGhosttoEat() {
		return numberGhosttoEat;
	}
	
	/*Método feito para ajustar esse atributo quando 
	  o nível 4 for criado e evitar erros*/
	public void setNumberGhosttoEat5() {
		this.numberGhosttoEat = 5;
	}


}
