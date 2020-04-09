Feature: Running Kapow! cli with simple sub-commands.
  Running Kapow! without sub-command, asking for help, and asking for version information.

  Scenario: Run Kapow! without any options or sub-commands.
    Invoking Kapow! without sub-commands or options should return an error, and show a missing sub-command message and
    help information.

    When I run Kapow!
    Then I get an error code of 2
      And I see in StdErr the following message
        """
        Missing required subcommand
        Usage: kapow [-hV] COMMAND
          -h, --help      Show this help message and exit.
          -V, --version   Print version information and exit.
        Commands:
          help     Displays help information about the specified command
          version  Prints version info
          route    Manages routes in a Kapow! Server
          server   Starts a Kapow! server
          get      Retrieves a Kapow! resource's value
          set      Sets a Kapow! resource value's value

        """

  Scenario: Run Kapow! with help sub-command.
    Invoking Kapow! with the help sub-command should return no error and show command's help information.

    Given subcommands are "help"
    When I run Kapow!
    Then I get an error code of 0
      And I see in StdOut the following message
        """
        Usage: kapow [-hV] COMMAND
          -h, --help      Show this help message and exit.
          -V, --version   Print version information and exit.
        Commands:
          help     Displays help information about the specified command
          version  Prints version info
          route    Manages routes in a Kapow! Server
          server   Starts a Kapow! server
          get      Retrieves a Kapow! resource's value
          set      Sets a Kapow! resource value's value

        """

  Scenario: Run Kapow! with -h option.
    Invoking Kapow! with the -h option should return no error and show command's help information.

    Given options are "-h"
    When I run Kapow!
    Then I get an error code of 0
      And I see in StdOut the following message
        """
        Usage: kapow [-hV] COMMAND
          -h, --help      Show this help message and exit.
          -V, --version   Print version information and exit.
        Commands:
          help     Displays help information about the specified command
          version  Prints version info
          route    Manages routes in a Kapow! Server
          server   Starts a Kapow! server
          get      Retrieves a Kapow! resource's value
          set      Sets a Kapow! resource value's value

        """

  Scenario: Run Kapow! with version sub-command.
    Invoking Kapow! with the version sub-command should return no error and show command's version information.

    Given subcommands are "version"
    When I run Kapow!
    Then I get an error code of 0
      And I see in StdOut the following message
        """
        japow version 0.1

        """

  Scenario: Run Kapow! with -V option.
    Invoking Kapow! with the -V option should return no error and show command's version information.

    Given options are "-V"
    When I run Kapow!
    Then I get an error code of 0
      And I see in StdOut the following message
        """
        japow version 0.1

        """
