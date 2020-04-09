Feature: Running Kapow! cli with server sub-command.
  Running Kapow! with server sub-command working with TLS parameterization.

  Scenario: Run Kapow! with server sub-command and only certfile option.
    Invoking Kapow! wit server sub-command and only certfile option should return an error, and show a required option
    message and sub-command's help information.

    Given subcommands are "server"
      And options are "--certfile"
    When I run Kapow!
    Then I get an error code of 2
      And I see in StdErr the following message
        """
        Missing required parameter for option '--certfile' (string)
        Usage: kapow server [--bind=string] [--certfile=string] [--clientauth=boolean]
                            [--clientcafile=string] [--control-bind=string]
                            [--data-bind=string] [--keyfile=string] [POW_file]
        Starts a Kapow! server
              [POW_file]             Pow file with routes to load at start-up
              --bind=string          IP address and port to bind the user interface to.
                                       Overwrites KAPOW_USER_BIND environmental variable
                                       Default: 0.0.0.0:8080
              --control-bind=string  IP address and port to bind the control interface
                                       to. Overwrites KAPOW_CONTROL_BIND environmental
                                       variable
                                       Default: localhost:8081
              --data-bind=string     IP address and port to bind the data interface to.
                                       Overwrites KAPOW_DATA_BIND environmental variable
                                       Default: localhost:8082
              --certfile=string      Cert file to serve thru https
              --keyfile=string       Key file to serve thru https
              --clientauth=boolean   Activate client mutual tls authentication
              --clientcafile=string  Cert file to validate client certificates

        """

  Scenario: Run Kapow! with server sub-command and only keyfile option.
    Invoking Kapow! wit server sub-command and only keyfile option should return an error, and show a required option
    message and sub-command's help information.

    Given subcommands are "server"
      And options are "--keyfile"
    When I run Kapow!
    Then I get an error code of 2
      And I see in StdErr the following message
        """
        Missing required parameter for option '--keyfile' (string)
        Usage: kapow server [--bind=string] [--certfile=string] [--clientauth=boolean]
                            [--clientcafile=string] [--control-bind=string]
                            [--data-bind=string] [--keyfile=string] [POW_file]
        Starts a Kapow! server
              [POW_file]             Pow file with routes to load at start-up
              --bind=string          IP address and port to bind the user interface to.
                                       Overwrites KAPOW_USER_BIND environmental variable
                                       Default: 0.0.0.0:8080
              --control-bind=string  IP address and port to bind the control interface
                                       to. Overwrites KAPOW_CONTROL_BIND environmental
                                       variable
                                       Default: localhost:8081
              --data-bind=string     IP address and port to bind the data interface to.
                                       Overwrites KAPOW_DATA_BIND environmental variable
                                       Default: localhost:8082
              --certfile=string      Cert file to serve thru https
              --keyfile=string       Key file to serve thru https
              --clientauth=boolean   Activate client mutual tls authentication
              --clientcafile=string  Cert file to validate client certificates

        """

  Scenario: Run Kapow! with server sub-command and only clientauth option.
    Invoking Kapow! wit server sub-command and only clientauth option should return an error, and show an invalid option
    message and sub-command's help information.

    Given subcommands are "server"
      And options are "--clientauth"
    When I run Kapow!
    Then I get an error code of 2
      And I see in StdErr the following message
        """
        Missing required parameter for option '--clientauth' (boolean)
        Usage: kapow server [--bind=string] [--certfile=string] [--clientauth=boolean]
                            [--clientcafile=string] [--control-bind=string]
                            [--data-bind=string] [--keyfile=string] [POW_file]
        Starts a Kapow! server
              [POW_file]             Pow file with routes to load at start-up
              --bind=string          IP address and port to bind the user interface to.
                                       Overwrites KAPOW_USER_BIND environmental variable
                                       Default: 0.0.0.0:8080
              --control-bind=string  IP address and port to bind the control interface
                                       to. Overwrites KAPOW_CONTROL_BIND environmental
                                       variable
                                       Default: localhost:8081
              --data-bind=string     IP address and port to bind the data interface to.
                                       Overwrites KAPOW_DATA_BIND environmental variable
                                       Default: localhost:8082
              --certfile=string      Cert file to serve thru https
              --keyfile=string       Key file to serve thru https
              --clientauth=boolean   Activate client mutual tls authentication
              --clientcafile=string  Cert file to validate client certificates

        """
