package com.mitienda.repository.Impl;

import com.mitienda.dto.UsuarioDTO;
import com.mitienda.repository.UsuarioDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;


@Repository("usuarioImpl")
public class UsuarioDAOImpl implements UsuarioDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public UsuarioDTO getUsuario(String id) {
        String sql = "SELECT id_usuario, nombre, correo, contraseña, rol FROM usuarios WHERE id_usuario = ?";
    
        return jdbcTemplate.queryForObject(
            sql,
            new Object[]{id},   // <-- Aquí un array de parámetros
            (rs, rowNum) -> {
                UsuarioDTO usuario = new UsuarioDTO();
                usuario.setIdUsuario(rs.getInt("id_usuario"));
                usuario.setNombre(rs.getString("nombre"));
                usuario.setCorreo(rs.getString("correo"));
                usuario.setContraseña(rs.getString("contraseña"));
                usuario.setRol(rs.getString("rol"));
                return usuario;
            }
        );
    }
}
