package com.persen.beijing.propertyChangeSupport;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

public class Main {

    public static void main(String[] args) {
        PropertyBean bean = new PropertyBean();
        PropertyListener listener = new PropertyListener();
        bean.addPropertyChangeListener("topic", listener);
        /*
		bean.addPropertyChangeListener("topic", new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				System.out.println("work");
			}
		});
		*/
        //bean.removePropertyChangeListener("topic", listener);
        bean.notify("topic");
    }

}
