package arpitparekh.verylateandroidbatch.retrofit_api_calling;

import com.google.gson.annotations.SerializedName;

public class Status{

	@SerializedName("feedback")
	private String feedback;

	@SerializedName("verified")
	private boolean verified;

	@SerializedName("sentCount")
	private int sentCount;

	public void setFeedback(String feedback){
		this.feedback = feedback;
	}

	public String getFeedback(){
		return feedback;
	}

	public void setVerified(boolean verified){
		this.verified = verified;
	}

	public boolean isVerified(){
		return verified;
	}

	public void setSentCount(int sentCount){
		this.sentCount = sentCount;
	}

	public int getSentCount(){
		return sentCount;
	}

	@Override
 	public String toString(){
		return 
			"Status{" + 
			"feedback = '" + feedback + '\'' + 
			",verified = '" + verified + '\'' + 
			",sentCount = '" + sentCount + '\'' + 
			"}";
		}
}