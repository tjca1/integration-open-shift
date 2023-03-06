
package br.com.integration.open.shift.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import br.com.integration.open.shift.entity.Host;

/**
 * @author Thiago Araujo
 * 
 *
 */
public interface HostRepository extends JpaRepository<Host, Long> {
	
	public Optional<Host> findById (Long id);

}
