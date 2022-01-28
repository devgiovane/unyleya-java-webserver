package com.github.giovane.repository;

import com.github.giovane.entity.CompanyEntity;

import java.sql.SQLException;
import java.util.List;

public interface CompanyRepositoryInterface {

    public List<CompanyEntity> find() throws SQLException;

    public CompanyEntity findOneById(int id) throws SQLException;

    public void save(CompanyEntity entity) throws SQLException;

    public void update(int id, CompanyEntity companyEntity) throws SQLException;

    public void delete(int id) throws SQLException;
}
