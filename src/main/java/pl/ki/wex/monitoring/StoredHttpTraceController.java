package pl.ki.wex.monitoring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.ki.wex.monitoring.dao.HttpTraceService;

import java.util.List;

@RestController
public class StoredHttpTraceController {

    @Autowired
    private HttpTraceService httpTraceService;

    @GetMapping("/findall")
    public List<HttpTrace> findall() {
        return httpTraceService.findAll();
    }
}