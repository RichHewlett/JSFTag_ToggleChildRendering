package com.test.common;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.component.UIInput;
import javax.faces.component.UINamingContainer;
import javax.faces.component.UIOutput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Map;

@FacesComponent(createTag = true, namespace = "http://RichCustomTag.com",
        tagName = "customTag", value = "com.test.common.CustomTag")
public class CustomTag extends UIComponentBase {

	 @Override
	  public String getFamily() {
	      return "com.test.common.CustomTag";
	  }

	  @Override
		public void encodeChildren(FacesContext arg0) throws IOException {
		  // If this tag has been asked to encode all its children then it means that the getRendersChildren function
		  // has decided that no children should be shown, so instead of doing any rendering we just return. The result
		  // will be no child elements being displayed. 
		  return;
		}
	  
	  @Override
		public boolean getRendersChildren() {
		  // In this function we need to determine whether any child elements should be shown or not (this can be any
		  // logic you find useful but for this example I am just reading a paramter on the XHTML). 
		  // If its determined that we DO want to display children then we will follow normal processing and pass the
		  // call onto the base class's getRendersChildren method. 
		  // If its determined we DO NOT want to display child elements we instead return TRUE which tells the JSF 
		  // framework that we want to render children ourselves using our lovely encodeChildren method above (which then
		  // ignores the request). 
		  		  
		  boolean enabled = false;
		  
		  // Replace this logic with whatever you need to determine whether to display children or not. 
		  String ruleName = (String) getAttributes().get("showChildren");
		  enabled = (ruleName.equalsIgnoreCase("enabled"));
		  
		  // Now set who will render the child elements (the framework or this component)
		  if(enabled)
		  {
			  // we want the children rendered so we tell JSF that we wont be doing it in this custom tag. 
			  return super.getRendersChildren();
		  }
		  else
		  {
			  // we will tell JSF that we will render the children, but then we'll not. 
			  return true;
		  }
		}
}
