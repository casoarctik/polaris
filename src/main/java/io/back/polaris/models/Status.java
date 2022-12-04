package io.back.polaris.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "status", schema = "polaris_db_a")
public enum Status {
    OPEN,
    ANALYSIS,
    ITEM_FIND,
    DOWNLOAD,
    FIRST_VALIDATION,
    LAST_VALIDATION,
    REJECT,
    STANDBY,
    COMPLETE,
    STOP,
    ABANDON;

    @Id
    public final byte id = (byte)ordinal();

    @Column(unique = true, nullable = false)
    public final String code = name();
  
    Status() {
    }

    public String getCode() {
        return code;
    }    
}
