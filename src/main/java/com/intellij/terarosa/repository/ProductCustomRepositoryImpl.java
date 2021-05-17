package com.intellij.terarosa.repository;

import com.intellij.terarosa.domain.Product;
import com.intellij.terarosa.domain.QProduct;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class ProductCustomRepositoryImpl extends QuerydslRepositorySupport implements ProductCustomRepository {
    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param domainClass must not be {@literal null}.
     */

    @PersistenceContext
    private EntityManager entityManager;
    QProduct product = QProduct.product;

    public ProductCustomRepositoryImpl() {
        super(Product.class);
    }


    @Override
    public List<Product> findListOrderBy(String value) {
        JPAQuery<Product> query = new JPAQuery<>(entityManager);
        query.select(product).from(product);
        if (value != null) {
            switch (value) {
                case "create_date":
                    query.orderBy(product.createDate.desc());
                    query.limit(4);
                    break;
                case "count":
                    query.orderBy(product.count.desc());
                    query.limit(3);
                    break;
                default:
                    break;
            }
        }
        return query.fetch();
    }
}
