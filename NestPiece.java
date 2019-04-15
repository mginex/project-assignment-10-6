//package birdyRun;


public class NestPiece extends Sprite { // nest pieces can be collected
	private int nestpieceImgHeight;
	private int nestpieceImgWidth;
	public int nestTot;
	
	NestPiece(){
		self = '|';
		nestTot = 5;
		int rand  = (int)Math.floor(Math.random()*3);
		if(rand == 0)
			lane =Lane.Top;
		else if(rand==1)
			lane = Lane.Mid;
		else
			lane=Lane.Bottom;
		xloc = (int)Math.floor(Math.random()*900)+100;
	}
	NestPiece(int x, int y) {
		xloc = x;
		yloc = y;
		
	}
	
	public int getXloc() { // getters and setters
		return xloc;
	}
	public void setXloc(int x) {
		xloc = x;
	}

	public int getYloc() {
		return yloc;
	}
	public void setYloc(int y) {
		yloc = y;
	}
	public int getImgWidth() {
		return nestpieceImgWidth;
	}
	public int getImgHeight() {
		return nestpieceImgHeight;
	}	
}