Feature: Running Kapow! cli with simple subcommands.
  Running Kapow! without subcommand, asking for help, and asking for version information.

  Scenario: Run Kapow! without any options or subcommands.
    Invoking Kapow! without subcommands or options should return an error, and show a missing subcommand message and
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
          get      Retrieves a Kapow! resource
          set      Sets a Kapow! resource value
        """

  Scenario: Run Kapow! with help subcommand.
    Invoking Kapow! with the help subcommand should return no error and show help information.

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
          get      Retrieves a Kapow! resource
          set      Sets a Kapow! resource value
        """

  Scenario: Run Kapow! with -h option.
    Invoking Kapow! with the -h option should return no error and show help information.

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
          get      Retrieves a Kapow! resource
          set      Sets a Kapow! resource value
        """

  Scenario: Run Kapow! with version subcommand.
    Invoking Kapow! with the version subcommand should return no error and show version information.

    Given subcommands are "version"
    When I run Kapow!
    Then I get an error code of 0
    And I see in StdOut the following message
        """
        japow version 0.1
        """

  Scenario: Run Kapow! with -V option.
    Invoking Kapow! with the -V option should return no error and show version information.

    Given options are "-V"
    When I run Kapow!
    Then I get an error code of 0
    And I see in StdOut the following message
        """
        japow version 0.1
        """
