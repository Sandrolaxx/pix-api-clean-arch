package com.aktie.controllers;

import com.aktie.domain.dto.PixDTO;
import com.aktie.service.PixService;

import jakarta.inject.Inject;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("/v1")
public class PixController {

    @Inject
    PixService service;

    @POST
    @Path("/pix")
    @Produces(MediaType.APPLICATION_JSON)
    public PixDTO create(PixDTO dto) {
        return service.genPix(dto);
    }
}
