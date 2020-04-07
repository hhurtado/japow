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
@Command(name="get",
        description="Retrieves a Kapow! resource's value",
        showDefaultValues=true
)
public class GetCmd implements Callable<Integer> {

    public GetCmd() {}

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
            arity="1"
    )
    String resourcePath;

    @Override
    public Integer call() {
        // TODO: PENDING implementation
        return 0;
    }

}
