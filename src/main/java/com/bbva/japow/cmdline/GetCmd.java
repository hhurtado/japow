package com.bbva.japow.cmdline;

import com.bbva.japow.Constants;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name="get",
        description="Retrieves a Kapow! resource",
        showDefaultValues=true
)
public class GetCmd implements Callable<Integer> {

    public GetCmd() {}

    @Option(names="--data-url",
            description="Kapow! data interface URL",
            defaultValue=Constants.CONTROL_API_URL,
            paramLabel="string"
    )
    String dataUrl;

    @Option(names="--handler",
            description="Kapow! handler ID",
            paramLabel="string"
    )
    String handlerId;

    @Parameters(paramLabel="resource",
            description="Resource path",
            arity="1"
    )
    String resourcePath;

    public Integer call() throws Exception {
        return 0;
    }

}
