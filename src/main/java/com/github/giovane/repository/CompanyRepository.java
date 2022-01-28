package com.github.giovane.repository;

import com.github.giovane.entity.CompanyEntity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyRepository extends RepositoryConnection implements CompanyRepositoryInterface {

    private CompanyEntity hydrateCompany(ResultSet rs) throws SQLException {
        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity
            .setId(rs.getInt("id"))
            .setName(rs.getString("name"))
            .setAddress(rs.getString("address"));
        return companyEntity;
    }

    @Override
    public List<CompanyEntity> find() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM company;");
            ResultSet rs = stmt.executeQuery();
            List<CompanyEntity> list = new ArrayList<>();
            while (rs.next()) {
                list.add(hydrateCompany(rs));
            }
            rs.close();
            return list;
        } catch (SQLException exception) {
            exception.printStackTrace();
        } finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
        return null;
    }

    @Override
    public CompanyEntity findOneById(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement("SELECT * FROM company WHERE id=?");
            stmt.setLong(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()) {
                CompanyEntity companyEntity = this.hydrateCompany(rs);
                rs.close();
                return companyEntity;
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
        return null;
    }

    @Override
    public void save(CompanyEntity companyEntity) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement("INSERT INTO company(name, address) VALUES (?, ?);", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, companyEntity.getName());
            stmt.setString(2, companyEntity.getAddress());
            int count = stmt.executeUpdate();
            if(count == 0) {
                throw new SQLException("Error in insert company");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
    }

    @Override
    public void update(int id, CompanyEntity companyEntity) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement("UPDATE company SET name=?, address=? WHERE id=?;", Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, companyEntity.getName());
            stmt.setString(2, companyEntity.getAddress());
            stmt.setLong(3, id);
            int count = stmt.executeUpdate();
            if(count == 0) {
                throw new SQLException("Error in insert company");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
    }

    @Override
    public void delete(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = this.getConnection();
            stmt = conn.prepareStatement("DELETE FROM company WHERE id=?", Statement.RETURN_GENERATED_KEYS);
            stmt.setLong(1, id);
            int count = stmt.executeUpdate();
            if(count == 0) {
                throw new SQLException("Error in insert company");
            }
        } catch (SQLException exception) {
            exception.printStackTrace();
            throw exception;
        } finally {
            if(stmt != null) {
                stmt.close();
            }
            if(conn != null) {
                conn.close();
            }
        }
    }

}
