
package br.com.integration.open.shift.service;

import java.util.Date;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.integration.open.shift.entity.Host;
import br.com.integration.open.shift.filter.HostFilter;
import br.com.integration.open.shift.repository.HostRepository;

/**
 * @author Thiago Araujo
 * 
 *
 */
@Service
public class HostServiceImpl implements HostService {
	static Logger logger = LoggerFactory.getLogger(HostServiceImpl.class);
	@Autowired
	private HostRepository hostRepository;

	@Override
	public Host create(HostFilter host) throws Exception {
		logger.info("<<<<<<<<<<<<<CREATE Host>>>>>>>>>>>>>>");
		try {
			return hostRepository.save(new Host(host.getName(), new Date(), null));
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Optional<Host> read(Long id) throws Exception {
		logger.info("<<<<<<<<<<<<<READ Host>>>>>>>>>>>>>>");

		try {

			return hostRepository.findById(id);

		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public Host update(Long id, HostFilter filter) throws Exception {
		logger.info("<<<<<<<<<<<<<UPDATE Host>>>>>>>>>>>>>>");
		try {
			Optional<Host> optHost = hostRepository.findById(id);
			if (optHost.isPresent()) {
				Host host = optHost.get();
				host.setName(filter.getName());
				host.setDateUpdated(new Date());
				return hostRepository.save(host);
			}
			return null;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}
	@Override
	public boolean delete(Long id) throws Exception {
		logger.info("<<<<<<<<<<<<<DELETE Host>>>>>>>>>>>>>>");
		try {
			Optional<Host> Host = hostRepository.findById(id);
			if (Host.isPresent()) {
				hostRepository.deleteById(id);
				return true;
			}
			return false;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
