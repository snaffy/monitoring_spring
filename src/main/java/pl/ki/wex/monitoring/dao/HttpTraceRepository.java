package pl.ki.wex.monitoring.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HttpTraceRepository extends CrudRepository<HttpTrace, Integer> {}
