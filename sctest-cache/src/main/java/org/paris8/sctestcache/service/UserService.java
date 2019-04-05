package org.paris8.sctestcache.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "sctest-app")
public interface UserService {

    @RequestMapping(value = "/user/getById", method = RequestMethod.GET)
    String getById(@RequestParam(value = "id") Long id);
}
