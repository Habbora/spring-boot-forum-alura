package br.com.habbora.alura.forum.api.config.security;

import br.com.habbora.alura.forum.modelo.Usuario;
import br.com.habbora.alura.forum.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AutenticacaoService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByEmail(username);
        if(!optionalUsuario.isPresent()) throw new UsernameNotFoundException("Usuario não existe.");
        return optionalUsuario.get();
    }
}
