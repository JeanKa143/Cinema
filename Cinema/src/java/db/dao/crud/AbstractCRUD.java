/*
 * Integrantes del equipo:
 * - Luis Fallas Carvajal                   Cedula: 305180995
 * - Diana Fallas Mendez                Cedula: 117770654
 * - Jean Carlo Jimenez Oviedo     Cedula: 402500956
 * 
 * Curso: EIF209 ProgramacionIV
 * I Ciclo 2021
 */
package db.dao.crud;


public abstract class AbstractCRUD {

    public abstract String getListAllCmd();

    public abstract String getAddCmd();

    public abstract String getRetrieveCmd();

    public abstract String getUpdateCmd();

    public abstract String getDeleteCmd();
}
