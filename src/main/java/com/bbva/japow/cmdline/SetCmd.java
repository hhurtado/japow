package com.bbva.japow.cmdline;

import com.bbva.japow.Constants;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name="set",
        description="Sets a Kapow! resource value",
        showDefaultValues=true
)
public class SetCmd implements Callable<Integer> {

    public SetCmd() { }

    @Option(names="--data-url",
            description="Kapow! data interface URL",
            defaultValue= Constants.CONTROL_API_URL,
            paramLabel="string"
    )
    String dataUrl;

    @Option(names="--handler",
            description="Kapow! handler ID",
            paramLabel="string"
    )
    String handlerId;

    @Parameters(paramLabel="value",
            description="Resource path",
            arity="0..1",
            index="1"
    )
    String value;

    @Parameters(paramLabel="resource",
            description="Resource path",
            arity="1",
            index="0"
    )
    String resourcePath;

    public Integer call() throws Exception {

        return 0;
    }

}
