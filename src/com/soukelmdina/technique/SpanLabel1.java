/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.soukelmdina.technique;

/**
 *
 * @author mosla
 */
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import static com.codename1.ui.Component.RIGHT;
import com.codename1.ui.Container;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Style;


public class SpanLabel1 extends Container {
    private Label icon;
    private TextArea text;
    private boolean shouldLocalize = true;
    
    /**
     * Default constructor will be useful when adding this to the GUI builder
     */
    public SpanLabel1() {
        this("");
    }
    
    /**
     * Constructor accepting default text and uiid for the text
     * @param txt the text
     * @param textUiid the new text UIID
     */
    public SpanLabel1(String txt, String textUiid) {
        this(txt);
        text.setUIID(textUiid);
    }
    
    /**
     * Constructor accepting default text
     */
    public SpanLabel1(String txt) {
        setUIID("Container");
        setLayout(new BorderLayout());
        text = new TextArea(getUIManager().localize(txt, txt));
        text.setActAsLabel(true);
        text.setColumns(text.getText().length() + 1);
        text.setUIID("RedLabel");
        text.setEditable(false);
        text.setFocusable(false);
        icon = new Label();
        icon.setUIID("icon");
        addComponent(BorderLayout.WEST, icon);
        addComponent(BorderLayout.CENTER, text);
    }
    
    /**
     * Returns the TextArea holding the actual text
     * @return the component
     */
    public TextArea getTextComponent() {
        return text;
    }
    
    /**
     * Sets the UIID for the actual text
     * @param uiid the uiid
     */
    public void setTextUIID(String uiid) {
        text.setUIID(uiid);
    }
    
    /**
     * Returns the uiid of the actual text
     * @return the uiid
     */
    public String getTextUIID() {
        return text.getUIID();
    }
    
    /**
     * Returns the Style proxy object for the text of this span button.
     * @return The Style object for the text of this span button.
     */
    public Style getTextAllStyles() {
        return text.getAllStyles();
    }
    
    /**
     * Returns the text elements style object
     * @return the style object
     */
    public Style getTextUnselectedStyle() {
        return text.getUnselectedStyle();
    }
    
    /**
     * The text elements style object
     * @param t the style object
     */
    public void setTextUnselectedStyle(Style t) {
        text.setUnselectedStyle(t);
    }
    
    /**
     * Returns the text elements style object
     * @return the style object
     */
    public Style getTextSelectedStyle() {
        return text.getSelectedStyle();
    }
    
    /**
     * The text elements style object
     * @param t the style object
     */
    public void setTextSelectedStyle(Style t) {
        text.setSelectedStyle(t);
    }
    
    /**
     * Sets the uiid for the icon if present
     * @param uiid the uiid for the icon
     */
    public void setIconUIID(String uiid) {
        icon.setUIID(uiid);
    }
    
    /**
     * Returns the UIID for the icon
     * @return the uiid
     */
    public String getIconUIID() {
        return icon.getUIID();
    }
    
    /**
     * Set the text of the label
     * @param t text of the label
     */
    public void setText(String t) {
        if(shouldLocalize) {
            text.setText(getUIManager().localize(t, t));
        } else {
            text.setText(t);
        }
    }

    /**
     * Sets the icon for the label
     * @param i the icon
     */
    public void setIcon(Image i) {
        icon.setIcon(i);
    }
    
    /**
     * Returns the text of the label
     * @return the text
     */
    public String getText() {
        return text.getText();
    }
    
    /**
     * Indicates the alignment of the whole text block, this is different from setting the alignment of the text within
     * the block since the UIID might have a border or other design element that won't be affected by such alignment.
     * The default is none (-1) which means no alignment takes place and the text block takes the whole width.
     * @param align valid values are Component.LEFT, Component.RIGHT, Component.CENTER. Anything else will
     * stretch the text block
     */
    public void setTextBlockAlign(int align) {
        switch(align) {
            case LEFT:
            case RIGHT:
            case CENTER:
                wrapText(align);
                return;
            default:
                if(text.getParent() != this) {
                    removeComponent(text.getParent());
                    text.getParent().removeAll();
                    addComponent(BorderLayout.CENTER, text);
                }
        }
    }
    
    /**
     * Returns the alignment of the whole text block and not the text within it!
     * 
     * @return -1 for unaligned otherwise one of Component.LEFT/RIGHT/CENTER
     */
    public int getTextBlockAlign() {
        if(text.getParent() == this) {
            return -1;
        }
        return ((FlowLayout)text.getParent().getLayout()).getAlign();
    }
    
    private void wrapText(int alignment) {
        Container parent = text.getParent();
        if(parent == this) {
            parent.removeComponent(text);
            parent = new Container(new FlowLayout(alignment));
            parent.addComponent(text);
            addComponent(BorderLayout.CENTER, parent);
        } else {
            ((FlowLayout)parent.getLayout()).setAlign(alignment);
        }
    }
    
    /**
     * Returns the image of the icon
     * @return the icon
     */
    public Image getIcon() {
        return icon.getIcon();
    }
    
    /**
     * Sets the icon position based on border layout constraints
     * 
     * @param t position either North/South/East/West
     */
    public void setIconPosition(String t) {
        removeComponent(icon);
        addComponent(t, icon);
        revalidate();
    }
    
    /**
     * Returns the icon position based on border layout constraints
     * 
     * @return position either North/South/East/West
     */
    public String getIconPosition() {
        return (String)getLayout().getComponentConstraint(icon);
    }
    

    /**
     * {@inheritDoc}
     */
    public String[] getPropertyNames() {
        return new String[] {
            "text", "icon", "iconPosition", "textUiid", "iconUiid"
        };
    }

    /**
     * {@inheritDoc}
     */
    public Class[] getPropertyTypes() {
       return new Class[] {
           String.class, // text
           Image.class, // icon
           String.class, // iconPosition
           String.class,
           String.class
       };
    }

    /**
     * {@inheritDoc}
     */
    public String[] getPropertyTypeNames() {
        return new String[] {"String", "Image", "String", "String", "String"};
    }

    /**
     * {@inheritDoc}
     */
    public Object getPropertyValue(String name) {
        if(name.equals("text")) {
            return getText();
        }
        if(name.equals("icon")) {
            return getIcon();
        }
        if(name.equals("iconPosition")) {
            return getIconPosition();
        }
        if(name.equals("textUiid")) {
            return getTextUIID();
        }
        if(name.equals("iconUiid")) {
            return getIconUIID();
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    public String setPropertyValue(String name, Object value) {
        if(name.equals("text")) {
            setText((String)value);
            return null;
        }
        if(name.equals("icon")) {
            setIcon((Image)value);
            return null;
        }
        if(name.equals("iconPosition")) {
            setIconPosition((String)value);
            return null;
        }
        if(name.equals("textUiid")) {
            setTextUIID((String)value);
            return null;
        }
        if(name.equals("iconUiid")) {
            setIconUIID((String)value);
            return null;
        }
        return super.setPropertyValue(name, value);
    }

    /**
     * Indicates if text should be localized when set to the component, by default
     * all text is localized so this allows disabling automatic localization for 
     * a specific component.
     * @return the shouldLocalize value
     */
    public boolean isShouldLocalize() {
        return shouldLocalize;
    }

    /**
     * Indicates if text should be localized when set to the component, by default
     * all text is localized so this allows disabling automatic localization for 
     * a specific component.
     * @param shouldLocalize the shouldLocalize to set
     */
    public void setShouldLocalize(boolean shouldLocalize) {
        this.shouldLocalize = shouldLocalize;
    }
}