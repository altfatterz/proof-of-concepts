package com.infohubble.dropwizard.helloworld.core;

/**
 * Created with IntelliJ IDEA.
 * User: zoli
 * Date: 4/26/12
 * Time: 10:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Saying {

    private final long id;
    private final String content;

    public Saying(long id, String content) {
        this.id = id;
        this.content = content;
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }
}
