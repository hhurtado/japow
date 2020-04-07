package com.bbva.japow.cmdline;

import java.util.concurrent.Callable;

import picocli.CommandLine.ArgGroup;
import picocli.CommandLine.HelpCommand;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.ParameterException;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.Spec;

import picocli.CommandLine.Model.CommandSpec;

import com.bbva.japow.Constants;


/**
 * Japow!
 *
 */
@Command(name="route",
        description="Manages routes in a Kapow! Server",
        subcommands={HelpCommand.class},
        synopsisSubcommandLabel="COMMAND"
)
public class RouteCmd implements Callable<Integer> {

    @Spec CommandSpec spec;

    public static class CommandCode {
        @Option(names={"-c", "--command"},
                description="Command to pass to the entrypoint command",
                paramLabel="string",
                required=false)
        String command;

        @Parameters(paramLabel="command_file",
                description="File containing code for the command. If present must be the last argument",
                arity="0..1",
                index="1")
        String commandFile;
    }

    public RouteCmd() { }

    @Override
    public Integer call() {

        throw new ParameterException(spec.commandLine(), "Missing required subcommand");
    }

    @Command(name="add",
            description="Adds a new route",
            showDefaultValues=true)
    public Integer add(@Option(names="--control-url",
                               description="Kapow! control interface URL, Overwrites " + Constants.ENVVAR_CTRL_URL + " environmental variable.",
                               defaultValue="${env:" + Constants.ENVVAR_CTRL_URL + ":-" + Constants.CONTROL_API_URL + "}",
                               paramLabel="string") String controlUrl,
                       @Option(names={"-e", "--entrypoint"},
                               description="Command to execute",
                               paramLabel="string",
                               defaultValue="/bin/sh -c") String entrypoint,
                       @Option(names={"-X", "--method"},
                               description="HTTP method to accept",
                               paramLabel="string",
                               defaultValue="GET") String method,
                       @Parameters(paramLabel="url_pattern",
                                   description="Pattern to publish the route with",
                                   arity="1",
                                   index="0") String urlPattern,
                       @ArgGroup(exclusive=true, multiplicity="0..1") RouteCmd.CommandCode commandCode ) {
        // TODO: PENDING implementation
        return 0;
    }

    @Command(name="list",
            description="Lists existing routes",
            showDefaultValues=true)
    public Integer list(@Option(names="--control-url",
                                description="Kapow! control interface URL, Overwrites " + Constants.ENVVAR_CTRL_URL + " environmental variable.",
                                defaultValue="${env:" + Constants.ENVVAR_CTRL_URL + ":-" + Constants.CONTROL_API_URL + "}",
                                paramLabel="string") String controlUrl) {
        // TODO: PENDING implementation
        return 0;
    }

    @Command(name="remove",
            description="Removes the given route",
            showDefaultValues=true)
    public Integer remove(@Option(names="--control-url",
                                  description="Kapow! control interface URL, Overwrites " + Constants.ENVVAR_CTRL_URL + " environmental variable.",
                                  defaultValue="${env:" + Constants.ENVVAR_CTRL_URL + ":-" + Constants.CONTROL_API_URL + "}",
                                  paramLabel="string") String controlUrl,
                          @Parameters(paramLabel="route_id",
                                      description="RouteID to remove",
                                      arity="1") String routeId) {
        // TODO: PENDING implementation
        return 0;
    }
}
