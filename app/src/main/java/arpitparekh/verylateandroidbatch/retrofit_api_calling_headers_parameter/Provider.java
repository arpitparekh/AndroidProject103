package arpitparekh.verylateandroidbatch.retrofit_api_calling_headers_parameter;

import com.google.gson.annotations.SerializedName;

public class Provider{

	@SerializedName("favIconBase64Encoding")
	private String favIconBase64Encoding;

	@SerializedName("favIcon")
	private String favIcon;

	@SerializedName("name")
	private String name;

	public void setFavIconBase64Encoding(String favIconBase64Encoding){
		this.favIconBase64Encoding = favIconBase64Encoding;
	}

	public String getFavIconBase64Encoding(){
		return favIconBase64Encoding;
	}

	public void setFavIcon(String favIcon){
		this.favIcon = favIcon;
	}

	public String getFavIcon(){
		return favIcon;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	@Override
 	public String toString(){
		return 
			"Provider{" + 
			"favIconBase64Encoding = '" + favIconBase64Encoding + '\'' + 
			",favIcon = '" + favIcon + '\'' + 
			",name = '" + name + '\'' + 
			"}";
		}
}