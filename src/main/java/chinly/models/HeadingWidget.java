package chinly.models;

public class HeadingWidget {
	private int id;
	private int size;
	private Widget widget;
	
	public HeadingWidget() {
		super();
	}
	public HeadingWidget(int id, int size, Widget widget) {
		super();
		this.id = id;
		this.size = size;
		this.widget = widget;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Widget getWidget() {
		return widget;
	}
	public void setWidget(Widget widget) {
		this.widget = widget;
	}
	
	
}