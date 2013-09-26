package org.zed.coding;

import org.resthub.common.util.PostInitialize;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Named;


@Named("applicationInitializer")
public class ApplicationInitializer {

    /**
     * Logger
     */
    private static final Logger logger = LoggerFactory.getLogger(ApplicationInitializer.class);

    @PostInitialize
    public void init(){

    }
}
