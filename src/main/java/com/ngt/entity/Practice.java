package com.ngt.entity;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "Practice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Practice {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid",strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "Name")
    private String name;

}
