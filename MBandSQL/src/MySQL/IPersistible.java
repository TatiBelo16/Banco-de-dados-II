package MySQL;

import java.util.List;

public interface IPersistible <T>{
	
	void save ();
	T getOne(Long id);
	List <T> getAll();
	void delete(T entity);
	void update(T entity);
	void buscaNome(T entity);


}
