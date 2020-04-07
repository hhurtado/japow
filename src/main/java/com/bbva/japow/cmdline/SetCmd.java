package com.bbva.japow.cmdline;

import java.util.concurrent.Callable;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import com.bbva.japow.Constants;


/**
 * Japow!
 *
 */
@Command(name="set",
        description="Sets a Kapow! resource value's value",
        showDefaultValues=true
)
public class SetCmd implements Callable<Integer> {

    public SetCmd() { }

    @Option(names="--data-url",
            description="Kapow! data interface URL. Overwrites " + Constants.ENVVAR_DATA_URL + " environmental variable",
            defaultValue="${env:" + Constants.ENVVAR_DATA_URL + ":-" + Constants.DATA_API_URL + "}",
            paramLabel="string"
    )
    String dataUrl;

    @Option(names="--handler",
            description="Kapow! handler ID. Overwrites " + Constants.ENVVAR_HANDLER_ID + " environmental variable",
            defaultValue="${env:" + Constants.ENVVAR_HANDLER_ID + ":-}",
            paramLabel="string"
    )
    String handlerId;

    @Parameters(paramLabel="resource",
            description="Resource path",
            arity="1",
            index="0"
    )
    String resourcePath;

    @Parameters(paramLabel="value",
            description="Value for the resource. If not present value is read from standard Stdin",
            arity="0..1",
            index="1"
    )
    String value;

    public Integer call() throws Exception {
        // TODO: PENDING implementation
        return 0;
    }

}
