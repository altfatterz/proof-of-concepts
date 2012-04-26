package com.infohubble.dropwizard.helloworld.health;

import com.yammer.metrics.core.HealthCheck;

/**
 * Created with IntelliJ IDEA.
 * User: zoli
 * Date: 4/26/12
 * Time: 10:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class TemplateHealthCheck extends HealthCheck {

    private final String template;

    public TemplateHealthCheck(String template) {
        super(template);
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String saying = String.format(template, "TEST");

        if (!saying.contains("TEST")) {
            return Result.unhealthy("template doesn't include a name");
        }
        return Result.healthy();
    }


}
