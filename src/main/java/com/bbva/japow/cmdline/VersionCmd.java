package com.bbva.japow.cmdline;

import picocli.CommandLine;
import picocli.CommandLine.Command;

import java.net.URL;

import java.util.concurrent.Callable;

import java.util.Enumeration;
import java.util.jar.Attributes;
import java.util.jar.Manifest;


/**
 * Japow!
 *
 */
@Command(name="version", description="Prints version info")
public class VersionCmd implements Callable<Integer>, CommandLine.IVersionProvider {

    public VersionCmd() { }

    @Override
    public Integer call() throws Exception {
        for (String s : getVersion()) {
            System.out.println(s);
        }
        return 0;
    }

    @Override
    public String[] getVersion() throws Exception {
        Enumeration<URL> resources = Japow.class.getClassLoader().getResources("META-INF/MANIFEST.MF");

        while (resources.hasMoreElements()) {
            Attributes attrs = new Manifest(resources.nextElement()
                                                .openStream())
                                    .getMainAttributes();
            String implTittle = (String)attrs.get(new Attributes.Name("Implementation-Title"));
            if ("japow".equals(implTittle)) {
                String implVersion = (String)attrs.get(new Attributes.Name("Implementation-Version"));
                return new String[] { implTittle + " version " + implVersion };
            }
        }

        return new String[0];
    }

}
