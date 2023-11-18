package com.aktie.infra.mercadopago.repository;

import java.util.UUID;

import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.eclipse.microprofile.rest.client.inject.RestClient;

import com.aktie.domain.dto.PixDTO;
import com.aktie.domain.repositories.IPixRepository;
import com.aktie.infra.mercadopago.dto.MpPixDTO;
import com.aktie.infra.mercadopago.dto.MpPixPayerDTO;
import com.aktie.infra.mercadopago.dto.MpPixResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class MpPixRepository implements IPixRepository {

    @Inject
    @RestClient
    RestClientMp restClient;

    @ConfigProperty(name = "mp.token")
    String mpToken;

    private final String MP_PAYMENT_ID = "pix";

    @Override
    public PixDTO create(PixDTO dto) {
        // Lógica da request para o MP
        String token = "Bearer ".concat(mpToken);
        String idempotencyKey = UUID.randomUUID().toString();

        MpPixPayerDTO payerDTO = new MpPixPayerDTO();
        MpPixDTO pixDTO = new MpPixDTO();
        payerDTO.setEmail(dto.getEmail());

        pixDTO.setAmount(dto.getAmount());
        pixDTO.setDescription(dto.getDescription());
        pixDTO.setPaymentMethodId(MP_PAYMENT_ID);
        pixDTO.setPayer(payerDTO);

        MpPixResponse response = restClient.createPix(token, idempotencyKey, pixDTO);

        dto.setEmv(response.getPoi().getTrxData().getEmv());
        dto.setBase64(response.getPoi().getTrxData().getBase64());

        return dto;
    }

}
