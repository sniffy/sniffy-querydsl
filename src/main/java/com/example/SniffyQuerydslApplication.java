package com.example;

import com.example.domain.QComment;
import com.example.domain.QPost;
import com.querydsl.sql.Configuration;
import com.querydsl.sql.MySQLTemplates;
import com.querydsl.sql.SQLQueryFactory;
import com.querydsl.sql.SQLTemplates;
import com.querydsl.sql.spring.SpringConnectionProvider;
import com.querydsl.sql.spring.SpringExceptionTranslator;
import io.sniffy.boot.EnableSniffy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.inject.Provider;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author Robert Hunt
 */
@Controller
@EnableSniffy
@SpringBootApplication
public class SniffyQuerydslApplication
{
	@Autowired
    DataSource dataSource;

    @Bean
    public Configuration querydslConfiguration()
    {
        SQLTemplates templates = MySQLTemplates.builder().build();
        Configuration configuration = new com.querydsl.sql.Configuration(templates);
        configuration.setExceptionTranslator(new SpringExceptionTranslator());
        return configuration;
    }

    @Bean
    public SQLQueryFactory queryFactory()
    {
        Provider<Connection> provider = new SpringConnectionProvider(dataSource);
        return new SQLQueryFactory(querydslConfiguration(), provider);
    }

	@GetMapping("/")
    @Transactional
    @ResponseBody
	public String index() throws SQLException
    {
        QPost post = QPost.post;
        QComment comment = QComment.comment;

        queryFactory()
                .select(post.all())
                .from(post)
                .leftJoin(comment).on(post.id.eq(comment.postId))
                .fetch();

		return "default";
	}

    public static void main(String[] args)
    {
        SpringApplication.run(SniffyQuerydslApplication.class, args);
    }
}
