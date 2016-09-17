package com.persen.beijing.propertyChangeSupport;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class PropertyBean {
    private PropertyChangeSupport propertyChangeSupport = new PropertyChangeSupport(
            this);

    public void addPropertyChangeListener(String propertyName,
                                          PropertyChangeListener listener) {
        propertyChangeSupport.addPropertyChangeListener(propertyName, listener);
    }

    public void removePropertyChangeListener(String propertyName,
                                             PropertyChangeListener listener) {
        propertyChangeSupport.removePropertyChangeListener(propertyName,
                listener);
    }

    public void notify(String propertyName) {
        propertyChangeSupport.firePropertyChange(propertyName, null, null);
    }
}
