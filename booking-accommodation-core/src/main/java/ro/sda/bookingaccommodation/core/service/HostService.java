package ro.sda.bookingaccommodation.core.service;

import ro.sda.bookingaccommodation.core.entity.Host;

import java.util.List;

public interface HostService {

    Host createHost(Host host);

    Host readHost(Long hostId);

    Host updateHost(Host host);

    void deleteHost(Long hostId);

    List<Host> findAll();
    Host findById(Long id);

}
