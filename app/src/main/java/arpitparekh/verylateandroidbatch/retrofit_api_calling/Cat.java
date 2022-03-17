package arpitparekh.verylateandroidbatch.retrofit_api_calling;

import com.google.gson.annotations.SerializedName;

public class Cat{

	@SerializedName("createdAt")
	private String createdAt;

	@SerializedName("deleted")
	private boolean deleted;

	@SerializedName("__v")
	private int V;

	@SerializedName("_id")
	private String id;

	@SerializedName("text")
	private String text;

	@SerializedName("source")
	private String source;

	@SerializedName("used")
	private boolean used;

	@SerializedName("type")
	private String type;

	@SerializedName("user")
	private String user;

	@SerializedName("status")
	private Status status;

	@SerializedName("updatedAt")
	private String updatedAt;

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setDeleted(boolean deleted){
		this.deleted = deleted;
	}

	public boolean isDeleted(){
		return deleted;
	}

	public void setV(int V){
		this.V = V;
	}

	public int getV(){
		return V;
	}

	public void setId(String id){
		this.id = id;
	}

	public String getId(){
		return id;
	}

	public void setText(String text){
		this.text = text;
	}

	public String getText(){
		return text;
	}

	public void setSource(String source){
		this.source = source;
	}

	public String getSource(){
		return source;
	}

	public void setUsed(boolean used){
		this.used = used;
	}

	public boolean isUsed(){
		return used;
	}

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setUser(String user){
		this.user = user;
	}

	public String getUser(){
		return user;
	}

	public void setStatus(Status status){
		this.status = status;
	}

	public Status getStatus(){
		return status;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	@Override
 	public String toString(){
		return text;

		}
}