package arpitparekh.verylateandroidbatch.retrofit_api_calling_headers_parameter;

import com.google.gson.annotations.SerializedName;

public class ValueItem{

	@SerializedName("base64Encoding")
	private Object base64Encoding;

	@SerializedName("imageWebSearchUrl")
	private String imageWebSearchUrl;

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("provider")
	private Provider provider;

	@SerializedName("width")
	private int width;

	@SerializedName("name")
	private String name;

	@SerializedName("thumbnailWidth")
	private int thumbnailWidth;

	@SerializedName("title")
	private String title;

	@SerializedName("thumbnailHeight")
	private int thumbnailHeight;

	@SerializedName("webpageUrl")
	private String webpageUrl;

	@SerializedName("url")
	private String url;

	@SerializedName("height")
	private int height;

	public void setBase64Encoding(Object base64Encoding){
		this.base64Encoding = base64Encoding;
	}

	public Object getBase64Encoding(){
		return base64Encoding;
	}

	public void setImageWebSearchUrl(String imageWebSearchUrl){
		this.imageWebSearchUrl = imageWebSearchUrl;
	}

	public String getImageWebSearchUrl(){
		return imageWebSearchUrl;
	}

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setProvider(Provider provider){
		this.provider = provider;
	}

	public Provider getProvider(){
		return provider;
	}

	public void setWidth(int width){
		this.width = width;
	}

	public int getWidth(){
		return width;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setThumbnailWidth(int thumbnailWidth){
		this.thumbnailWidth = thumbnailWidth;
	}

	public int getThumbnailWidth(){
		return thumbnailWidth;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	public void setThumbnailHeight(int thumbnailHeight){
		this.thumbnailHeight = thumbnailHeight;
	}

	public int getThumbnailHeight(){
		return thumbnailHeight;
	}

	public void setWebpageUrl(String webpageUrl){
		this.webpageUrl = webpageUrl;
	}

	public String getWebpageUrl(){
		return webpageUrl;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}

	public void setHeight(int height){
		this.height = height;
	}

	public int getHeight(){
		return height;
	}

	@Override
 	public String toString(){

		return url;

		}
}