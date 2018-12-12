package org.grails.plugins.smartclient;

import org.grails.core.AbstractInjectableGrailsClass;

/**
 * @author Denis Halupa
 */
public class DefaultDataSourceHandlerGrailsClass extends AbstractInjectableGrailsClass implements DataSourceHandlerGrailsClass {

    public DefaultDataSourceHandlerGrailsClass(Class<?> clazz) {
        super(clazz, DataSourceHandlerArtefactHandler.TYPE);
    }
}