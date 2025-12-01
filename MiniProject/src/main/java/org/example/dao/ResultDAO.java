package org.example.dao;

import org.example.model.Result;
import java.util.List;

public interface ResultDAO {

    // Add new result
    int addResult(Result result) throws Exception;

    // Update existing result
    boolean updateResult(Result result) throws Exception;

    // Get all results
    List<Result> getAllResults() throws Exception;

    // Get results by student ID
    List<Result> getResultsByStudentId(int studentId) throws Exception;

    // Delete result
    boolean deleteResult(int resultId) throws Exception;
}

