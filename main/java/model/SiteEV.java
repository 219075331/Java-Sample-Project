package model;

import java.io.Serializable;

public class SiteEV implements Serializable{
	
	private int like;
	private int dislike;
	
	public SiteEV() {
		int like = 0;
		int dislike = 0;
	}

	public int getLike() {
		return like;
	}

	public int getDislike() {
		return dislike;
	}

	public void setLike(int like) {
		this.like = like;
	}

	public void setDislike(int dislike) {
		this.dislike = dislike;
	}
	
	
	
	

}
