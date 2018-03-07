package chinly.models;

import java.util.Collection;

public class Widget {
	private int id;
	private String name;
	private int width;
	private int height;
	private String cssClass;
	private String cssStyle;
	private String text;
	private int order;
	private Page page;
	
	private Collection<YouTubeWidget> youTubeWidgets;
	public void addYouTubeWidget(YouTubeWidget youTubeWidget){
        this.youTubeWidgets.add(youTubeWidget);
    }
    public void removeYouTubeWidget(YouTubeWidget youTubeWidget){
        this.youTubeWidgets.remove(youTubeWidget);
    }
	
    private Collection<HeadingWidget> headingWidgets;
	public void addHeadingWidget(HeadingWidget headingWidget){
        this.headingWidgets.add(headingWidget);
    }
    public void removeHeadingWidget(HeadingWidget headingWidget){
        this.headingWidgets.remove(headingWidget);
    }
    
    private Collection<ImageWidget> imageWidgets;
	public void addImageWidget(ImageWidget imageWidget){
        this.imageWidgets.add(imageWidget);
    }
    public void removeImageWidget(ImageWidget imageWidget){
        this.imageWidgets.remove(imageWidget);
    }
    
    private Collection<HtmlWidget> htmlWidgets;
	public void addHtmlWidget(HtmlWidget htmlWidget){
        this.htmlWidgets.add(htmlWidget);
    }
    public void removeHtmlWidget(HtmlWidget htmlWidget){
        this.htmlWidgets.remove(htmlWidget);
    }
    
    public Widget() {
		super();
	}
    
	public Widget(int id, String name, String text, int order, int width, int height) {
		super();
		this.id = id;
		this.name = name;
		this.text = text;
		this.order = order;
		this.width = width;
		this.height = height;
	}
	
	public Widget(int id, String name, int width, int height, String cssClass, String cssStyle, String text, int order,
			Page page, Collection<YouTubeWidget> youTubeWidgets, Collection<HeadingWidget> headingWidgets,
			Collection<ImageWidget> imageWidgets, Collection<HtmlWidget> htmlWidgets) {
		super();
		this.id = id;
		this.name = name;
		this.width = width;
		this.height = height;
		this.cssClass = cssClass;
		this.cssStyle = cssStyle;
		this.text = text;
		this.order = order;
		this.page = page;
		this.youTubeWidgets = youTubeWidgets;
		this.headingWidgets = headingWidgets;
		this.imageWidgets = imageWidgets;
		this.htmlWidgets = htmlWidgets;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getHeight() {
		return height;
	}
	public void setHeight(int height) {
		this.height = height;
	}
	public String getCssClass() {
		return cssClass;
	}
	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}
	public String getCssStyle() {
		return cssStyle;
	}
	public void setCssStyle(String cssStyle) {
		this.cssStyle = cssStyle;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public Page getPage() {
		return page;
	}
	public void setPage(Page page) {
		this.page = page;
	}
	public Collection<YouTubeWidget> getYouTubeWidgets() {
		return youTubeWidgets;
	}
	public void setYouTubeWidgets(Collection<YouTubeWidget> youTubeWidgets) {
		this.youTubeWidgets = youTubeWidgets;
	}
	public Collection<HeadingWidget> getHeadingWidgets() {
		return headingWidgets;
	}
	public void setHeadingWidgets(Collection<HeadingWidget> headingWidgets) {
		this.headingWidgets = headingWidgets;
	}
	public Collection<ImageWidget> getImageWidgets() {
		return imageWidgets;
	}
	public void setImageWidgets(Collection<ImageWidget> imageWidgets) {
		this.imageWidgets = imageWidgets;
	}
	public Collection<HtmlWidget> getHtmlWidgets() {
		return htmlWidgets;
	}
	public void setHtmlWidgets(Collection<HtmlWidget> htmlWidgets) {
		this.htmlWidgets = htmlWidgets;
	}
    
}