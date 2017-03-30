package com.example.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;

import com.querydsl.sql.ColumnMetadata;
import java.sql.Types;




/**
 * QComment is a Querydsl query type for QComment
 */
@Generated("com.querydsl.sql.codegen.MetaDataSerializer")
public class QComment extends com.querydsl.sql.RelationalPathBase<QComment> {

    private static final long serialVersionUID = 781895879;

    public static final QComment comment = new QComment("COMMENT");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> postId = createNumber("postId", Long.class);

    public final StringPath text = createString("text");

    public final com.querydsl.sql.PrimaryKey<QComment> constraint6 = createPrimaryKey(id);

    public final com.querydsl.sql.ForeignKey<QPost> fks1slvnkuemjsq2kj4h3vhx7i1 = createForeignKey(postId, "ID");

    public QComment(String variable) {
        super(QComment.class, forVariable(variable), "PUBLIC", "COMMENT");
        addMetadata();
    }

    public QComment(String variable, String schema, String table) {
        super(QComment.class, forVariable(variable), schema, table);
        addMetadata();
    }

    public QComment(String variable, String schema) {
        super(QComment.class, forVariable(variable), schema, "COMMENT");
        addMetadata();
    }

    public QComment(Path<? extends QComment> path) {
        super(path.getType(), path.getMetadata(), "PUBLIC", "COMMENT");
        addMetadata();
    }

    public QComment(PathMetadata metadata) {
        super(QComment.class, metadata, "PUBLIC", "COMMENT");
        addMetadata();
    }

    public void addMetadata() {
        addMetadata(id, ColumnMetadata.named("ID").withIndex(1).ofType(Types.BIGINT).withSize(19).notNull());
        addMetadata(postId, ColumnMetadata.named("POST_ID").withIndex(3).ofType(Types.BIGINT).withSize(19));
        addMetadata(text, ColumnMetadata.named("TEXT").withIndex(2).ofType(Types.VARCHAR).withSize(255));
    }

}

