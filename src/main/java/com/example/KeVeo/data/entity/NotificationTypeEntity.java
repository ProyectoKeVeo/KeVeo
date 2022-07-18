package com.example.KeVeo.data.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "type_notification")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class NotificationTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String type;

    private String enumerator;

    // Añado relación hacia NotificationEntity
    @OneToOne
    @JoinColumn(name = "notification_id", referencedColumnName = "id")
    private NotificationEntity notificationEntity;
}
