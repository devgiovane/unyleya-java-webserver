package com.github.giovane.service;

import com.github.giovane.entity.CompanyEntity;
import com.github.giovane.repository.CompanyRepository;

import java.sql.SQLException;
import java.util.List;

public class CompanyService {

    private final CompanyRepository repository = new CompanyRepository();

    public boolean save(CompanyEntity companyEntity) {
        try {
            repository.save(companyEntity);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public List<CompanyEntity> find() {
        try {
            return repository.find();
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public CompanyEntity findOne(int id) {
        try {
            return repository.findOneById(id);
        } catch (SQLException exception) {
            exception.printStackTrace();
            return null;
        }
    }

    public boolean update(int id, CompanyEntity companyEntity) {
        try {
            repository.update(id, companyEntity);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

    public boolean delete(int id) {
        try {
            repository.delete(id);
            return true;
        } catch (SQLException exception) {
            exception.printStackTrace();
            return false;
        }
    }

}
