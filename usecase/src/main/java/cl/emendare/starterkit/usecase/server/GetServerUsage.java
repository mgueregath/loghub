/*
 * StarterKit.
 */
package cl.emendare.starterkit.usecase.server;

import cl.emendare.starterkit.domain.server.GetServerUsageInterface;
import com.sun.management.OperatingSystemMXBean;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.SystemUtils;

/**
 *
 * @author Mirko Gueregat @mgueregath <mgueregath@emendare.cl>
 */
public class GetServerUsage implements GetServerUsageInterface {

    private final OperatingSystemMXBean mbean;
    private final List<File> files = new ArrayList<>();

    public GetServerUsage() {
        this.mbean = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        File[] roots = File.listRoots();
        for (File root : roots) {
            if (root.canRead()) {
                files.add(root);
            }
        }
    }

    @Override
    public Map<String, Object> getUsage() {
        Map<String, Object> map = new HashMap<>();
        List<Object> usages = new ArrayList<>();
        List<Object> diskUsages = new ArrayList<>();
        usages.add(getCommittedVirtualMemorySize());
        usages.add(getFreePhysicalMemorySize());
        usages.add(getFreeSwapSpaceSize());
        usages.add(getProcessCpuTime());
        usages.add(getTotalPhysicalMemorySize());
        usages.add(getProcessCpuLoad());
        usages.add(getSystemCpuLoad());
        usages.add(getTotalSwapSpaceSize());
        diskUsages.add(getDiskTotalSpace());
        diskUsages.add(getDiskFreeSpace());
        diskUsages.add(getDiskUsableSpace());
        map.put("usages", usages);
        map.put("processes", getProcesses());
        map.put("os", getOperatingSystem());
        map.put("disk", diskUsages);
        return map;
    }

    @Override
    public Map<String, Object> getCommittedVirtualMemorySize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Committed Virtual Memory Size");
        map.put("value", mbean.getCommittedVirtualMemorySize() / (1024 * 1024));
        return map;
    }

    @Override
    public Map<String, Object> getFreePhysicalMemorySize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Free Physical Memory Size");
        map.put("value", mbean.getFreePhysicalMemorySize() / (1024 * 1024));
        return map;
    }

    @Override
    public Map<String, Object> getFreeSwapSpaceSize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "FreeSwap Space Size");
        map.put("value", mbean.getFreeSwapSpaceSize() / (1024 * 1024));
        return map;
    }

    @Override
    public Map<String, Object> getProcessCpuTime() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Process Cpu Time");
        map.put("value", mbean.getProcessCpuTime() / 1000000000.0);
        return map;
    }

    @Override
    public Map<String, Object> getTotalPhysicalMemorySize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Total Physical Memory Size");
        map.put("value", mbean.getTotalPhysicalMemorySize() / (1024 * 1024));
        return map;
    }

    @Override
    public Map<String, Object> getProcessCpuLoad() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Process Cpu Load");
        map.put("value", mbean.getProcessCpuLoad() * 100.0);
        return map;
    }

    @Override
    public Map<String, Object> getSystemCpuLoad() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "System Cpu Load");
        map.put("value", mbean.getSystemCpuLoad() * 100.0);
        return map;
    }

    @Override
    public Map<String, Object> getTotalSwapSpaceSize() {
        Map<String, Object> map = new HashMap<>();
        map.put("name", "Total Swap Space Size");
        map.put("value", mbean.getTotalSwapSpaceSize() / (1024 * 1024));
        return map;
    }

    @Override
    public List<String> getProcesses() {
        Process proc;
        List<String> processes = new ArrayList<>();
        try {
            if (SystemUtils.IS_OS_WINDOWS) {
                proc = new ProcessBuilder("tasklist").start();
            } else {
                proc = new ProcessBuilder("top").start();
            }
            InputStream is = proc.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String line;
            while ((line = br.readLine()) != null) {
                processes.add(line);
            }
        } catch (IOException ex) {
            Logger.getLogger(GetServerUsage.class.getName()).log(Level.SEVERE, null, ex);
        }

        return processes;
    }

    @Override
    public String getOperatingSystem() {
        if (SystemUtils.IS_OS_WINDOWS) {
            return "Windows";
        } else {
            return "Linux";
        }
    }

    @Override
    public List<Map<String, Object>> getDiskTotalSpace() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (File file : files) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "Total disk space");
            map.put("unit", file.getAbsolutePath());
            map.put("value", file.getTotalSpace() / (1024 * 1024));
            list.add(map);
        }

        return list;
    }

    @Override
    public List<Map<String, Object>> getDiskFreeSpace() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (File file : files) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "Free disk space");
            map.put("unit", file.getAbsolutePath());
            map.put("value", file.getFreeSpace() / (1024 * 1024));
            list.add(map);
        }

        return list;
    }

    @Override
    public List<Map<String, Object>> getDiskUsableSpace() {
        List<Map<String, Object>> list = new ArrayList<>();
        for (File file : files) {
            Map<String, Object> map = new HashMap<>();
            map.put("name", "Usable disk space");
            map.put("unit", file.getAbsolutePath());
            map.put("value", file.getUsableSpace() / (1024 * 1024));
            list.add(map);
        }

        return list;
    }

}
