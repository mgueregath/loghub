/*
 * Brugge Framework.
 */
package io.codeffeine.brugge.domain.server;

import java.util.List;
import java.util.Map;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@codeffeine.io>
 */
public interface GetServerUsageInterface {

    public Map<String, Object> getUsage();

    public Map<String, Object> getCommittedVirtualMemorySize();

    public Map<String, Object> getFreePhysicalMemorySize();

    public Map<String, Object> getFreeSwapSpaceSize();

    public Map<String, Object> getProcessCpuTime();

    public Map<String, Object> getTotalPhysicalMemorySize();

    public Map<String, Object> getProcessCpuLoad();

    public Map<String, Object> getSystemCpuLoad();

    public Map<String, Object> getTotalSwapSpaceSize();

    public List<Map<String, Object>> getDiskTotalSpace();

    public List<Map<String, Object>> getDiskFreeSpace();

    public List<Map<String, Object>> getDiskUsableSpace();

    public List<String> getProcesses();

    public String getOperatingSystem();
}
