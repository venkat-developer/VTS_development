package com.harman.its.dao.idao;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

import com.harman.its.entity.ientity.IEntity;
/**
 * Interface for all the Daos with 
 * @author VAmukapati
 *
 */
@SuppressWarnings("rawtypes")
public interface IDao<T extends IEntity> {


	/**
	 * Unarchive the entries if trying to upload the same data again.
	 * @param entity
	 * @return
	 * @throws ParseException 
	 */

	public T insert(T entity) throws SQLException, ClassNotFoundException, ParseException;
	public int update(T entity) throws ClassNotFoundException, SQLException, ParseException;
	public T delete(T entity);
	public List<T> selectAll() throws SQLException, ClassNotFoundException;
	public void archiveData() throws ClassNotFoundException, SQLException;
}
