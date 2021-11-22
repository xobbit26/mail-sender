package com.example.mail_sender.service;

import java.util.List;

public interface QueryService {
    List<Integer> executeParametrizedUpdate(String sql, Object... params);
}
