package com.bbva.japow.cmdline;

import com.bbva.japow.Constants;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;


@Command(name="server",
        description="Starts a Kapow! server",
        sortOptions=false,
        showDefaultValues=true
)
public class ServerCmd implements Callable<Integer> {

    public ServerCmd() { }

    @Option(names="--bind",
            description="IP address and port to bind the user interface to",
            defaultValue=Constants.USER_BIND_ADDR,
            paramLabel="string",
            order=0
    )
    String userBindAddr;

    @Option(names="--control-bind",
            description="IP address and port to bind the control interface to",
            defaultValue=Constants.CONTROL_BIND_ADDR,
            paramLabel="string",
            order=1
    )
    String controlBindAddr;

    @Option(names="--data-bind",
            description="IP address and port to bind the data interface to",
            defaultValue=Constants.DATA_BIND_ADDR,
            paramLabel="string",
            order=2
    )
    String dataBindAddr;

    @Option(names="--certfile",
            description="Cert file to serve thru https",
            paramLabel="string",
            order=3
    )
    String certFile;

    @Option(names="--keyfile",
            description="Key file to serve thru https",
            paramLabel="string",
            order=4
    )
    String keyFile;

    @Option(names="--clientauth",
            description="Activate client mutual tls authentication",
            paramLabel="boolean",
            order=5
    )
    String clientAuth;

    @Option(names="--clientcafile",
            description="Cert file to validate client certificates",
            paramLabel="string",
            order=6
    )
    String clientCAFile;

    @Parameters(paramLabel="POW_file",
            description="Pow file with routes to load at start-up",
            arity="0..1"
    )
    String powFile;

    public Integer call() throws Exception {
        return 0;
    }

}
