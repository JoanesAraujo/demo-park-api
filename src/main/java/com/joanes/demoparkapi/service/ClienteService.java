package com.joanes.demoparkapi.service;

import com.joanes.demoparkapi.entity.Cliente;
import com.joanes.demoparkapi.exception.CpfUniqueViolationException;
import com.joanes.demoparkapi.repository.ClienteRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente){
        try{
            return clienteRepository.save(cliente);
        } catch (DataIntegrityViolationException exception){
            throw new CpfUniqueViolationException(
                    String.format("CPF '%s' não pode ser cadastrado, já existe no sistema", cliente.getCpf())
            );
        }
    }

    @Transactional(readOnly = true)
    public Cliente buscarPorId(Long id) {
        return clienteRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException(String.format("Cliente id=%s não encontrado no sistema", id))
        );
    }
}