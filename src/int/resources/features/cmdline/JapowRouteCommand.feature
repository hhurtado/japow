Feature: Running Kapow! cli with route sub-command.
  Running Kapow! all route's sub-commands, add and remove.

  Scenario: Run Kapow! route without any options or sub-commands.
    Invoking Kapow! route without sub-commands or options should return an error, and show a missing sub-command message
    and sub-command's help information.

    Given subcommands are "route"
    When I run Kapow!
    Then I get an error code of 2
      And I see in StdErr the following message
        """
        Missing required subcommand
        Usage: kapow route COMMAND
        Manages routes in a Kapow! Server
        Commands:
          help    Displays help information about the specified command
          add     Adds a new route
          list    Lists existing routes
          remove  Removes the given route

        """

  Scenario: Run Kapow! "route add" without any options or sub-commands.
    Invoking Kapow! "route add" without parameters or options should return an error, and show a missing parameter
    message and sub-command's help information.

    Given subcommands are "route add"
    When I run Kapow!
    Then I get an error code of 2
      And I see in StdErr the following message
        """
        Missing required parameter: url_pattern
        Usage: kapow route add [-c=string | [command_file]] [--control-url=string]
                               [-e=string] [-X=string] url_pattern
        Adds a new route
              url_pattern            Pattern to publish the route with
              [command_file]         File containing code for the command. If present
                                       must be the last argument
          -c, --command=string       Command to pass to the entrypoint command
              --control-url=string   Kapow! control interface URL, Overwrites
                                       KAPOW_CONTROL_URL environmental variable.
                                       Default: http://localhost:8081
          -e, --entrypoint=string    Command to execute
                                       Default: /bin/sh -c
          -X, --method=string        HTTP method to accept
                                       Default: GET

        """
  @SKIP
  Scenario: Run Kapow! "route add" only with url_pattern.
    Invoking Kapow! "route add" only with parameter url_pattern should return an error, and show a missing parameter
    message and sub-command's help information.

    Given subcommands are "route add"
      And parameters are "/foo"
    When I run Kapow!
    Then I get an error code of 2
      And I see in StdErr the following message
        """
        Missing required command or command_file
        Usage: kapow route add [-c=string | [command_file]] [--control-url=string]
                               [-e=string] [-X=string] url_pattern
        Adds a new route
              url_pattern            Pattern to publish the route with
              [command_file]         File containing code for the command. If present
                                       must be the last argument
          -c, --command=string       Command to pass to the entrypoint command
              --control-url=string   Kapow! control interface URL, Overwrites
                                       KAPOW_CONTROL_URL environmental variable.
                                       Default: http://localhost:8081
          -e, --entrypoint=string    Command to execute
                                       Default: /bin/sh -c
          -X, --method=string        HTTP method to accept
                                       Default: GET

        """

  Scenario: Run Kapow! "route remove" without any options or sub-commands.
    Invoking Kapow! "route remove" without parameters or options should return an error, and show a missing parameter
    message and sub-command's help information.

    Given subcommands are "route remove"
    When I run Kapow!
    Then I get an error code of 2
      And I see in StdErr the following message
        """
        Missing required parameter: route_id
        Usage: kapow route remove [--control-url=string] route_id
        Removes the given route
              route_id               RouteID to remove
              --control-url=string   Kapow! control interface URL, Overwrites
                                       KAPOW_CONTROL_URL environmental variable.
                                       Default: http://localhost:8081

        """
