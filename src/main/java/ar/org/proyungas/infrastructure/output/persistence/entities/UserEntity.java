package ar.org.proyungas.infrastructure.output.persistence.entities;


import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Table(name = "usuarios")
public class UserEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name ="cuit_cuil", unique=true,length=20, nullable = false)
	private String username;
	
	@Column(name ="nombre_completo", length=200, nullable = false)
	private String fullname;
	
	@Column(name ="email", length=254, nullable = false)
	private String email;
	
	@Column(length=100)
	private String password;
	
	@Column(name ="estado")
	private Boolean enabled;
	
	@ManyToMany(fetch=FetchType.LAZY)
	@JoinTable(name="users_roles",joinColumns=@JoinColumn(name="usuario_id"),
	inverseJoinColumns=@JoinColumn(name="rol_id"),
	uniqueConstraints = {@UniqueConstraint(columnNames= {"usuario_id","rol_id"})})
	private List<RoleEntity> roles;
}
