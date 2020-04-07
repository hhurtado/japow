package com.bbva.japow;

import picocli.CommandLine;

import com.bbva.japow.cmdline.Japow;


/**
 * Japow!
 *
 */
public class App  {

  public static void main( String[] args ) {
    CommandLine cmd = new CommandLine(new Japow());

    System.exit(cmd.execute(args));
  }

}
