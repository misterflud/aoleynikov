package mySpringProperty164;

import java.beans.PropertyEditorSupport;

/**
 * Created by AOleynikov on 26.08.2018.
 */
public class NamePropertyEditor extends PropertyEditorSupport {
    @Override
    public void setAsText(String text) {
        String[] name = text.split("\\s");
        setValue(new Name(name[0], name[1]));
    }
}
