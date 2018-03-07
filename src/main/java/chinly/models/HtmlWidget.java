package chinly.models;


import chinly.models.Widget;

public class HtmlWidget extends Widget{
	private int id;
	private String html;
	private Widget widget;
	public HtmlWidget(int id, String html) {
		super();
		this.id = id;
		this.html = html;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getHtml() {
		return html;
	}
	public void setHtml(String html) {
		this.html = html;
	}
	public Widget getWidget() {
		return widget;
	}
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	

}
