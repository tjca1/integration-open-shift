
package br.com.integration.open.shift.published;

import java.io.Serializable;

/**
 * @author Thiago Araujo
 *
 */
public class PagedObject implements Serializable {

	private static final long serialVersionUID = 2112691167340706144L;
	
	private Object item;
	private Integer pages;
	private Integer length;
	
	public Object getItem() {
		return item;
	}
	public void setItem(Object item) {
		this.item = item;
	}
	public Integer getPages() {
		return pages;
	}
	public void setPages(Integer pages) {
		this.pages = pages;
	}
	public Integer getLength() {
		return length;
	}
	public void setLength(Integer length) {
		this.length = length;
	}
	
}
