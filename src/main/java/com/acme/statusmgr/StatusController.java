package com.acme.statusmgr;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import com.acme.statusmgr.beans.*;
import org.springframework.web.bind.annotation.*;
import com.acme.statusmgr.executors.SimpleExecutor;
import com.acme.statusmgr.commands.*;

/**
 * Controller for all web/REST requests about the status of servers
 * <p>
 * For initial school project - just handles info about this server
 * Syntax for URLS:
 * All start with /server
 * /status  will give back status of server
 * a param of 'name' specifies a requestor name to appear in response
 * <p>
 * Examples:
 * http://localhost:8080/server/status
 * <p>
 * http://localhost:8080/server/status?name=Noach
 */

@RestController
@RequestMapping("/server")
public class StatusController {

    protected static final String template = "Server Status requested by %s";
    protected final AtomicLong counter = new AtomicLong();

    /**
     * Used to retrieve basic information such as name and string about system info
     * @param name
     * @param details
     * @return
     */
    @RequestMapping("/status")
    public ServerStatus getServerStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                        @RequestParam(value = "details", required = false) List<String> details) {

        BasicServerStatusCmd cmd = new BasicServerStatusCmd(counter.incrementAndGet(), template, name);
        SimpleExecutor exc = new SimpleExecutor(cmd);
        exc.handleImmediately();
        return cmd.getResult();
    }

    /**
     * Method called to obtain basic information such as the name of requestor, and some strings about
     * pc details
     * @param details
     * @param name
     * @return
     */
    @RequestMapping("/status/detailed")
    public ServerStatus GetDetailedServerStatus(@RequestParam(value = "details") List<String> details,
                                                @RequestParam(value = "name", defaultValue = "Anonymous") String name) {


        DetailedServerStatusCmd cmd = new DetailedServerStatusCmd(counter.incrementAndGet(), template, name, details);
        SimpleExecutor exc = new SimpleExecutor(cmd);
        exc.handleImmediately();
        return cmd.getResult();
    }

    /**
     * Used to obtain information about the hard drive
     * @param name
     * @return
     */
    @RequestMapping("/disk/status")
    public DiskStatus getHardDriveInfo(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {

        DiskStatusCmd cmd = new DiskStatusCmd(counter.incrementAndGet(), template, name);
        SimpleExecutor exc = new SimpleExecutor(cmd);
        exc.handleImmediately();
        return cmd.getResult();
//        DiskStatus ds = new DiskStatus(counter.incrementAndGet(), String.format(template, name));
//        ds.checkDisk();
//        return ds;

    }


}
