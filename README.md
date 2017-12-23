# JSF Custom Tag for Toggling the Render of Child Elements  

This is a sample code project showing a custom JSF 2.0 tag that can decide whether to render its child elements in the XHTML page or not. This example can help you develop a solution of your own for using a custom JSF tag that controls the rendering of its children. 

This was developed as a spike whilst considering how JSF tags could be used where we want to enable or disable elements on a page, for example when implementing Feature Toggles. 

## The Code Example

The repo contains a very simple JSF web application with two pages and a backing bean, together with a custom tag class (CustomTag.java) that is the actual JSF Custom Tag. The web.xml and custom.taglib.xml contain the relevant changes to define the custom tag within the web application. 

The hello.xhtml page shows the usage of this example custom tag (see below) and all items within that tag will only be rendered if the showChildren property is set to enabled. 

<rh:customTag showChildren="enabled"></rh:customTag>

The actual implementation of the custom tag is in CustomTag.java where the CustomTag class extends from the UIComponentBase JSF class. In this simple example the tag reads a showChildren property to determine whether to display child elements however you'll probably want to change this logic to something more useful for your purposes. One example where this Tag would be useful is for Feature Toggling (via a framework like FF4J). Implement a check in this code to determine a toggle on/off position and then choose to render the elements under this tag or not. 

For a companion blog post for this code see https://richhewlett.com/2017/12/23/a-custom-jsf-tag-lib-for-toggling-child-elements/ 
