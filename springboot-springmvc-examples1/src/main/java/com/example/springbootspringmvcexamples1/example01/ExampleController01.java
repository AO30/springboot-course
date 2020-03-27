package com.example.springbootspringmvcexamples1.example01;

import com.example.springbootspringmvcexamples1.example01.entity.Address;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/example01/")
public class ExampleController01 {
    @GetMapping("index")
    public Map getIndex() {
        return  Map.of("name","AO");
    }

    @GetMapping("addresses")
    public List getAddresses01() {
        Address a1 = new Address(1, "956", "aaaa", LocalDateTime.now());
        Address a2 = new Address(2, "925", "bbbb", LocalDateTime.now());
        Address a3 = new Address(3, "1201", "cccc", LocalDateTime.now());
        return List.of(a1, a2, a3);
    }

    @GetMapping("addresses03")
    public Map getAddresses03() {
        Address a4 = new Address(4, "956", "aaaa", LocalDateTime.now());
        Address a5 = new Address(5, "925", "bbbb", LocalDateTime.now());
        Address a6 = new Address(6, "1201", "cccc", LocalDateTime.now());
        return Map.of("addresses", List.of(a4, a5, a6), "name", "AO");
    }

    @PostMapping("addresses")
    public Map postAddress(@RequestBody Address address) {
        log.debug(address.getDetail());
        log.debug(address.getComment());
        return Map.of();
    }

    @PostMapping("addresses02")
    public Map postAddress02(@RequestBody Address address) {
        log.debug(address.getDetail());
        log.debug(address.getComment());
        log.debug("{}",address.getUser().getId());
        return Map.of();
    }

    @GetMapping("addresses/{aid}")
    public Map getAddress(@PathVariable int aid) {
        Address address = ADDRESSES.stream()
                .filter(a -> a.getId() == aid)
                .findFirst()
                .orElse(new Address());
        return Map.of("address", address);
    }

    private final List<Address> ADDRESSES = create();
    private List<Address> create() {
        Address a1 = new Address(1,"956","a",LocalDateTime.now());
        Address a2 = new Address(2,"925","b",LocalDateTime.now());
        Address a3 = new Address(3,"1201","c",LocalDateTime.now());
        return List.of(a1, a2, a3);
    }
}
