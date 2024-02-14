package com.joanes.demoparkapi.service;

import com.joanes.demoparkapi.entity.Vaga;
import com.joanes.demoparkapi.exception.CodigoUniqueViolationException;
import com.joanes.demoparkapi.exception.EntityNotFoundException;
import com.joanes.demoparkapi.repository.VagaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static com.joanes.demoparkapi.entity.Vaga.StatusVaga.LIVRE;

@Service
@RequiredArgsConstructor
public class VagaService {

    private final VagaRepository vagaRepository;
    @Transactional
    public Vaga salvar(Vaga vaga){
        try{
            return vagaRepository.save(vaga);
        }catch (DataIntegrityViolationException ex){
            throw new CodigoUniqueViolationException(
                    String.format("Vaga com código '%s' já cadastrada", vaga.getCodigo())
            );
        }
    }
    @Transactional(readOnly = true)
    public Vaga buscarPorCodigo(String codigo){
        return vagaRepository.findByCodigo(codigo).orElseThrow(
                () -> new EntityNotFoundException(String.format("Vaga com código '%s' não foi encontrada", codigo))
        );
    }
    @Transactional(readOnly = true)
    public Vaga buscarPorVagaLivre() {
        return vagaRepository.findFirstByStatus(LIVRE).orElseThrow(
                () -> new EntityNotFoundException(String.format("Nenhuma vaga livre foi encontrada."))
        );
    }
}
