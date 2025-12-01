package org.example.dao.impl;

import org.example.dao.ResultDAO;
import org.example.model.Result;
import org.example.util.JDBCUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ResultDAOImpl implements ResultDAO {

    @Override
    public int addResult(Result result) throws Exception {
        String sql = "INSERT INTO results (studentId, marks, grade) VALUES (?, ?, ?)";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setInt(1, result.getStudentId());
            ps.setInt(2, result.getMarks());
            ps.setString(3, result.getGrade());

            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
                    return rs.getInt(1); // returning generated resultId
                }
            }
        }
        return -1;
    }

    @Override
    public boolean updateResult(Result result) throws Exception {
        String sql = "UPDATE results SET studentId=?, marks=?, grade=? WHERE resultId=?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, result.getStudentId());
            ps.setInt(2, result.getMarks());
            ps.setString(3, result.getGrade());
            ps.setInt(4, result.getResultId());

            return ps.executeUpdate() > 0;
        }
    }

    @Override
    public List<Result> getAllResults() throws Exception {
        String sql = "SELECT * FROM results ORDER BY resultId";
        List<Result> list = new ArrayList<>();

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                list.add(new Result(
                        rs.getInt("resultId"),
                        rs.getInt("studentId"),
                        rs.getInt("marks"),
                        rs.getString("grade")
                ));
            }
        }
        return list;
    }

    @Override
    public List<Result> getResultsByStudentId(int studentId) throws Exception {
        String sql = "SELECT * FROM results WHERE studentId = ? ORDER BY resultId";
        List<Result> list = new ArrayList<>();

        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, studentId);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new Result(
                            rs.getInt("resultId"),
                            rs.getInt("studentId"),
                            rs.getInt("marks"),
                            rs.getString("grade")
                    ));
                }
            }
        }
        return list;
    }

    @Override
    public boolean deleteResult(int resultId) throws Exception {
        String sql = "DELETE FROM results WHERE resultId = ?";
        try (Connection con = JDBCUtil.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, resultId);
            return ps.executeUpdate() > 0;
        }
    }
}

