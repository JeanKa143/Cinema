/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package db.dao;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

public interface DAO<K, V> {

    public List<V> listAll() throws SQLException, IOException;

    public void add(K id, V value) throws SQLException, IOException;

    public V retrieve(K id) throws SQLException, IOException;
    
    public List<V> retrieveList(K id) throws SQLException, IOException;

    public void update(K id, V value) throws SQLException, IOException;

    public void delete(K id) throws SQLException, IOException;
}
