package pl.ki.wex.monitoring.dao;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HttpTraceService {
    @Autowired
    private HttpTraceRepository httpTraceRepository;

    public synchronized void store(HttpTrace httpTrace) {
        Gson gson = new Gson();
        String httpStoreAsJson = gson.toJson(httpTrace);

        pl.ki.wex.monitoring.dao.HttpTrace httpT = new pl.ki.wex.monitoring.dao.HttpTrace(httpStoreAsJson);
        httpTraceRepository.save(httpT);
    }

    public synchronized List<HttpTrace> findAll() {
        final Iterable<pl.ki.wex.monitoring.dao.HttpTrace> all = httpTraceRepository.findAll();
        List<HttpTrace> found = new ArrayList<>();

        all.forEach(httpTrace -> found.add(convertFromString(httpTrace)));
        return found;
    }

    private HttpTrace convertFromString(pl.ki.wex.monitoring.dao.HttpTrace httpTrace) {
        Gson gson = new Gson();
        return gson.fromJson(httpTrace.getTrace(), HttpTrace.class);
    }
}
