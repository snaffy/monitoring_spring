package pl.ki.wex.monitoring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Repository;
import pl.ki.wex.monitoring.dao.HttpTraceService;

import java.util.List;

@Repository
public class CustomTraceRepository implements HttpTraceRepository {

    Logger logger = LoggerFactory.getLogger(CustomTraceRepository.class);


    @Autowired
    private HttpTraceService httpTraceService;

    @Override
    public List<HttpTrace> findAll() {
        return httpTraceService.findAll();
    }

    @Override
    public void add(HttpTrace trace) {
        if (trace.getResponse().getStatus() > 200) {
            logger.error(trace.getRequest().getUri().getPath());
            httpTraceService.store(trace);
        }
    }
}
