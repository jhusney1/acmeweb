package com.acme.servermgr;

import com.acme.statusmgr.beans.AbstractStatus;

/**
 * Manage all servers (service providers) being tracked by the Acme server tracking system
 * For now just some simple static methods for use in school project
 */
public class ServerManager implements AbstractStatus {

    /**
     * Get the status of this server
     * @return a descriptive string about the servers status
     */
    @Override
    public String getCurrentServerStatus() {
        return "Server is up";
    }

    public static String getMemoryStatus() {
        return "and its memory is Running low";
    }
    public static String getOperationsStatus() {
        return "and is operating normally";
    }
    public static String getExtensionsStatus() {
        return "and is using these extensions - [Hypervisor, Kubernetes, RAID-6]";
    }

    /**
     * Find out if this server is operating normally
     * @return Boolean indicating if server is operating normally
     */
    static public Boolean isOperatingNormally()
    {
        return true;
    }
}
