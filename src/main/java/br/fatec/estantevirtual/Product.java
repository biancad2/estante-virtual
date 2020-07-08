package br.fatec.estantevirtual;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


import javax.persistence.Id;
import java.math.BigDecimal;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.io.Serializable;
import java.util.Objects;

@Table(name = "tb_produto")
@Entity
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long id;

	@Column
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	@Column
	private BigDecimal price;
	
	public Product() {
		
	}
	
	 public Product(String name, BigDecimal price) {
	        this.name = name;
	        this.price = price;
	    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + 
                 Objects.hashCode(this.id != null ? this.id : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        final Product other = (Product) obj;
        return Objects.equals(this.id, other.id);
    }

	
}
