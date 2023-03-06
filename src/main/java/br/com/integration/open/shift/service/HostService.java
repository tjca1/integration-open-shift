
package br.com.integration.open.shift.service;

import java.util.Optional;

import br.com.integration.open.shift.entity.Host;
import br.com.integration.open.shift.filter.HostFilter;

/**
 * @author Thiago Araujo
 * 
 *
 */
public interface HostService {
	
	
	public Host create (HostFilter host) throws Exception;
	
	public Optional<Host> read (Long id) throws Exception;
	
	public Host update (Long id, HostFilter filter) throws Exception;
	
	public boolean delete (Long id) throws Exception;
}

