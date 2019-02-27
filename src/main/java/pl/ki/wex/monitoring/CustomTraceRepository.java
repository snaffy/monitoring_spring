package pl.ki.wex.monitoring;

import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Repository
public class CustomTraceRepository implements HttpTraceRepository {

    private final List<HttpTrace> traces = new LinkedList<>();
    private final int CAPACITY = 500;
    private final boolean REVERSE = true;

    @Override
    public List<HttpTrace> findAll() {
        synchronized (this.traces) {
            return Collections.unmodifiableList(new ArrayList<>(this.traces));
        }
    }

    @Override
    public void add(HttpTrace trace) {
        synchronized (this.traces) {
            while (this.traces.size() >= this.CAPACITY) {
                this.traces.remove(this.REVERSE ? this.CAPACITY - 1 : 0);
            }
            if (this.REVERSE) {
                this.traces.add(0, trace);
            } else {
                this.traces.add(trace);
            }
        }
    }
}
