package org.example._4_props_and_methods;

public enum LogLevel {
    DEBUG("It's DEBUG!", false),
    INFO("It's INFO!", false),
    WARNING("It's WARNING!", true);

    private final String getDisplayName;
    private final boolean sendSMSToAdmin;

    LogLevel(String getDisplayName, boolean sendSMSToAdmin) {
        this.getDisplayName = getDisplayName;
        this.sendSMSToAdmin = sendSMSToAdmin;
    }

    public String getGetDisplayName() {
        return getDisplayName;
    }

    public boolean isSendSMSToAdmin() {
        return sendSMSToAdmin;
    }
}
