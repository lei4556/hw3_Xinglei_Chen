package chinly.models;

import chinly.models.Widget;

public class ImageWidget extends Widget{
	private int id;
	private String src;
	private Widget widget;
	public ImageWidget() {
		super();
	}
	public ImageWidget(int id, String src, Widget widget) {
		super();
		this.id = id;
		this.src = src;
		this.widget = widget;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public Widget getWidget() {
		return widget;
	}
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	
}