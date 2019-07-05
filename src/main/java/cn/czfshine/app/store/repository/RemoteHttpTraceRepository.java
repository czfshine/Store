package cn.czfshine.app.store.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.actuate.trace.http.HttpTrace;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;

import java.util.Collections;
import java.util.List;

/**
 * 将http请求输出到日志里面,方便调试.
 * 注意:发布版本最好去掉
 * todo: 同上
 *
 * @see cn.czfshine.app.store.config.TraceConfig
 */
@Slf4j
public class RemoteHttpTraceRepository implements HttpTraceRepository {

    @Override
    public List<HttpTrace> findAll() {
        return Collections.emptyList();
    }

    @Override
    public void add(HttpTrace trace) {
        String path = trace.getRequest().getUri().getPath();
        String queryPara = trace.getRequest().getUri().getQuery();
        String queryParaRaw = trace.getRequest().getUri().getRawQuery();
        String method = trace.getRequest().getMethod();
        long timeTaken = trace.getTimeTaken();
        String time = trace.getTimestamp().toString();
        log.info("path: {}, queryPara: {}, queryParaRaw: {}, timeTaken: {}, time: {}, method: {}", path, queryPara, queryParaRaw,
                timeTaken, time, method);
    }
}