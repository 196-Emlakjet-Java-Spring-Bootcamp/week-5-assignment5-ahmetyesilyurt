package com.ysl.rabbitmq.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "sale_advertisements")
public class SaleAdvertisement {
    //Many
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long saleId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String photo;

    @Column(columnDefinition = "text", nullable = false)
    private String detailMessage;

    private String priceGraphPath;

    private Long price;

    @CreationTimestamp
    @JsonFormat(pattern = "dd.MM.YYYY")
    private Date createdAt;

    @ManyToOne
    @JoinColumn(name = "user_fk", insertable = false, updatable = false)
    @JsonIgnore
    private User user;

    @Column(name = "user_fk")
    private Long userFk;

}
