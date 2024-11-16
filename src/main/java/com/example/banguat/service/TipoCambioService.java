package com.example.banguat.service;

import com.example.banguat.entity.TipoCambioEntity;
import com.example.banguat.repository.TipoCambioRepository;
import com.example.banguat.wsdl.TipoCambio;
import com.example.banguat.wsdl.TipoCambioSoap;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TipoCambioService {

    private final TipoCambioRepository repository;

    public String consultarTipoCambio() {
        try {
            // Crear el cliente SOAP
            TipoCambio service = new TipoCambio();
            TipoCambioSoap soapClient = service.getTipoCambioSoap();

            // Generar número de solicitud único
            String numeroSolicitud = UUID.randomUUID().toString();

            // Llamar al servicio SOAP
            String resultado = soapClient.tipoCambioDiaString();

            // Guardar en la base de datos
            TipoCambioEntity entity = new TipoCambioEntity();
            entity.setNumeroSolicitud(numeroSolicitud);
            entity.setRespuesta(resultado);
            entity.setFechaConsulta(LocalDateTime.now());
            repository.save(entity);

            return resultado;
        } catch (Exception e) {
            throw new RuntimeException("Error al consultar el tipo de cambio: " + e.getMessage(), e);
        }
    }
}