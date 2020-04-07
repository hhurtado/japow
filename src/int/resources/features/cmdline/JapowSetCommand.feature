Feature: Running Kapow! cli with set subcommand.
  Running Kapow! with set subcommand providing different options and arguments.

  Scenario: Run Kapow! set subcommand without any options or arguments.
    Invoking Kapow! set subcommand without any options or arguments should return an error, show a missing argument
    message and set's subcommand help information.

    Given subcommands are "set"
    When I run Kapow!
    Then I get an error code of 2
    And I see in StdErr the following message
        """
        Missing required parameter: resource
        Usage: kapow set [--data-url=string] [--handler=string] resource [value]
        Sets a Kapow! resource value's value
              resource            Resource path
              [value]             Value for the resource. If not present value is read
                                    from standard Stdin
              --data-url=string   Kapow! data interface URL. Overwrites KAPOW_DATA_URL
                                    environmental variable
                                    Default: http://localhost:8082
              --handler=string    Kapow! handler ID. Overwrites KAPOW_HANDLER_ID
                                    environmental variable
                                    Default:
        """

  Scenario: Run Kapow! set subcommand without resource argument and using KAPOW_DATA_URL env. variable.
    Invoking Kapow! set subcommand without resource argument and with env. variable KAPOW_DATA_URL set should return an
    error, show a missing argument message and set's subcommand help information.

    Given subcommands are "set"
    And env. variable "KAPOW_DATA_URL" is set to "http://otherhost:82"
    When I run Kapow!
    Then I get an error code of 2
    And I see in StdErr the following message
        """
        Missing required parameter: resource
        Usage: kapow set [--data-url=string] [--handler=string] resource [value]
        Sets a Kapow! resource value's value
              resource            Resource path
              [value]             Value for the resource. If not present value is read
                                    from standard Stdin
              --data-url=string   Kapow! data interface URL. Overwrites KAPOW_DATA_URL
                                    environmental variable
                                    Default: http://otherhost:82
              --handler=string    Kapow! handler ID. Overwrites KAPOW_HANDLER_ID
                                    environmental variable
                                    Default:
        """


  Scenario: Run Kapow! get subcommand without resource argument and using KAPOW_HANDLER_ID env. variable.
    Invoking Kapow! get subcommand without resource argument and with env. variable KAPOW_HANDLER_ID set should return
    an error, show a missing argument message and get's subcommand help information.

    Given subcommands are "get"
    And env. variable "KAPOW_HANDLER_ID" is set to "FOO"
    When I run Kapow!
    Then I get an error code of 2
    And I see in StdErr the following message
        """
        Missing required parameter: resource
        Usage: kapow set [--data-url=string] [--handler=string] resource [value]
        Sets a Kapow! resource value's value
              resource            Resource path
              [value]             Value for the resource. If not present value is read
                                    from standard Stdin
              --data-url=string   Kapow! data interface URL. Overwrites KAPOW_DATA_URL
                                    environmental variable
                                    Default: http://localhost:8082
              --handler=string    Kapow! handler ID. Overwrites KAPOW_HANDLER_ID
                                    environmental variable
                                    Default: FOO
        """
