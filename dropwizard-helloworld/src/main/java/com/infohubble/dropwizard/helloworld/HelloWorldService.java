package com.infohubble.dropwizard.helloworld;

import com.infohubble.dropwizard.helloworld.health.TemplateHealthCheck;
import com.infohubble.dropwizard.helloworld.resources.HelloWorldResource;
import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Environment;

/**
 * Created with IntelliJ IDEA.
 * User: zoli
 * Date: 4/26/12
 * Time: 10:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class HelloWorldService extends Service<HelloWorldConfiguration> {

    public static void main(String[] args) throws Exception {
        new HelloWorldService().run(args);
    }

    protected HelloWorldService() {
        super("hello-world");
    }

    @Override
    protected void initialize(HelloWorldConfiguration configuration, Environment environment) throws Exception {
        final String template = configuration.getTemplate();
        final String defaultName = configuration.getDefaultName();

        environment.addResource(new HelloWorldResource(template, defaultName));
        environment.addHealthCheck(new TemplateHealthCheck(template));

    }
}
