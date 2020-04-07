package com.bbva.japow;

public class Constants {

    public static final String CONTROL_BIND_PORT = "8081";
    public static final String DATA_BIND_PORT = "8082";
    public static final String USER_BIND_ADDR = "0.0.0.0:8080";
    public static final String CONTROL_BIND_ADDR = "localhost:" + CONTROL_BIND_PORT;
    public static final String DATA_BIND_ADDR = "localhost:" + DATA_BIND_PORT;
    public static final String CONTROL_API_URL = "http://" + CONTROL_BIND_ADDR;
    public static final String DATA_API_URL = "http://" + DATA_BIND_ADDR;

    public static final String ENVVAR_HANDLER_ID = "KAPOW_HANDLER_ID";
    public static final String ENVVAR_CTRL_URL = "KAPOW_CONTROL_URL";
    public static final String ENVVAR_DATA_URL = "KAPOW_DATA_URL";

    // Not in spec
    public static final String ENVVAR_USER_BIND_ADDR = "KAPOW_USER_BIND";
    public static final String SYSPROP_USER_BIND_ADDR = "japow.userBind";
    public static final String ENVVAR_DATA_BIND_ADDR = "KAPOW_DATA_BIND";
    public static final String SYSPROP_DATA_BIND_ADDR = "japow.dataBind";
    public static final String ENVVAR_CTRL_BIND_ADDR = "KAPOW_CONTROL_BIND";
    public static final String SYSPROP_CTRL_BIND_ADDR = "japow.controlBind";

    private Constants() { }
}
