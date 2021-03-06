//#preprocess

/* *************************************************
 * Copyright (c) 2010 - 2011
 * HT srl,   All rights reserved.
 * 
 * Project      : RCS, RCSBlackBerry
 * *************************************************/
	
package blackberry.interfaces;


import java.util.Vector;

import blackberry.debug.Debug;
import blackberry.debug.DebugLevel;


public abstract class Listener {

    //#ifdef DEBUG
    static Debug debug = new Debug("Listener", DebugLevel.INFORMATION);
    //#endif

    /**
     * Adds the observer.
     * 
     * @param observers
     *            Vector of observers
     * @param observer
     *            the observer
     */
    public synchronized static void addObserver(final Vector observers,
            final Observer observer) {

        //#ifdef DBC
        Check.requires(!observers.contains(observer), "already observing");
        //#endif

        //#ifdef DEBUG
        debug.trace("adding observer: " + observer);
        //#endif
        if (!observers.contains(observer)) {
            observers.addElement(observer);
        }else{
            //#ifdef DEBUG
            debug.warn("addObserver: already observing");
            //#endif
        }
    }

    /**
     * Removes observer.
     * 
     * @param observers
     *            Vector of observers
     * @param observer
     *            the observer
     */
    public synchronized static void removeObserver(final Vector observers,
            final Observer observer) {
        //#ifdef DEBUG
        debug.trace("removing observer: " + observer);
        //#endif

        if (observers.contains(observer)) {
            observers.removeElement(observer);
        } else {
            //#ifdef DEBUG
            debug.trace("removing observer not present: " + observer);
            //#endif
        }
    }
}
