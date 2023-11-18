package com.aktie.infra.mercadopago.repository;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import com.aktie.infra.mercadopago.dto.MpPixDTO;
import com.aktie.infra.mercadopago.dto.MpPixResponse;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.HeaderParam;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;

@ApplicationScoped
@RegisterRestClient(configKey = "base-uri-mp")
public interface RestClientMp {

    @POST
    @Path("/v1/payments")
    @Consumes(MediaType.APPLICATION_JSON)
    MpPixResponse createPix(
            @HeaderParam("Authorization") String token,
            @HeaderParam("X-Idempotency-Key") String idempotency,
            MpPixDTO payload);

}
