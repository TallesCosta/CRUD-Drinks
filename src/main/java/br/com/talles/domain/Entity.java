package br.com.talles.domain;

import java.util.Date;
import java.util.Objects;

public class Entity {
    
    private Long id;
    private Date createdDate;
    private Date updatedDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreateDate() {
        return createdDate;
    }

    public void setCreateDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdateDate() {
        return updatedDate;
    }

    public void setUpdateDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public Entity() {
    }

    public Entity(Date createdDate, Date updatedDate) {
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
		
        if (obj == null || getClass() != obj.getClass())
            return false;
        
        final Entity other = (Entity) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }
    
}
