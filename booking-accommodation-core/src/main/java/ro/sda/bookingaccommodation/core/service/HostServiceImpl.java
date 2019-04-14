package ro.sda.bookingaccommodation.core.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ro.sda.bookingaccommodation.core.entity.Host;
import ro.sda.bookingaccommodation.core.repository.HostRepository;

import java.util.List;

@Service
@Transactional(readOnly = true, rollbackFor = Exception.class)
public class HostServiceImpl implements HostService {

    @Autowired
    HostRepository hostRepository;

    @Override
    public Host createHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public Host readHost(Long hostId) {
        return hostRepository.findById(hostId);
    }

    @Override
    public Host updateHost(Host host) {
        return hostRepository.save(host);
    }

    @Override
    public void deleteHost(Long hostId) {
        hostRepository.delete(hostId);
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Host findById(Long id) {
        return hostRepository.findById(id);
    }
}
