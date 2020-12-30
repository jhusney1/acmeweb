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

    @RequestMapping("/status")
    public ServerStatus getServerStatus(@RequestParam(value = "name", defaultValue = "Anonymous") String name,
                                        @RequestParam(value = "details", required = false) List<String> details) {
//        System.out.println("*** DEBUG INFO ***" + details);

//        return new ServerStatus(counter.incrementAndGet(),
//                String.format(template, name));
        BasicServerStatusCmd cmd = new BasicServerStatusCmd(counter.incrementAndGet(), template, name);
        SimpleExecutor exc = new SimpleExecutor(cmd);
        exc.handleImmediately();
        return cmd.getResult();
    }

    @RequestMapping("/status/detailed")
    public ServerStatus GetDetailedServerStatus(@RequestParam(value = "details") List<String> details,
                                                @RequestParam(value = "name", defaultValue = "Anonymous") String name) {


//        ServerStatus decoratedServerStatus = new ServerStatus(counter.incrementAndGet(), String.format(template, name), details);
//////
//////        for (String s : details) {
//////            if (s.equals("operations")) {
//////                decoratedServerStatus = new OperationsDecorator(decoratedServerStatus);
//////            } else if (s.equals("extensions")) {
//////                decoratedServerStatus = new ExtensionsDecorator(decoratedServerStatus);
//////            } else if (s.equals("memory")) {
//////                decoratedServerStatus = new MemoryDecorator(decoratedServerStatus);
//////            } else throw new BadRequestException("invalid details option:" + s);
//////        }
//////        return decoratedServerStatus;

        DetailedServerStatusCmd cmd = new DetailedServerStatusCmd(counter.incrementAndGet(), template, name, details);
        SimpleExecutor exc = new SimpleExecutor(cmd);
        exc.handleImmediately();
        return cmd.getResult();
    }

    @RequestMapping("/disk/status")
    public DiskStatus getHardDriveInfo(@RequestParam(value = "name", defaultValue = "Anonymous") String name) {

        DiskStatus ds = new DiskStatus(counter.incrementAndGet(), String.format(template, name));
        ds.checkDisk();
        return ds;

    }


}
