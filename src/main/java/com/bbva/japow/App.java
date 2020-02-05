package com.bbva.japow;

import com.bbva.japow.cmdline.Japow;
import picocli.CommandLine;

/**
 * Japow!
 *
 */
public class App  {

  public static void main( String[] args ) {
    CommandLine cmd = new CommandLine(new Japow());

    int ret = cmd.execute(args);

    System.exit(ret);
  }

}
