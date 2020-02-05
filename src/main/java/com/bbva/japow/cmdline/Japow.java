package com.bbva.japow.cmdline;

/**
 * Japow!
 *
 */

import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Command;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Spec;

import picocli.CommandLine.Model.CommandSpec;


import java.util.concurrent.Callable;


@Command(name="kapow",
        subcommands={HelpCommand.class, VersionCmd.class, RouteCmd.class, ServerCmd.class, GetCmd.class, SetCmd.class},
        mixinStandardHelpOptions = true,
        versionProvider = VersionCmd.class,
        synopsisSubcommandLabel="COMMAND"
)
public class Japow implements Callable<Integer> {

  @Spec CommandSpec spec;

  public Japow() { }

  public Integer call() {

    throw new ParameterException(spec.commandLine(), "Missing required subcommand");
  }


}
