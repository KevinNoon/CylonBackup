package com.optimised.cylonbackup.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Setter
@Getter
@ToString

@Table (name = "Site", uniqueConstraints = @UniqueConstraint(columnNames = {"Directory","Name"}))

public class Site implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "site_Number")
      private Integer siteNumber;
      private String directory;
      private String iDCode;
      private Integer internet;
      private String iPAddr;
      private String name;
      private Integer network;
      private Integer port;
      private Integer remote;
      private String telephone;
    private Boolean existing;
}
