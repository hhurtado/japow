package com.bbva.japow;

public class Constants {
    public static final String CONTROL_BIND_PORT = "8081";
    public static final String DATA_BIND_PORT = "8082";
    public static final String USER_BIND_ADDR = "0.0.0.0:8080";
    public static final String CONTROL_BIND_ADDR = "localhost:" + CONTROL_BIND_PORT;
    public static final String DATA_BIND_ADDR = "localhost:" + DATA_BIND_PORT;
    public static final String CONTROL_API_URL = "http://localhost:" + CONTROL_BIND_PORT;
    public static final String DATA_API_URL = "http://localhost:" + DATA_BIND_PORT;

    public static final String HANDLER_ENVVAR_NAME = "KAPOW_HANDLER_ID";
    public static final String CTRL_URL_ENVVAR_NAME = "KAPOW_CONTROL_URL";
    public static final String DATA_URL_ENVVAR_NAME = "KAPOW_DATA_URL";
    public static final String USER_BIND_ENVVAR_NAME = "KAPOW_USER_BIND";
    public static final String DATA_BIND_ENVVAR_NAME = "KAPOW_DATA_BIND";
    public static final String CTRL_BIND_ENVVAR_NAME = "KAPOW_CONTROL_BIND";

    private Constants() { }
}
