package bytes.sync.ping;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;


@RestController
public class PingController {

    @Autowired
    PingRepository pingRepository;

    @GetMapping(path = "/pings", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<PingModel> getAllPings() {
        return pingRepository.findAll();
    }

    @PostMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
    public PingModel createPingObject(@RequestBody PingModel pingModel) {
        pingModel.setTimestamp(Timestamp.valueOf(LocalDateTime.now()));
        return pingRepository.save(pingModel);
    }

}
