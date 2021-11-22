package com.example.mail_sender.service.impl;

import com.example.mail_sender.service.QueryService;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionImpl;
import org.hibernate.jdbc.Work;
import org.postgresql.jdbc.PgConnection;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.sql.*;
import java.util.*;
import java.util.Date;
import java.util.concurrent.atomic.AtomicInteger;


@Service
public class QueryServiceImpl implements QueryService {

    @PersistenceContext
    private EntityManager entityManager;

    @SneakyThrows
    @Override
    public List<Integer> executeParametrizedUpdate(String sql, Object... params) {
        final List<Integer> list = new ArrayList<>();
        Session session = (Session) entityManager.getDelegate();

        session.doWork(con -> {
            try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);) {
                AtomicInteger i = new AtomicInteger(1);
                Arrays.stream(params).forEach(o -> setValue(stmt, i.getAndIncrement(), o));
                stmt.executeUpdate();
                if (stmt.getGeneratedKeys() != null) {
                    try (ResultSet keys = stmt.getGeneratedKeys()) {
                        while (keys.next()) {
                            list.add(keys.getInt(1));
                        }
                    }
                }
            } catch (Exception e) {
                throw new RuntimeException("Update cannot be processed", e);
            }
            finally {
                con.close();
            }
        });

        return list;


//        Connection con = entityManager.unwrap(Connection.class);
//        try (PreparedStatement stmt = con.prepareStatement(sql);) {
//            AtomicInteger i = new AtomicInteger(1);
//            Arrays.stream(params).forEach(o -> setValue(stmt, i.getAndIncrement(), o));
//            stmt.executeUpdate();
//            if (stmt.getGeneratedKeys() != null) {
//                try (ResultSet keys = stmt.getGeneratedKeys()) {
//                    List<Integer> list = new ArrayList<>();
//                    while (keys.next()) {
//                        list.add(keys.getInt(1));
//                    }
//                    return list;
//                }
//            }
//            return Collections.emptyList();
//        } catch (Exception e) {
//            throw new RuntimeException("Update cannot be processed", e);
//        }
//        finally {
//            con.close();
//        }
    }

    private void setValue(PreparedStatement stmt, int index, Object o) {
        try {
            if (o == null) {
                stmt.setObject(index, null);
            }
            if (o instanceof String) {
                stmt.setString(index, (String) o);
            } else if (o instanceof Date) {
                stmt.setDate(index, new java.sql.Date(((Date) o).getTime()));
            } else if (o instanceof Long) {
                stmt.setLong(index, (Long) o);
            } else if (o instanceof Integer) {
                stmt.setInt(index, (Integer) o);
            } else if (o instanceof Double) {
                stmt.setDouble(index, (Double) o);
            } else if (o instanceof Float) {
                stmt.setFloat(index, (Float) o);
            } else if (o instanceof Boolean) {
                stmt.setBoolean(index, (Boolean) o);
            } else {
                throw new RuntimeException("Parameter with type " + o.getClass().getCanonicalName() + " is not presented yet!");
            }
        } catch (SQLException e) {
            throw new RuntimeException("Wrong parameter type!", e);
        }

    }
}
