package arpitparekh.verylateandroidbatch.retrofit_api_calling_headers_parameter;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class Photo{

	@SerializedName("_type")
	private String type;

	@SerializedName("totalCount")
	private int totalCount;

	@SerializedName("value")
	private List<ValueItem> value;

	public void setType(String type){
		this.type = type;
	}

	public String getType(){
		return type;
	}

	public void setTotalCount(int totalCount){
		this.totalCount = totalCount;
	}

	public int getTotalCount(){
		return totalCount;
	}

	public void setValue(List<ValueItem> value){
		this.value = value;
	}

	public List<ValueItem> getValue(){
		return value;
	}

	@Override
 	public String toString(){
		return 
			"Photo{" + 
			"_type = '" + type + '\'' + 
			",totalCount = '" + totalCount + '\'' + 
			",value = '" + value + '\'' + 
			"}";
		}
}