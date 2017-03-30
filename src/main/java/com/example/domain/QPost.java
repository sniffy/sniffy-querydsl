package com.example.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QPost is a Querydsl query type for QPost
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QPost extends com.querydsl.sql.RelationalPathBase<QPost> {

    private static final long serialVersionUID = -999549128;

    public static final QPost post = new QPost("POST");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath title = createString("title");

    public final com.querydsl.sql.PrimaryKey<QPost> constraint2 = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<QComment> _fks1slvnkuemjsq2kj4h3vhx7i1 = createInvForeignKey(id, "POST_ID");

    public QPost(String variable) {
        super(QPost.class, forVariable(variable), "PUBLIC", "POST");
        addMetadata();
    }

    public QPost(String variable, String schema, String table) {
        super(QPost.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QPost(String variable, String schema) {
        super(QPost.class, forVariable(variable), schema, "POST");
        addMetadata();
    }

    public QPost(Path<? extends QPost> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "POST");
        addMetadata();
    }

    public QPost(PathMetadata metadata) {
        super(QPost.class, metadata, "PUBLIC", "POST");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(title, ColumnMetadata.named("TITLE").withIndex(2).ofType(Types.VARCHAR).withSize(255));
    }

}

