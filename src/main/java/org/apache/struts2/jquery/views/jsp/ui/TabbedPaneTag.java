package org.apache.struts2.jquery.views.jsp.ui;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.jquery.components.Tab;
import org.apache.struts2.jquery.components.TabbedPane;

import com.opensymphony.xwork2.util.ValueStack;

public class TabbedPaneTag extends AbstractBaseTag {

	private static final long serialVersionUID = -3809304151441133723L;
	
	protected Boolean isCache;				//Whether or not to cache remote tabs content, e.g. load only once or with every click.
	protected Integer selected;				//The zero-based index of the tab that is selected when the pane first loads.
    
	public TabbedPaneTag() {
		super();
	}
	
	@Override
	public Component getBean(ValueStack stack, HttpServletRequest req, HttpServletResponse res) {
		Component bean = new TabbedPane(stack, req, res);
		return bean;
	}
	
	public void addTab(Tab tab){
		if(this.component != null) {
			((TabbedPane)component).addTab(tab);
		}
	}

	@Override
    protected void populateParams() {
        
		super.populateParams();

        TabbedPane tabbedPane = (TabbedPane) component;
        tabbedPane.setIsCache(isCache);
        tabbedPane.setSelected(selected);
        
    }

	public void setIsCache(Boolean isCache) {
		this.isCache = isCache;
	}

	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}
}
